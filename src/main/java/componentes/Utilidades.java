package componentes;

import estructuras.Casilla;
import estructuras.Ficha;
import enumeraciones.Color;

import java.util.ArrayList;

public class Utilidades {

    public Casilla[] cieloAmarillo = new Casilla[7];
    public Casilla[] cieloVerde = new Casilla[7];
    public Casilla[] cieloRojo = new Casilla[7];
    public Casilla[] cieloAzul = new Casilla[7];

    private ArrayList<Ficha> carcelAmarillo= new ArrayList<>();
    private ArrayList<Ficha> carcelVerde= new ArrayList<>();
    private ArrayList<Ficha> carcelRojo= new ArrayList<>();
    private ArrayList<Ficha> carcelAzul= new ArrayList<>();

    private ArrayList<Color> colores= new ArrayList<Color>();

    public Utilidades(){
        colores.add(Color.ROJO);
        colores.add(Color.VERDE);
        colores.add(Color.AMARILLO);
        colores.add(Color.AZUL);
    }


    public Casilla[] getCieloAmarillo() {
        return cieloAmarillo;
    }

    public void setCieloAmarillo(Casilla[] cieloAmarillo) {
        this.cieloAmarillo = cieloAmarillo;
    }

    public Casilla[] getCieloVerde() {
        return cieloVerde;
    }

    public void setCieloVerde(Casilla[] cieloVerde) {
        this.cieloVerde = cieloVerde;
    }

    public Casilla[] getCieloRojo() {
        return cieloRojo;
    }

    public void setCieloRojo(Casilla[] cieloRojo) {
        this.cieloRojo = cieloRojo;
    }

    public Casilla[] getCieloAzul() {
        return cieloAzul;
    }

    public void setCieloAzul(Casilla[] cieloAzul) {
        this.cieloAzul = cieloAzul;
    }

    public ArrayList<Ficha> getCarcelAmarillo() {
        return carcelAmarillo;
    }

    public void setCarcelAmarillo(ArrayList<Ficha> carcelAmarillo) {
        this.carcelAmarillo = carcelAmarillo;
    }

    public ArrayList<Ficha> getCarcelVerde() {
        return carcelVerde;
    }

    public void setCarcelVerde(ArrayList<Ficha> carcelVerde) {
        this.carcelVerde = carcelVerde;
    }

    public ArrayList<Ficha> getCarcelAzul() {
        return carcelAzul;
    }

    public void setCarcelAzul(ArrayList<Ficha> carcelAzul) {
        this.carcelAzul = carcelAzul;
    }

    public ArrayList<Ficha> getCarcelRojo() {
        return carcelRojo;
    }

    public void setCarcelRojo(ArrayList<Ficha> carcelRojo) {
        this.carcelRojo = carcelRojo;
    }

    public ArrayList<Color> getColores() {
        return colores;
    }

    public void setColores(ArrayList<Color> colores) {
        this.colores = colores;
    }
}
