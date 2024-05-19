package fp.futbol;

import java.io.IOException;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
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

	