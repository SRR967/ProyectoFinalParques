package componentes;

import estructuras.Casilla;
import estructuras.Ficha;
import enumeraciones.Color;

import java.util.ArrayList;

public class Utilidades {

    public ArrayList<Casilla>cieloAmarillo = new ArrayList<>();
    public ArrayList<Casilla> cieloVerde = new ArrayList<>();
    public ArrayList<Casilla> cieloRojo = new ArrayList<>();
    public ArrayList<Casilla> cieloAzul = new ArrayList<>();

    private ArrayList<Ficha> carcelAmarillo= new ArrayList<>();
    private ArrayList<Ficha> carcelVerde= new ArrayList<>();
    private ArrayList<Ficha> carcelRojo= new ArrayList<>();
    private ArrayList<Ficha> carcelAzul= new ArrayList<>();

    private  ArrayList<ArrayList> carceles = new ArrayList<>();

    private ArrayList<Color> colores= new ArrayList<Color>();
    private int casillaAux = 69;

    public Utilidades(){
        colores.add(Color.ROJO);
        colores.add(Color.VERDE);
        colores.add(Color.AMARILLO);
        colores.add(Color.AZUL);

        //Casillas
        llenarCasillasCielo(cieloRojo);
        llenarCasillasCielo(cieloVerde);
        llenarCasillasCielo(cieloAmarillo);
        llenarCasillasCielo(cieloAzul);

        //Carceles
        carceles.add(carcelRojo);
        carceles.add(carcelVerde);
        carceles.add(carcelAmarillo);
        carceles.add(carcelAzul);
    }

    public void llenarCasillasCielo(ArrayList<Casilla> casillasCielo){
        for(int i = 0; i < 8; i++){
            casillasCielo.add(new Casilla(casillaAux));
            System.out.println(casillaAux);
            casillaAux++;
        }
    }


    public ArrayList<Casilla> getCieloAmarillo() {
        return cieloAmarillo;
    }

    public void setCieloAmarillo(ArrayList<Casilla> cieloAmarillo) {
        this.cieloAmarillo = cieloAmarillo;
    }

    public ArrayList<Casilla> getCieloVerde() {
        return cieloVerde;
    }

    public void setCieloVerde(ArrayList<Casilla> cieloVerde) {
        this.cieloVerde = cieloVerde;
    }

    public ArrayList<Casilla> getCieloRojo() {
        return cieloRojo;
    }

    public void setCieloRojo(ArrayList<Casilla> cieloRojo) {
        this.cieloRojo = cieloRojo;
    }

    public ArrayList<Casilla> getCieloAzul() {
        return cieloAzul;
    }

    public void setCieloAzul(ArrayList<Casilla> cieloAzul) {
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

    public ArrayList<ArrayList> getCarceles() {
        return carceles;
    }

    public void setCarceles(ArrayList<ArrayList> carceles) {
        this.carceles = carceles;
    }

    public int getCasillaAux() {
        return casillaAux;
    }

    public void setCasillaAux(int casillaAux) {
        this.casillaAux = casillaAux;
    }
}
