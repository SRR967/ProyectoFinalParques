package estructuras;

import componentes.Utilidades;
import enumeraciones.Color;
import componentes.Tablero;



public class Ficha {
    private Casilla casilla;
    private Color color;
    private Utilidades utilidades;

    private Tablero tablero;

    public Ficha(){

    }
    public Ficha(Color color, Casilla casilla){
        this.color = color;
        this.casilla = casilla;
    }

    public Ficha(Color color){
        this.color = color;
    }

    public  String toString(){
        return "\u2659";
    }


    public Casilla getCasilla() {
        return casilla;
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
}
