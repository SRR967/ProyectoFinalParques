package controladores;

import componentes.Tablero;
import enumeraciones.Color;
import estructuras.Dado;
import estructuras.Ficha;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;


import java.util.ArrayList;

public class ControladorTablero {

    @FXML
    private Button botonesCasillas []= new Button[68];
    private ArrayList<Button> botonesCarcel   = new ArrayList<>();

    private ArrayList<Button> botonesCieloRojo = new ArrayList<>();
    private ArrayList<Button> botonesCieloVerde  = new ArrayList<>();
    private ArrayList<Button> botonesCieloAmarillo = new ArrayList<>();
    private ArrayList<Button> botonesCieloAzul = new ArrayList<>();



    private Tablero tablero= new Tablero();
    private Ficha ficha= new Ficha();
    @FXML
    private AnchorPane anchorPane;

    @FXML
    public void initialize() {
        int cont=0;
        tablero.inicializar(68);
        var casillas = tablero.getCasillas();
        var casilla = casillas[0];

        casillas[5].getFichas().add(new Ficha(Color.ROJO));
        casillas[5].getFichas().add(new Ficha(Color.ROJO));
        System.out.println(""+tablero.getCasillas()[1].getFichas().size());


        for (Node node: anchorPane.getChildren()) {
            if (node instanceof Button){

                if (cont>= 68) {
                    if (cont<72){
                        Button button = ((Button) node);
                        botonesCarcel.add(button);
                        cont++;
                    }else if(cont<79){
                        Button button = ((Button) node);
                        botonesCieloRojo.add(button);
                        cont++;
                    }else if (cont<86){
                        Button button = ((Button) node);
                        botonesCieloVerde.add(button);
                        cont++;
                    }else if (cont<93){
                        Button button = ((Button) node);
                        botonesCieloAmarillo.add(button);
                        cont++;
                    }else if (cont<99){
                        Button button = ((Button) node);
                        botonesCieloAzul.add(button);
                        cont++;
                    }


                }
                else if (node instanceof Button) {

                    Button button = ((Button) node);
                    botonesCasillas[cont] =button;
                    cont++;
                }

            }

        }
        //botonesCasillas[1].setText(ficha.toString());
        //botonesCasillas[1].setText(botonesCasillas[1].getText().concat(ficha.toString()));
        render();
    }

    private void render (){

        for (int i=0; i<botonesCasillas.length;i++){
            ArrayList<Ficha> arraylistAux  = tablero.getCasillas()[i].getFichas();
            String aux = "";
            if (arraylistAux.size()>0){

                switch (arraylistAux.get(0).getColor()){
                    case ROJO -> {
                        botonesCasillas[i].setStyle(botonesCasillas[i].getStyle()+"-fx-text-fill: red");
                    }
                    case VERDE -> {
                        botonesCasillas[i].setStyle(botonesCasillas[i].getStyle()+"-fx-text-fill: green");

                    }
                    case AMARILLO -> {
                        botonesCasillas[i].setStyle(botonesCasillas[i].getStyle()+"-fx-text-fill: yellow");
                    }
                    case AZUL -> {
                        botonesCasillas[i].setStyle(botonesCasillas[i].getStyle()+"-fx-text-fill: blue");
                    }
                }


                for (int j=0; j<arraylistAux.size();j++){
                    aux = aux+ ficha.toString();
                    botonesCasillas[i].setText(aux);
                }
            }
        }
    }

    @FXML
    private void clicCasillaHandler(MouseEvent event) {
        Button clickedButton = (Button) event.getSource();
        System.out.println("Hola");
    }


}
