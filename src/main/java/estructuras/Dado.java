package estructuras;

public class Dado {

    private int numero;
    private int caras;

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
}
