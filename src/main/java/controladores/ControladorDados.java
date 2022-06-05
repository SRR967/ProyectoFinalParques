package controladores;
import estructuras.Dado;

public class ControladorDados {

    private int sumaTotal;
    private int a;
    private int b;
    private final Dado dadoA = new Dado(6);
    private final Dado dadoB = new Dado(6);

    public ControladorDados() {
        lanzarDados();
    }

    public void lanzarDados(){
        dadoA.generarNumero();
        dadoB.generarNumero();

        this.a = dadoA.getNumero();
        this.b = dadoB.getNumero();
        this.sumaTotal = a+b;
    }

    public int getSumaTotal() {
        return sumaTotal;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
