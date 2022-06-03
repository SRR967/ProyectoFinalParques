package componentes;

import enumeraciones.Color;
import estructuras.Casilla;
import estructuras.Dado;
import estructuras.Ficha;
import estructuras.TipoCasilla;

import java.util.ArrayList;

public class Tablero {

    private Casilla[] casillas;
    private Utilidades utilidades = new Utilidades();
    private Ficha ficha = new Ficha();
    private Casilla casilla;
    private Dado dado1;
    private Dado dado2;

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
            casillaActual.setId(i) ;
            casillaActual.tipo = TipoCasilla.NORMAL;

            //En estos nodos ubico un nodo tipo SEGURO
            if (i==12 || i==29 || i==46 || i==63){
                casillaActual.tipo = TipoCasilla.SEGURO;
            }
            // Cada 17 nodos ubico un nodo tipo  PUERTA_CIELO
            if(i % 17 == 0) {
                casillaActual.tipo = TipoCasilla.PUERTA_CIELO;
                casillaActual.color= utilidades.getColores().get(k);
                k++;
            }
            // En estos nodos ubico un nodo tipo SALIDA
            if (i==5 || i==22 ||i==39||i==56){
                casillaActual.tipo= TipoCasilla.SALIDA;
                casillaActual.color= utilidades.getColores().get(j);
                j++;
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

    public  void crearFichas (){
        for (int i= 0; i<4; i++){
            Ficha fichaAux = new Ficha();
            fichaAux.setColor(Color.AMARILLO);
            utilidades.getCarcelAmarillo().add(fichaAux);
        }
        for (int i= 0; i<4; i++){
            Ficha fichaAux = new Ficha();
            fichaAux.setColor(Color.AZUL);
            utilidades.getCarcelAzul().add(fichaAux);
        }
        for (int i= 0; i<4; i++){
            Ficha fichaAux = new Ficha();
            fichaAux.setColor(Color.ROJO);
            utilidades.getCarcelRojo().add(fichaAux);
        }
        for (int i= 0; i<4; i++){
            Ficha fichaAux = new Ficha();
            fichaAux.setColor(Color.VERDE);
            utilidades.getCarcelVerde().add(fichaAux);
        }

    }

    public void mover (Ficha ficha, Dado dadoTotal){



    }

    public void salirCarcel(ArrayList<Ficha> carcel){
        if (dado1.getNumero()==dado2.getNumero()){
            switch (carcel.get(0).getColor()){
            //solo para hacer el commit

                case AMARILLO ->{
                    for(int i = 0; i < 4; i++) {
                        this.getCasillas()[5].getFichas().add(new Ficha(Color.AMARILLO, this.getCasillas()[5]));
                    }
                }

                case VERDE -> {
                    for(int i = 0; i < 4; i++) {
                        this.getCasillas()[22].getFichas().add(new Ficha(Color.VERDE,this.getCasillas()[22]));
                    }
                }
                case ROJO -> {
                    for(int i = 0; i < 4; i++) {
                        this.getCasillas()[39].getFichas().add(new Ficha(Color.ROJO, this.getCasillas()[39]));
                    }
                }


                case AZUL -> {
                    for(int i = 0; i < 4; i++) {
                        this.getCasillas()[56].getFichas().add(new Ficha(Color.AZUL, this.getCasillas()[56]));
                    }


                }

            }

            carcel.removeAll(carcel);
        }


    }
    public void controlTurno (){

    }

}
