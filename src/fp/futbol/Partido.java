package fp.futbol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class Partido implements Comparable<Partido>{
	// Atributos
	private LocalDate fechaDelPartido;
	private String equipoLocal;
	private String equipoVisitante;
	private Long numeroDeEspectadores;
	private Competicion competicion;
	private List<ResultadoParcial> resultadosParciales;
	
	// Constructores
	public Partido(LocalDate fechaDelPartido, String equipoLocal, String equipoVisitante, Long numeroDeEspectadores,
			Competicion competicion, List<ResultadoParcial> resultadosParciales) {
		Checkers.check("Los minutos de los resultados parciales deben estar ordenados. Es decir, no puede haber una lista [42-1-1, 22-0-1].", comprobarResultadosOrdenados(resultadosParciales));
		this.fechaDelPartido = fechaDelPartido;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.numeroDeEspectadores = numeroDeEspectadores;
		this.competicion = competicion;
		this.resultadosParciales = resultadosParciales;
	}
	
	private Boolean comprobarResultadosOrdenados(List<ResultadoParcial> resultadosParciales2) {
		for (int i = 0; i < resultadosParciales.size() - 1; i++) {
            if (resultadosParciales.get(i).minuto() > resultadosParciales.get(i + 1).minuto()) {
                return false;
            }
        }
        return true;
	}

	// Métodos
	public Integer getGolesLocal() {
		if (resultadosParciales.isEmpty()) {
            return 0;
        } else {
            return resultadosParciales.get(resultadosParciales.size() - 1).golesLocal();
        }
	}
	
	public Integer getGolesVisitante() {
		if (resultadosParciales.isEmpty()) {
            return 0;
        } else {
            return resultadosParciales.get(resultadosParciales.size() - 1).golesVisitante();
        }
	}
	
	public List<Integer> getMinutos() {
		List<Integer> minutos = new ArrayList<>();
	    for (ResultadoParcial resultado : resultadosParciales) {
	        minutos.add(resultado.minuto());
	    }
	    return minutos;
	}
	
	public LocalDate getFechaDelPartido() {
		return fechaDelPartido;
	}

	public String getEquipoLocal() {
		return equipoLocal;
	}

	public String getEquipoVisitante() {
		return equipoVisitante;
	}

	public Long getNumeroDeEspectadores() {
		return numeroDeEspectadores;
	}

	public Competicion getCompeticion() {
		return competicion;
	}

	public List<ResultadoParcial> getResultadosParciales() {
		return resultadosParciales;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(equipoLocal, equipoVisitante, fechaDelPartido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		return Objects.equals(equipoLocal, other.equipoLocal) && Objects.equals(equipoVisitante, other.equipoVisitante)
				&& Objects.equals(fechaDelPartido, other.fechaDelPartido);
	}

	public int compareTo(Partido p) {
		int res = fechaDelPartido.compareTo(p.getFechaDelPartido());
		
		if (res == 0) {
			res = equipoLocal.compareTo(p.getEquipoLocal());
		}
		
		if (res == 0) {
			res = equipoVisitante.compareTo(p.getEquipoVisitante());
		}
		
		return res;
	}

	@Override
	public String toString() {
		return "Partido [fechaDelPartido=" + fechaDelPartido + ", equipoLocal=" + equipoLocal + ", equipoVisitante="
				+ equipoVisitante + ", numeroDeEspectadores=" + numeroDeEspectadores + ", competicion=" + competicion
				+ ", resultadosParciales=" + resultadosParciales + "]";
	}	
}