package fp.futbol;

import java.util.List;
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
}