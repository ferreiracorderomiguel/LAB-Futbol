package fp.futbol.test;

import fp.futbol.EstadisticasPartidos;
import fp.futbol.FactoriaPartidos;

public class TestEstadisticasPartidos {
	public static void main(String[] args) {
		EstadisticasPartidos estadisticasPartidos = FactoriaPartidos.leePartidos("data/partidos.txt");
		System.out.println("Número de registros leídos: " + estadisticasPartidos.getNumPartidos());
		System.out.println("\n3 primeros registros leídos: ");
		
		for (int i=0; i < 3; i++) {
			System.out.println(estadisticasPartidos.getPartidos().get(i));
		}
	}
}
