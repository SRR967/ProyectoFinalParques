package controladores;

import componentes.Tablero;
import estructuras.Dado;
import estructuras.Ficha;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.awt.*;

public class ControladorTablero {

    @FXML
    private Button buttons []= new Button[68];
    private Tablero tablero;
    private Ficha ficha;
    private AnchorPane anchorPane;


    @FXML
    public void inicializar() {
        tablero = new Tablero();
        int cont=0;
        for (Node node: anchorPane.getChildren()) {
            if (cont==68){
                break;
            }else {
                Button button =buttons[cont];
                cont++;
            }

        }



    }

    @FXML
    private void clicCasillaHandler(MouseEvent event) {
        Button clickedButton = (Button) event.getSource();
        System.out.println("Hola");
    }


}
