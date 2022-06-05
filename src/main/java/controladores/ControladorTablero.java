package controladores;

import componentes.Tablero;
import estructuras.Dado;
import estructuras.Ficha;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.awt.*;

public class ControladorTablero {

    @FXML
    private Button buttons;
    private Tablero tablero;
    private Ficha ficha;


    @FXML
    public void inicializar() {
        tablero = new Tablero();



    }
    @FXML
    private void clicCasillaHandler(MouseEvent event) {
        Button clickedButton = (Button) event.getSource();
        System.out.println("Hola");
    }


}
