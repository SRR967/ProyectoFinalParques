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
            fichaAux.setColor(Color.ROJO);
            utilidades.getCarcelRojo().add(fichaAux);
        }
        for (int i= 0; i<4; i++){
            Ficha fichaAux = new Ficha();
            fichaAux.setColor(Color.VERDE);
            utilidades.getCarcelVerde().add(fichaAux);
        }
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

    }

    public void pruebas(Casilla casillaActual, int dadoTotal){
        //Por si se hacen mas vainas
    }


    public void mover (Ficha ficha, int dadoTotal){
        Casilla casillaActual = ficha.getCasilla();

        for(int i = 0; i < dadoTotal ; i++){

               if (casillaActual.tipo == TipoCasilla.PUERTA_CIELO && casillaActual.color == ficha.getColor()){
                   llegarCaminoCielo(ficha,dadoTotal);


               }else {
                   casillaActual = casillaActual.siguiente;
               }
        }

        //Modificar datos para coincidir con el nuevo destino
        casillaActual.getFichas().add(ficha); //Añadir ficha al arraylist de la casilla destino

        int indexPosAnterior = ficha.getCasilla().getFichas().indexOf(ficha);
        ficha.getCasilla().getFichas().remove(indexPosAnterior); // Eliminar la casilla anterior de la ficha

        ficha.setCasilla(casillaActual); //Setear el nuevo dato de casilla en ficha
    }

    public void comer(Ficha ficha){

        ficha.setCasilla(null);

        switch(ficha.getColor()){

            case ROJO -> {
                ficha.getCasilla().getFichas().remove(ficha);
                utilidades.getCarcelRojo().add(ficha);
            }
            case VERDE -> {
                ficha.getCasilla().getFichas().remove(ficha);
                utilidades.getCarcelVerde().add(ficha);
            }
            case AMARILLO -> {
                ficha.getCasilla().getFichas().remove(ficha);
                utilidades.getCarcelAmarillo().add(ficha);
            }
            case AZUL -> {
                ficha.getCasilla().getFichas().remove(ficha);
                utilidades.getCarcelAzul().add(ficha);
            }

        }

    }

    //Se toma por hecho que hay al menos una ficha en la carcel
    public void salirCarcelTurno(Color colorTurno){

        switch(colorTurno){
            case ROJO -> {
                utilidades.getCarcelRojo().remove(0);
                this.getCasillas()[5].getFichas().add(new Ficha(Color.ROJO, this.getCasillas()[5]));
            }
            case VERDE -> {
                utilidades.getCarcelVerde().remove(0);
                this.getCasillas()[22].getFichas().add(new Ficha(Color.VERDE,this.getCasillas()[22]));
            }

            case AMARILLO -> {
                utilidades.getCarcelAmarillo().remove(0);
                this.getCasillas()[39].getFichas().add(new Ficha(Color.AMARILLO, this.getCasillas()[39]));
            }

            case AZUL -> {
                utilidades.getCarcelAzul().remove(0);
                this.getCasillas()[56].getFichas().add(new Ficha(Color.AZUL, this.getCasillas()[56]));


            }
        }

    }

    //@TODO Preguntar sobre la implementacion de esta vaina con el control de juego
    public void salirCarcelInicio(ArrayList<Ficha> carcel){
        if (dado1.getNumero()==dado2.getNumero()){
            switch (carcel.get(0).getColor()){

                case ROJO -> {
                    for(int i = 0; i < 4; i++) {
                        this.getCasillas()[5].getFichas().add(new Ficha(Color.ROJO, this.getCasillas()[5]));
                    }
                }

                case VERDE -> {
                    for(int i = 0; i < 4; i++) {
                        this.getCasillas()[22].getFichas().add(new Ficha(Color.VERDE,this.getCasillas()[22]));
                    }
                }

                case AMARILLO ->{
                    for(int i = 0; i < 4; i++) {
                        this.getCasillas()[39].getFichas().add(new Ficha(Color.AMARILLO, this.getCasillas()[39]));
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
