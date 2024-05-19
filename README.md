# Fundamentos de Programación
# Curso 22-23. Segundo parcial. Sesión 1: Fútbol

**Autor:**  José C. Riquelme 
**Revisores:** Toñi Reina, Beatriz Pontes, Mariano González.
**Última modificación:** 29/05/2023.


Tenemos un conjunto de datos con resultados de partidos de fútbol con la siguiente estructura. Para cada partido se tiene la siguiente información:

- **Fecha del partido**: de tipo fecha.
- **Equipo local**: de tipo cadena.
- **Equipo visitante**: de tipo cadena.
- **Número de espectadores**: de tipo entero. 
- **Competición**: cadena que puede tomar los valores Liga, CopaDelRey, Supercopa, Amistoso.
- **ResultadosParciales**: lista con los resultados parciales del partido. Cada resultado parcial representa el minuto en el que se marcó el gol, los goles del equipo local y los del equipo visitante en el momento en el que se marcó el gol.

Por ejemplo, las dos líneas del fichero:

```
19/4/2023;Celta de Vigo;Villarreal;14467;Liga;[22-0-1,42-1-1,67-2-1]
21/3/2023;Mallorca;Espanyol;13780;Liga;[0-0-0]
```

indican que, entre el 19 de abril de 2023 jugaron un partido el Celta de Vigo como equipo local y el Villarreal como equipo visitante. El partido tuvo 14467 espectadores. Es un partido de la liga, y tiene tres resultados parciales: el primer resultado indica que en el minuto 22 marcó el Villarreal y el partido se puso (0-1); en el minuto 42 empató el equipo local (1-1), y finalmente, en el minuto 67 el equipo local volvió a marcar, terminando el partido 2-1. En la segunda línea, se representa que el partido acabó 0-0. 

Cree en el proyecto los paquetes fp.futbol, fp.futbol.test y fp.utiles, y dentro de ellos implemente los tipos que se piden a continuación.

**Ejercicio 1: Tipo Resultado (0,5 ptos)**

Implemente el tipo ResultadoParcial mediante un record, de acuerdo con la siguiente información:

Propiedades:

- **Minuto**: minuto en el que se marca el gol, de tipo Integer, consultable.
- **Goles local**: goles del equipo local, de tipo Integer, consultable.
- **Goles visitante**: goles del equipo visitante, de tipo Integer, consultable.

Constructores: 

- C1: recibe un parámetro por cada propiedad básica del tipo, en el mismo orden en el que están definidas.

Representación como cadena: una cadena con todas las propiedades básicas del tipo.

Restricciones:

- R1: Los minutos deben ser mayores o iguales que cero.
- R2: Los goles locales deben ser mayores o iguales que cero.
- R3: Los goles visitantes deben ser mayores o iguales que cero.

**Ejercicio 2: Tipo Partido (1,5 ptos)**

Implemente el tipo Partido mediante una clase de acuerdo con la siguiente descripción:

Propiedades:

- **Fecha del partido**: de tipo LocalDate, consultable.
- **Equipo local**: de tipo String, consultable.
- **Equipo visitante**: de tipo String, consultable.
- **Número de espectadores**: de tipo Long, consultable.
- **Competición**: de tipo Competicion, consultable. Puede tomar los valores LIGA, COPADELREY, SUPERCOPA, AMISTOSO.
- **ResultadosParciales**: de tipo List<Resultado>, consultable. Lista de objetos de tipo Resultado. Cada resultado representa el minuto en el que se marcó el gol, los goles del equipo local y los del equipo visitante en el momento en el que se marcó el gol.
- **Goles local**: de tipo Integer, consultable. Goles del equipo local al finalizar el partido.
- **Goles visitante**: de tipo Integer, consultable. Goles del equipo visitante al finalizar el partido.
- **Minutos:** de tipo List<Integer>, consultable. Lista con los minutos en los que se han marcado goles en el partido. Si en el partido no se han marcado goles, la lista estará vacía.

Constructores: 

- C1: recibe un parámetro por cada propiedad básicas del tipo.

Restricciones: 

- R1: Los minutos de los resultados parciales deben estar ordenados. Es decir, no puede haber una lista [42-1-1, 22-0-1].

Representación como cadena: una cadena con todas las propiedades básicas del tipo.

Criterio de igualdad: dos equipos son iguales si lo son sus fechas, su equipo local y su equipo visitante.

Criterio de ordenación: dos partidos se ordenan por fecha, a igualdad de fecha, por equipo local, y luego por equipo visitante.

**Ejercicio 3: Factoría (1 pto)**

En la clase FactoriaPartidos, que se le da parcialmente implementada, implemente el método:

- *Partido parsearPartido(String lineaCSV)*: crea un objeto de tipo Partido a partir de una cadena de caracteres. La cadena de caracteres debe tener el mismo formato que las líneas del fichero CSV.

**Ejercicio 4: Tratamientos secuenciales (7 ptos)**

El tipo EstadisticasPartidos tiene la siguiente descripción:

Propiedades:

- **partidos**: de tipo List<Partido>, consultable.
- **num partidos**: de tipo Integer, consultable. Número de partidos sobre el que se van a hacer las estadísticas.

Constructores: 

- C1: recibe un parámetro de tipo Stream<Partido>.

Representación como cadena: una cadena con todos los partidos, separados por salto de línea.

Criterio de igualdad: dos objetos de tipo EstadisticasPartidos son iguales si lo son sus partidos.

Implemente el tipo EstadisticasPartido en el paquete fp.futbol y añada también los siguientes tratamientos secuenciales al tipo EstadisticasPartidos. Debe resolver todos los métodos **mediante streams**, salvo que se le indique expresamente que debe utilizar bucles:

1. *Integer getNumGolesEquipos(Set<String> equipos)*: Dado un conjunto de equipos devuelve el total de goles marcados por esos equipos en todas las competiciones. **Implemente este método con bucles**. (*1 pto)*
1. *Integer getNumGolesDespuesMinuto(Integer minutoUmbral)*: dado un valor *minutoUmbral* de tipo Integer devuelve el número de goles marcados con posterioridad a ese minuto en todos los partidos. Tenga en cuenta que en cada resultado parcial se marca un solo gol. *(1 pto)*
1. *SortedSet<Partido> getNPartidosMasEspectadores(Integer n)*: Dado un  número entero n, devuelve un SortedSet con los n partidos con más espectadores. El conjunto estará ordenado por número de goles de menor a mayor.  Tenga en cuenta que si hay dos partidos con el mismo número de goles, ambos deberían incluirse en el conjunto resultado. *(1.5 ptos)*
1. *Competicion getCompeticionMasEspectadores(Integer mes)*: dado un entero *mes* que representa un mes, devuelve la competición con más espectadores acumulados en ese mes. Si no se puede calcular, se eleva *NoSuchElementException*. *(1.5 ptos)*
1. *Map<Competicion, Partido> getPartidoGolMasTardioPorCompeticion():* obtiene un Map en el que a cada competición le hace corresponder el Partido con el gol más tardío. Para resolver este ejercicio de forma más simple debe definir un método auxiliar adecuado en el tipo Partido*. (2 ptos)*

Escriba un test del tipo contenedor. En el test se leerán los datos del fichero CSV y se probarán todos los tratamientos secuenciales.

Los resultados esperados para el dataset proporcionado con los valores indicados en los tests son:

```
EJERCICIO 4.1===================================================================
El número total de goles de los equipos [Sevilla, RealBetis] es 41
El número total de goles de los equipos [RealMadrid, Barcelona] es 66

EJERCICIO 4.2===================================================================
El número total de goles después del minuto 90 es 17
El número total de goles después del minuto 100 es 4

EJERCICIO 4.3===================================================================
Los 3 partidos con más espectadores son
	Partido [fecha=2023-02-12, equipoLocal=Levante, equipoVisitante=AthleticClub, espectadores=49815, competicion=LIGA, resultadosParciales=[Resultado[minuto=12, golesLocal=0, golesVisitante=1]]]
	Partido [fecha=2023-07-17, equipoLocal=Alavés, equipoVisitante=RayoVallecano, espectadores=49903, competicion=SUPERCOPA, resultadosParciales=[Resultado[minuto=26, golesLocal=1, golesVisitante=0], Resultado[minuto=46, golesLocal=2, golesVisitante=0]]]
	Partido [fecha=2023-07-02, equipoLocal=RayoVallecano, equipoVisitante=Mallorca, espectadores=49635, competicion=SUPERCOPA, resultadosParciales=[Resultado[minuto=12, golesLocal=0, golesVisitante=1], Resultado[minuto=35, golesLocal=0, golesVisitante=2], Resultado[minuto=47, golesLocal=1, golesVisitante=2], Resultado[minuto=49, golesLocal=1, golesVisitante=3], Resultado[minuto=54, golesLocal=2, golesVisitante=3], Resultado[minuto=73, golesLocal=3, golesVisitante=3]]]

Los 5 partidos con más espectadores son
	Partido [fecha=2023-01-02, equipoLocal=RealBetis, equipoVisitante=RealSociedad, espectadores=49115, competicion=AMISTOSO, resultadosParciales=[Resultado[minuto=27, golesLocal=0, golesVisitante=1]]]
	Partido [fecha=2023-02-12, equipoLocal=Levante, equipoVisitante=AthleticClub, espectadores=49815, competicion=LIGA, resultadosParciales=[Resultado[minuto=12, golesLocal=0, golesVisitante=1]]]
	Partido [fecha=2023-07-17, equipoLocal=Alavés, equipoVisitante=RayoVallecano, espectadores=49903, competicion=SUPERCOPA, resultadosParciales=[Resultado[minuto=26, golesLocal=1, golesVisitante=0], Resultado[minuto=46, golesLocal=2, golesVisitante=0]]]
	Partido [fecha=2023-03-10, equipoLocal=Getafe, equipoVisitante=Espanyol, espectadores=49000, competicion=COPADELREY, resultadosParciales=[Resultado[minuto=28, golesLocal=1, golesVisitante=0], Resultado[minuto=48, golesLocal=1, golesVisitante=1], Resultado[minuto=68, golesLocal=2, golesVisitante=1], Resultado[minuto=88, golesLocal=3, golesVisitante=1]]]
	Partido [fecha=2023-07-02, equipoLocal=RayoVallecano, equipoVisitante=Mallorca, espectadores=49635, competicion=SUPERCOPA, resultadosParciales=[Resultado[minuto=12, golesLocal=0, golesVisitante=1], Resultado[minuto=35, golesLocal=0, golesVisitante=2], Resultado[minuto=47, golesLocal=1, golesVisitante=2], Resultado[minuto=49, golesLocal=1, golesVisitante=3], Resultado[minuto=54, golesLocal=2, golesVisitante=3], Resultado[minuto=73, golesLocal=3, golesVisitante=3]]]

EJERCICIO 4.4===================================================================
La competición con más espectadores del mes 1 es AMISTOSO
La competición con más espectadores del mes 10 es LIGA

EJERCICIO 4.5===================================================================
Los partidos con goles más tardíos por competición son: 
	SUPERCOPA=Partido [fecha=2023-10-11, equipoLocal=CeltadeVigo, equipoVisitante=Elche, espectadores=48112, competicion=SUPERCOPA, resultadosParciales=[Resultado[minuto=17, golesLocal=1, golesVisitante=0], Resultado[minuto=21, golesLocal=2, golesVisitante=0], Resultado[minuto=48, golesLocal=2, golesVisitante=1], Resultado[minuto=57, golesLocal=2, golesVisitante=2], Resultado[minuto=74, golesLocal=3, golesVisitante=2], Resultado[minuto=104, golesLocal=3, golesVisitante=3]]]
	AMISTOSO=Partido [fecha=2023-07-13, equipoLocal=RealBetis, equipoVisitante=Espanyol, espectadores=16854, competicion=AMISTOSO, resultadosParciales=[Resultado[minuto=14, golesLocal=1, golesVisitante=0], Resultado[minuto=42, golesLocal=1, golesVisitante=1], Resultado[minuto=65, golesLocal=1, golesVisitante=2], Resultado[minuto=85, golesLocal=1, golesVisitante=3], Resultado[minuto=101, golesLocal=2, golesVisitante=3]]]
	LIGA=Partido [fecha=2023-03-09, equipoLocal=RealBetis, equipoVisitante=Levante, espectadores=10760, competicion=LIGA, resultadosParciales=[Resultado[minuto=19, golesLocal=1, golesVisitante=0], Resultado[minuto=43, golesLocal=2, golesVisitante=0], Resultado[minuto=57, golesLocal=2, golesVisitante=1], Resultado[minuto=80, golesLocal=2, golesVisitante=2], Resultado[minuto=109, golesLocal=2, golesVisitante=3]]]
	COPADELREY=Partido [fecha=2023-11-21, equipoLocal=RayoVallecano, equipoVisitante=Villarreal, espectadores=26504, competicion=COPADELREY, resultadosParciales=[Resultado[minuto=22, golesLocal=1, golesVisitante=0], Resultado[minuto=34, golesLocal=2, golesVisitante=0], Resultado[minuto=54, golesLocal=2, golesVisitante=1], Resultado[minuto=76, golesLocal=2, golesVisitante=2], Resultado[minuto=104, golesLocal=3, golesVisitante=2]]]
```