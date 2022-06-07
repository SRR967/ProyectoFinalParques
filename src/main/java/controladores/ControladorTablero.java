package controladores;

import componentes.Tablero;
import componentes.Utilidades;
import enumeraciones.Color;
import estructuras.Casilla;
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
    private Utilidades utilidades = tablero.getUtilidades();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    public void initialize() {
        int cont=0;
        tablero.inicializar(68);

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

        //Render Carceles
        //botonesCarcel.get(0).setText(botonesCarcel.get(0).getText() + "\n");
        //for(int i = 0; i < utilidades.getCarcelRojo().size(); i++){
        //    botonesCarcel.get(0).setText(botonesCarcel.get(0).getText() + ficha.toString());
        //}

        botonesCarcel.get(0).setStyle(botonesCarcel.get(0).getStyle() + "-fx-text-fill: red");
        renderCarceles(utilidades.getCarcelRojo(), botonesCarcel.get(0));

        botonesCarcel.get(1).setStyle(botonesCarcel.get(1).getStyle() + "-fx-text-fill: green");
        renderCarceles(utilidades.getCarcelVerde(), botonesCarcel.get(1));

        botonesCarcel.get(2).setStyle(botonesCarcel.get(2).getStyle() + "-fx-text-fill: #786706");
        renderCarceles(utilidades.getCarcelAmarillo(), botonesCarcel.get(2));

        botonesCarcel.get(3).setStyle(botonesCarcel.get(3).getStyle() + "-fx-text-fill: blue");
        renderCarceles(utilidades.getCarcelAzul(), botonesCarcel.get(3));

        renderCielo(utilidades.getCieloRojo(), botonesCieloRojo);
        renderCielo(utilidades.getCieloVerde(), botonesCieloVerde);
        renderCielo(utilidades.getCieloAmarillo(), botonesCieloAmarillo);
        renderCielo(utilidades.getCieloAzul(), botonesCieloAzul);
    }

    private void renderCarceles(ArrayList<Ficha> fichasCarcel, Button carcel){
        carcel.setText(carcel.getText() + "\n");
        for(int i = 0; i < fichasCarcel.size(); i++){
            carcel.setText(carcel.getText()+ficha.toString());
        }
    }

    @FXML
    private void renderCielo(ArrayList<Casilla> casillasCielo, ArrayList<Button> botonesCielo){
        for(int i = 0; i < casillasCielo.size()-1; i ++){
            if(casillasCielo.get(i).getFichas().size() > 0){

                for(int j = 0; j < casillasCielo.get(i).getFichas().size(); j++){
                    switch (casillasCielo.get(i).getFichas().get(0).getColor()){
                        case ROJO -> {
                            botonesCielo.get(i).setStyle(botonesCielo.get(i).getStyle()+"-fx-text-fill: red;");
                        }
                        case VERDE -> {
                            botonesCielo.get(i).setStyle(botonesCielo.get(i).getStyle()+"-fx-text-fill: green;");

                        }
                        case AMARILLO -> {
                            botonesCielo.get(i).setStyle(botonesCielo.get(i).getStyle()+"-fx-text-fill: yellow;");
                        }
                        case AZUL -> {
                            botonesCielo.get(i).setStyle(botonesCielo.get(i).getStyle()+"-fx-text-fill: blue;");
                        }
                    }


                    botonesCielo.get(i).setText(botonesCielo.get(i).getText() + ficha.toString());
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
