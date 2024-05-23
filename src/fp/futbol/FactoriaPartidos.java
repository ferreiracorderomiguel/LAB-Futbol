package fp.futbol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import fp.utiles.Checkers;




public class FactoriaPartidos {
	
	public static EstadisticasPartidos leePartidos(String ruta) {
		EstadisticasPartidos res = null;
		try {
			Stream<Partido> sv = Files.lines(Paths.get(ruta))
									    .skip(1)
										.map(FactoriaPartidos::parseaPartido);
			res = new EstadisticasPartidos(sv);
		} catch (IOException e) {
			System.out.println("No se ha encontrado el fichero " + ruta);
			e.printStackTrace();
		}
		return res;
	}

	private static Partido parseaPartido(String cadena) {
		/*
		 * 
		 * fecha;equipo local; equipo visitante; espectadores; competicion;resultados parciales
			21/2/2023;CeltadeVigo;RealMadrid;39322;Liga;[22-1-0]
			2/7/2023;RealMadrid;Getafe;37999;Amistoso;[5-1-0]
			29/1/2023;Barcelona;AthleticClub;17466;Amistoso;[24-0-1,51-1-1,54-2-1,76-2-2,96-3-2]
			29/12/2023;Getafe;AtléticodeMadrid;32085;Supercopa;[19-1-0,28-1-1,51-1-2,69-1-3,77-2-3]
		 */
		String[] trozos = cadena.split(";");
		Checkers.check("Cadena mal troceada.", trozos.length == 6);
		
		LocalDate fechaDelPartido = LocalDate.parse(trozos[0].trim(), DateTimeFormatter.ofPattern("d/M/yyyy"));
		String equipoLocal = trozos[1].trim();
		String equipoVisitante = trozos[2].trim();
		Long numeroDeEspectadores = Long.parseLong(trozos[3].trim());
		Competicion competicion = Competicion.valueOf(trozos[4].trim().toUpperCase());
		List<ResultadoParcial> resultadosParciales = parseaListaResultados(trozos[5].trim());
		
		return new Partido(fechaDelPartido, equipoLocal, equipoVisitante, numeroDeEspectadores, competicion, resultadosParciales);
	}

	private static List<ResultadoParcial> parseaListaResultados(String trim) {
		List<ResultadoParcial> res = new ArrayList<ResultadoParcial>();
		// [19-1-0,28-1-1,51-1-2,69-1-3,77-2-3]
		
		trim = trim.replace("[", "").replace("]", "");
		String[] trozos = trim.split(",");
		
		for (int i=0; i<trozos.length; i++) {
			String[] valoresResultado = trozos[i].trim().split("-");
			Integer minuto = Integer.parseInt(valoresResultado[0].trim());
			Integer golesLocal = Integer.parseInt(valoresResultado[1].trim());
			Integer golesVisitante = Integer.parseInt(valoresResultado[2].trim());
			res.add(new ResultadoParcial(minuto, golesLocal, golesVisitante));
		}
		
		return res;
	}

}