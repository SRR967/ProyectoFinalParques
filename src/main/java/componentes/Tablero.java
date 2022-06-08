package componentes;

import enumeraciones.Color;
import estructuras.*;

import java.util.ArrayList;

public class Tablero {
    private Casilla[] casillas;
    private Utilidades utilidades = new Utilidades();
    private Ficha ficha = new Ficha();
    private Casilla casilla;
    private Turno turnos = new Turno();
    private Dado dado1;
    private Dado dado2;

    public void inicializar(int numCasillasLineales) {

        construirCasillas(numCasillasLineales);
        turnos.inicializar(4);
        for(int i = 0; i < turnos.getJugadores().length; i++){
            turnos.getJugadores()[i].setColor(utilidades.getColores().get(i));
        }
        crearFichas();
        asignarColoresTurnos();
    }

    public void asignarColoresTurnos(){
        for(int i=0; i < turnos.getJugadores().length; i++){
            turnos.getJugadores()[i].setColor(utilidades.getColores().get(i));
            System.out.println("" + utilidades.getColores().get(i));
        }
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

    }

    private Utilidades util = new Utilidades();

    public void mover (Ficha ficha, int dadoTotal){
        Casilla casillaActual = ficha.getCasilla();

        for(int i = 0; i < dadoTotal ; i++){

               if (casillaActual.tipo == TipoCasilla.PUERTA_CIELO && casillaActual.color == ficha.getColor()){
                   //casillaActual = util.getCieloVerde().get(1);
                   llegarCaminoCielo(ficha,dadoTotal - i);


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

        ficha.setCasilla(null);
    }

    //Se toma por hecho que hay al menos una ficha en la carcel

    public void salirCarcelTurno(Color colorTurno) {
        switch (colorTurno) {
            case ROJO -> {
                utilidades.getCarcelRojo().remove(0);
                this.getCasillas()[5].getFichas().add(new Ficha(Color.ROJO, this.getCasillas()[5]));
            }
            case VERDE -> {
                utilidades.getCarcelVerde().remove(0);
                this.getCasillas()[22].getFichas().add(new Ficha(Color.VERDE, this.getCasillas()[22]));
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
    public boolean comprobarGanador(){
        if(utilidades.getCieloRojo().get(7).getFichas().size() >= 4){
            turnos.getJugadores()[0].setGanador(true);
            System.out.println("Rojo ha ganado");
            return true;
        }
        else if(utilidades.getCieloVerde().get(7).getFichas().size() >= 4){
            turnos.getJugadores()[1].setGanador(true);
            System.out.println("Azul ha ganado");
            return true;
        }
        else if(utilidades.getCieloAmarillo().get(7).getFichas().size() >= 4){
            turnos.getJugadores()[2].setGanador(true);
            System.out.println("Amarillo ha ganado");
            return true;
        }
        else if(utilidades.getCieloAzul().get(7).getFichas().size() >= 4){
            turnos.getJugadores()[3].setGanador(true);
            System.out.println("Azul ha ganado");
            return true;
        }
        else{
            return false;
        }
    }

    //@TODO Preguntar sobre la implementacion de esta vaina con el control de juego

    public void salirCarcelInicio(ArrayList<Ficha> carcel){
        //if (dado1.getNumero()==dado2.getNumero()){
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
        //}


    }
    //Llegar camino cielo
    public void llegarCaminoCielo(Ficha ficha, int nuevoDado){

        switch (ficha.getColor()){
            case ROJO -> {
                utilidades.getCieloRojo().get(nuevoDado - 1).getFichas().add(ficha);
                ficha.getCasilla().getFichas().remove(ficha);
                ficha.setCasilla(utilidades.getCieloRojo().get(nuevoDado - 1));
            }

            case VERDE -> {
                utilidades.getCieloVerde().get(nuevoDado - 1).getFichas().add(ficha);
                ficha.getCasilla().getFichas().remove(ficha);
                ficha.setCasilla(utilidades.getCieloVerde().get(nuevoDado - 1));
            }

            case AMARILLO -> {
                utilidades.getCieloAmarillo().get(nuevoDado - 1).getFichas().add(ficha);
                ficha.getCasilla().getFichas().remove(ficha);
                ficha.setCasilla(utilidades.getCieloAmarillo().get(nuevoDado - 1));
            }

            case AZUL -> {
                utilidades.getCieloAzul().get(nuevoDado - 1). getFichas().add(ficha);
                ficha.getCasilla().getFichas().remove(ficha);
                ficha.setCasilla(utilidades.getCieloAzul().get(nuevoDado - 1));
            }
        }
    }
    //@TODO Comprobacion posible movimiento {Hacer en control turnos}

    public void movimientoCielo(Ficha ficha, int dado){
        switch (ficha.getColor()){
            case ROJO -> {
                utilidades.getCieloRojo().get(ficha.getCasilla().getId() + dado).getFichas().add(ficha);
                ficha.getCasilla().getFichas().remove(ficha);
                ficha.setCasilla(utilidades.getCieloRojo().get(ficha.getCasilla().getId() + dado));
            }

            case VERDE -> {
                utilidades.getCieloVerde().get(ficha.getCasilla().getId() + dado).getFichas().add(ficha);
                ficha.getCasilla().getFichas().remove(ficha);
                ficha.setCasilla(utilidades.getCieloVerde().get(ficha.getCasilla().getId() + dado));
            }

            case AMARILLO -> {
                utilidades.getCieloAmarillo().get(ficha.getCasilla().getId() + dado).getFichas().add(ficha);
                ficha.getCasilla().getFichas().remove(ficha);
                ficha.setCasilla(utilidades.getCieloAmarillo().get(ficha.getCasilla().getId() + dado));
            }

            case AZUL -> {
                utilidades.getCieloAzul().get(ficha.getCasilla().getId() + dado).getFichas().add(ficha);
                ficha.getCasilla().getFichas().remove(ficha);
                ficha.setCasilla(utilidades.getCieloAzul().get(ficha.getCasilla().getId() + dado));
            }
        }
    }
    public void setCasillas(Casilla[] casillas) {
        this.casillas = casillas;
    }

    public Utilidades getUtilidades() {
        return utilidades;
    }

    public void setUtilidades(Utilidades utilidades) {
        this.utilidades = utilidades;
    }

    public Casilla[] getCasillas() {
        return casillas;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Casilla getCasilla() {
        return casilla;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    public Dado getDado1() {
        return dado1;
    }

    public void setDado1(Dado dado1) {
        this.dado1 = dado1;
    }

    public Dado getDado2() {
        return dado2;
    }

    public void setDado2(Dado dado2) {
        this.dado2 = dado2;
    }

    public Turno getTurnos() {
        return turnos;
    }

    public void setTurnos(Turno turnos) {
        this.turnos = turnos;
    }

    public Utilidades getUtil() {
        return util;
    }

    public void setUtil(Utilidades util) {
        this.util = util;
    }
}
