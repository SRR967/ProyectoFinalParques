package componentes;

import enumeraciones.Color;
import estructuras.Casilla;
import estructuras.TipoCasilla;

public class Tablero {

    private Casilla[] casillas;

    public Casilla[] getCasillas() {
        return casillas;
    }

    public void inicializar(int numCasillasLineales) {
        construirCasillas(numCasillasLineales);
    }

    /***
     * Construye el vector de casillas del tablero
     * @param numCasillasLineales Define el numero de casillas a construir
     */
    private void construirCasillas(int numCasillasLineales) {
        casillas = new Casilla[numCasillasLineales];

        Casilla casillaAnterior = null;
        for(int i = 0; i < numCasillasLineales; i++) {
            var casillaActual = new Casilla();
            casillaActual.id = i;
            casillaActual.tipo = TipoCasilla.NORMAL;

            // Cada 17 nodos ubico un nodo tipo
            if(i % 17 == 0) {
                casillaActual.tipo = TipoCasilla.PUERTA_CIELO;
            }

            if (i==5){
                casillaActual.tipo= TipoCasilla.SALIDA;
            }



            if(i != 0) {
                // Si es la ultima casilla
                if(i == numCasillasLineales - 1) {
                    // Utilizo la primer casilla como casilla siguiente
                    casillaActual.siguiente = casillas[0];
                }
                casillaAnterior.siguiente = casillaActual;
                casillaActual.anterior = casillaAnterior;
            }
            casillas[i] = casillaActual;
            casillaAnterior = casillaActual;
        }
        // Defino la casilla anterior de la primer casilla
        // La casilla anterior es la ultima casilla
        casillas[0].anterior = casillaAnterior;
    }

}
