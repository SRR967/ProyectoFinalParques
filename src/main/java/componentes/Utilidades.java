package componentes;

import estructuras.Ficha;
import enumeraciones.Color;

import java.util.ArrayList;

public class Utilidades {

    public ArrayList<Ficha>cieloAmarillo = new ArrayList<>(7);
    public ArrayList<Ficha> cieloVerde = new ArrayList<>(7);
    public ArrayList<Ficha> cieloRojo = new ArrayList<>(7);
    public ArrayList<Ficha> cieloAzul = new ArrayList<>(7);

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


    public ArrayList<Ficha> getCieloAmarillo() {
        return cieloAmarillo;
    }

    public void setCieloAmarillo(ArrayList<Ficha> cieloAmarillo) {
        this.cieloAmarillo = cieloAmarillo;
    }

    public ArrayList<Ficha> getCieloVerde() {
        return cieloVerde;
    }

    public void setCieloVerde(ArrayList<Ficha> cieloVerde) {
        this.cieloVerde = cieloVerde;
    }

    public ArrayList<Ficha> getCieloRojo() {
        return cieloRojo;
    }

    public void setCieloRojo(ArrayList<Ficha> cieloRojo) {
        this.cieloRojo = cieloRojo;
    }

    public ArrayList<Ficha> getCieloAzul() {
        return cieloAzul;
    }

    public void setCieloAzul(ArrayList<Ficha> cieloAzul) {
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
