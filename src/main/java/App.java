import componentes.Tablero;
import estructuras.Casilla;
import estructuras.Ficha;
import estructuras.TipoCasilla;

public class App {
    public static void main(String[] args) {
        Ficha ficha = new Ficha();

        Tablero tablero = new Tablero();
        tablero.inicializar(68);

        var casillas = tablero.getCasillas();
        var casilla = casillas[0];

        casillas[1].setEstaOcupada(true);

        final int MAX_IT = 100;
        int it = 0;
        while(it < MAX_IT) {
            it++;
            System.out.print("Casilla " + casilla.getId());
            System.out.print(casilla.getIsEstaOcupada()
                    ? " ["+ ficha.toString()+"]"
                    : " [ ] ");
            System.out.println("Tipo " + casilla.tipo);

            if(it % casillas.length == 0)
                System.out.println("----------------------------------------------------------------------");
            casilla = casilla.siguiente;
        }


    }
}
