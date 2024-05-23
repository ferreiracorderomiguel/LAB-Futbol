package fp.futbol;

import fp.utiles.Checkers;

public record ResultadoParcial(Integer minuto, Integer golesLocal, Integer golesVisitante) {
	
	public ResultadoParcial {
		Checkers.check("Los minutos deben ser mayores o iguales que cero.", minuto >= 0);
		Checkers.check("Los goles locales deben ser mayores o iguales que cero.", golesLocal >= 0);
		Checkers.check("Los goles visitantes deben ser mayores o iguales que cero.", golesVisitante >= 0);
	}
}
