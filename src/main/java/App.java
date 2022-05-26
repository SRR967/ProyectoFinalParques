import componentes.Tablero;
import estructuras.TipoCasilla;

public class App {
    public static void main(String[] args) {
        System.out.println("Hola mundo");

        Tablero tablero = new Tablero();
        tablero.inicializar(68);

        var casillas = tablero.getCasillas();
        var casilla = casillas[0];

        casillas[1].estaOcupada = true;

        final int MAX_IT = 100;
        int it = 0;
        while(it < MAX_IT) {
            it++;
            System.out.print("Casilla " + casilla.id);
            System.out.print(casilla.estaOcupada
                    ? " [X] "
                    : " [ ] ");
            System.out.println("Tipo " + casilla.tipo);

            if(it % casillas.length == 0)
                System.out.println("----------------------------------------------------------------------");
            casilla = casilla.siguiente;
        }
    }
}
