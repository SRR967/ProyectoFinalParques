package estructuras;

public class Dado {

    private int numero;
    private int caras;
    private boolean usado = false;

    public Dado (int caras){
        this.caras = caras;
    }

    public Dado(){
        generarNumero();
    }

    public void generarNumero(){
        int aleatorio;
        do {
            aleatorio = ((int) (Math.random() * 1000))%(caras+1);
        }while (aleatorio ==0);
        this.numero = aleatorio;
    }

    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCaras() {
        return caras;
    }

    public void setCaras(int caras) {
        this.caras = caras;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }
}
