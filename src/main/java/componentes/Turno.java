package componentes;

import estructuras.Jugador;


public class Turno {

    private Jugador[] jugadores;

    public void inicializar(int numJugadores){
        contruirJugadores(numJugadores);
    }

    private void contruirJugadores(int numJugadores){
        jugadores = new Jugador[numJugadores];
        Jugador jugadorAnterior = null;

        for(int i = 0; i < numJugadores; i++) {
            var jugadorActual = new Jugador();
            jugadorActual.numJugador = "" + i;

            if(i != 0) {
                // Si es el ultimo jugador
                if(i == numJugadores - 1) {
                    // Utilizo el primer jugador como jugador siguiente
                    jugadorActual.siguiente = jugadores[0];
                }
                jugadorAnterior.siguiente = jugadorActual;
                jugadorActual.anterior = jugadorAnterior;
            }
            jugadores[i] = jugadorActual;
            jugadorAnterior = jugadorActual;
        }
        // Defino el jugador anterior del primer jugador
        // El jugador anterior es el ultimo jugador
        jugadores[0].anterior = jugadorAnterior;
    }

    public Jugador[] getJugadores(){return jugadores;}
}
