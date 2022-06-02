package estructuras;

import componentes.Utilidades;
import enumeraciones.Color;
import componentes.Tablero;

import java.util.ArrayList;

public class Ficha {
    private Casilla casilla;
    private Color color;
    private Utilidades utilidades;
    private Dado dado1;
    private Dado dado2;
    private Tablero tablero;

    public Ficha(){

    }

    public Ficha(Color color){
        this.color = color;
    }

    public Casilla getCasilla() {
        return casilla;
    }

    public void mover (){

    }

    public void salirCarcel(ArrayList<Ficha> carcel){
        if (dado1.getNumero()==dado2.getNumero()){
            switch (carcel.get(0).color){

                case AMARILLO ->{
                    for(int i = 0; i < 4; i++) {
                        tablero.getCasillas()[5].getFichas().add(new Ficha(Color.AMARILLO));
                    }
                }

                case VERDE -> {
                    for(int i = 0; i < 4; i++) {
                        tablero.getCasillas()[22].getFichas().add(new Ficha(Color.VERDE));
                    }
                }
                case ROJO -> {
                    for(int i = 0; i < 4; i++) {
                        tablero.getCasillas()[39].getFichas().add(new Ficha(Color.ROJO));
                    }
                }


                case AZUL -> {
                    for(int i = 0; i < 4; i++) {
                        tablero.getCasillas()[56].getFichas().add(new Ficha(Color.AZUL));
                    }


                }

            }

            carcel.removeAll(carcel);
        }


    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public  String toString(){
        return "\u2659";
    }


}
