package fp.futbol;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EstadisticasPartidos {
	// Atributos
	List<Partido> partidos;
	
	// Constructores
	public EstadisticasPartidos(Stream<Partido> stream) {
		this.partidos = stream.collect(Collectors.toList());
	}
	
	// Métodos
	public List<Partido> getPartidos() {
		return partidos;
	}
	
	public Integer getNumPartidos() {
		return partidos.size();
	}
	
	// Tratamientos secuenciales
	/**
	 * Dado un conjunto de equipos devuelve el total de goles marcados por esos equipos en todas las competiciones.
	 * @param equipos Conjunto de equipos.
	 * @return Total de goles marcados por los equipos, o null si no se puede calcular.
	 */
	public Integer getNumGolesEquipos(Set<String> equipos) {
	    return null;
	}

	/**
	 * Dado un valor minutoUmbral de tipo Integer devuelve el número de goles marcados con posterioridad a ese minuto en todos los partidos.
	 * @param minutoUmbral Minuto umbral.
	 * @return Número de goles marcados después del minuto umbral, o null si no se puede calcular.
	 */
	public Integer getNumGolesDespuesMinuto(Integer minutoUmbral) {
	    return null;
	}

	/**
	 * Dado un número entero n, devuelve un SortedSet con los n partidos con más espectadores.
	 * @param n Número de partidos a devolver.
	 * @return SortedSet con los n partidos con más espectadores, ordenados por número de goles de menor a mayor, o null si no se puede calcular.
	 */
	public SortedSet<Partido> getNPartidosMasEspectadores(Integer n) {
	    return null;
	}

	/**
	 * Dado un entero mes que representa un mes, devuelve la competición con más espectadores acumulados en ese mes.
	 * @param mes Mes.
	 * @return Competición con más espectadores acumulados en el mes dado, o null si no se puede calcular.
	 * @throws NoSuchElementException Si no se puede calcular la competición con más espectadores.
	 */
	public Competicion getCompeticionMasEspectadores(Integer mes) throws NoSuchElementException {
	    return null;
	}

	/**
	 * Obtiene un Map en el que a cada competición le hace corresponder el Partido con el gol más tardío.
	 * @return Map con la competición como clave y el partido con el gol más tardío como valor, o null si no se puede calcular.
	 */
	public Map<Competicion, Partido> getPartidoGolMasTardioPorCompeticion() {
	    return null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(partidos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadisticasPartidos other = (EstadisticasPartidos) obj;
		return Objects.equals(partidos, other.partidos);
	}

	@Override
	public String toString() {
		String res = "";
		
		for(Partido p: partidos) {
			res += p.toString() + "\n";
		}
		
		return "EstadisticasPartidos [partidos=" + res + "]";
	}
	
	
}