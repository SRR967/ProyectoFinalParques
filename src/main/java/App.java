import componentes.Tablero;
import controladores.ControladorDados;
import controladores.ControladorTablero;
import estructuras.Ficha;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.naming.ldap.Control;
import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/vista/TableroParques.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Parques");
            stage.setX(100);
            stage.setY(50);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

            ControladorTablero controladorTablero = fxmlLoader.getController();


            FXMLLoader fxmlLoader1 = new FXMLLoader(App.class.getResource("/vista/Dados.fxml"));

            Scene scene1 = new Scene(fxmlLoader1.load(),500,400);
            Stage stage1 = new Stage();
            stage1.setResizable(false);
            stage1.setX(800);
            stage1.setY(50);
            stage1.setTitle("Dados");
            stage1.setScene(scene1);

            ControladorDados controladorDados = fxmlLoader1.getController();
            System.out.println("Se esta ejecutando!");
            controladorTablero.setControladorDados(controladorDados);


            stage1.show();



        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
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
