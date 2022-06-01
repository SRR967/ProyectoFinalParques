package componentes;

import enumeraciones.Color;
import estructuras.Casilla;
import estructuras.Ficha;
import estructuras.TipoCasilla;

public class Tablero {

    private Casilla[] casillas;
    private Utilidades utilidades = new Utilidades();
    private Ficha ficha = new Ficha();
    private Casilla casilla;

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
        int j = 0;
        int k = 0;

        Casilla casillaAnterior = null;
        for(int i = 0; i < numCasillasLineales; i++) {
            var casillaActual = new Casilla();
            casillaActual.id = i;
            casillaActual.tipo = TipoCasilla.NORMAL;

            //En estos nodos ubico un nodo tipo SEGURO
            if (i==12 || i==29 || i==46 || i==63){
                casillaActual.tipo = TipoCasilla.SEGURO;
            }
            // Cada 17 nodos ubico un nodo tipo  PUERTA_CIELO
            if(i % 17 == 0) {
                casillaActual.tipo = TipoCasilla.PUERTA_CIELO;
            }
            // En estos nodos ubico un nodo tipo SALIDA
            if (i==5 || i==22 ||i==39||i==56){
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
    public void construirCarcel(){

        for (int i=0; i<utilidades.carcelAmarillo.length;i++){
            utilidades.carcelAmarillo[i]= ficha ;
        }
    }
    public  void crearFichas (){
        for (int i= 0; i<4; i++){
            Ficha fichaAux = new Ficha();
            fichaAux.setColor(Color.AMARILLO);
            utilidades.carcelAmarillo.add(fichaAux);
        }
        for (int i= 0; i<4; i++){
            Ficha fichaAux = new Ficha();
            fichaAux.color = Color.AZUL;
            utilidades.carcelAzul[i] = fichaAux;
        }
        for (int i= 0; i<4; i++){
            Ficha fichaAux = new Ficha();
            fichaAux.setColor(Color.ROJO);
            utilidades.carcelRojo.add(fichaAux);
        }
        for (int i= 0; i<4; i++){
            Ficha fichaAux = new Ficha();
            fichaAux.setColor(Color.VERDE);
            utilidades.carcelVerde.add(fichaAux);
        }

    }

}
