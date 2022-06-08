package controladores;

import componentes.Tablero;
import componentes.Utilidades;
import enumeraciones.Color;
import estructuras.Casilla;
import estructuras.Dado;
import estructuras.Ficha;
import estructuras.Jugador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.shape.Polygon;


import java.util.ArrayList;

public class ControladorTablero {

    @FXML
    //private Button botonesCasillas []= new Button[68];
    private ArrayList<Button> botonesCasillas = new ArrayList<>();
    private ArrayList<Button> botonesCarcel   = new ArrayList<>();
    //Por commit

    private ArrayList<Button> botonesCieloRojo = new ArrayList<>();
    private ArrayList<Button> botonesCieloVerde  = new ArrayList<>();
    private ArrayList<Button> botonesCieloAmarillo = new ArrayList<>();
    private ArrayList<Button> botonesCieloAzul = new ArrayList<>();

    private Tablero tablero= new Tablero();
    private Ficha ficha= new Ficha();
    private Utilidades utilidades = tablero.getUtilidades();
    private ControladorDados controladorDados;
    private Jugador jugadorActual;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button cieloVerde;
    @FXML
    private Button cieloRojo;
    @FXML
    private Button cieloAmarillo;
    @FXML
    private Button cieloAzul;



    @FXML
    public void initialize() {
        int cont=0;
        tablero.inicializar(68);

        tablero.getCasillas()[65].getFichas().add(new Ficha(Color.ROJO , tablero.getCasillas()[65]));
        Polygon poligonoVerde = new Polygon();
        poligonoVerde.getPoints().addAll(new Double[]{0.0D, 40.0D, 40.0D, 40.0D, 20.0D, 20.0D});
        this.cieloVerde.setShape(poligonoVerde);
        Polygon poligonoAzul = new Polygon();
        poligonoAzul.getPoints().addAll(new Double[]{0.0D, 20.0D, 40.0D, 20.0D, 20.0D, 50.0D});
        this.cieloAzul.setShape(poligonoAzul);
        Polygon poligonoAmarillo = new Polygon();
        poligonoAmarillo.getPoints().addAll(new Double[]{0.0D, 20.0D, 40.0D, 20.0D, 20.0D, 50.0D});
        this.cieloAmarillo.setShape(poligonoAmarillo);
        Polygon poligonoRojo = new Polygon();
        poligonoRojo.getPoints().addAll(new Double[]{0.0D, 20.0D, 40.0D, 20.0D, 20.0D, 50.0D});
        this.cieloRojo.setShape(poligonoRojo);

        //tablero.getCasillas()[2].getFichas().add(new Ficha(Color.ROJO , tablero.getCasillas()[2]));
        //tablero.getCasillas()[7].getFichas().add(new Ficha(Color.AMARILLO, tablero.getCasillas()[7]));

        jugadorActual = tablero.getTurnos().getJugadores()[0];//Inicializado jugador rojo
        System.out.println("Turno"+jugadorActual.getColor());

        //utilidades.getCieloAmarillo().get(3).getFichas().add(new Ficha(Color.AMARILLO, utilidades.getCieloAmarillo().get(3)));

        for (Node node: anchorPane.getChildren()) {
            if (node instanceof Button){

                if (cont>= 68) {
                    if (cont<72){
                        Button button = ((Button) node);
                        botonesCarcel.add(button);
                        cont++;
                    }else if(cont<80){
                        Button button = ((Button) node);
                        botonesCieloRojo.add(button);
                        cont++;
                    }else if (cont<88){
                        Button button = ((Button) node);
                        botonesCieloVerde.add(button);
                        cont++;
                    }else if (cont<96){
                        Button button = ((Button) node);
                        botonesCieloAmarillo.add(button);
                        cont++;
                    }else if (cont<105){
                        Button button = ((Button) node);
                        botonesCieloAzul.add(button);
                        cont++;
                    }


                }
                else if (node instanceof Button) {

                    Button button = ((Button) node);
                    botonesCasillas.add(button);
                    cont++;
                }

            }

        }


        //botonesCasillas[1].setText(ficha.toString());
        //botonesCasillas[1].setText(botonesCasillas[1].getText().concat(ficha.toString()));

        botonesCarcel.get(0).setStyle(botonesCarcel.get(0).getStyle() + "-fx-text-fill: red");
        botonesCarcel.get(1).setStyle(botonesCarcel.get(1).getStyle() + "-fx-text-fill: green");
        botonesCarcel.get(2).setStyle(botonesCarcel.get(2).getStyle() + "-fx-text-fill: #786706");
        botonesCarcel.get(3).setStyle(botonesCarcel.get(3).getStyle() + "-fx-text-fill: blue");

        render();
    }

    private void render (){

        for (int i=0; i<botonesCasillas.size();i++){
            ArrayList<Ficha> arraylistAux  = tablero.getCasillas()[i].getFichas();
            String aux = "";
            if (arraylistAux.size()>0){

                switch (arraylistAux.get(0).getColor()){
                    case ROJO -> {
                        int indexAux = botonesCasillas.get(i).getStyle().length();

                        if(!botonesCasillas.get(i).getStyle().contains("-fx-text-fill: red")) {

                            if(botonesCasillas.get(i).getStyle().contains("-fx-text-fill: green")){
                                botonesCasillas.get(i).setStyle(botonesCasillas.get(i).getStyle().replace("-fx-text-fill: green", "-fx-text-fill: red"));
                            }
                            else if(botonesCasillas.get(i).getStyle().contains("-fx-text-fill: #786706")){
                                botonesCasillas.get(i).setStyle(botonesCasillas.get(i).getStyle().replace("-fx-text-fill: #786706","-fx-text-fill: red" ));
                                System.out.println(botonesCasillas.get(i).getStyle());
                            }
                            else if(botonesCasillas.get(i).getStyle().contains("-fx-text-fill: blue")){
                                botonesCasillas.get(i).setStyle(botonesCasillas.get(i).getStyle().replace("-fx-text-fill: blue", "-fx-text-fill: red"));
                            }
                            else{
                                botonesCasillas.get(i).setStyle(botonesCasillas.get(i).getStyle() + "-fx-text-fill: red");
                            }

                            }
                        }
                    case VERDE -> {
                        if(!botonesCasillas.get(i).getStyle().contains("-fx-text-fill: green")) {

                            if(botonesCasillas.get(i).getStyle().contains("-fx-text-fill: red")){
                                botonesCasillas.get(i).setStyle(botonesCasillas.get(i).getStyle().replace("-fx-text-fill: red", "-fx-text-fill: green"));
                            }
                            else if(botonesCasillas.get(i).getStyle().contains("-fx-text-fill: #786706")){
                                botonesCasillas.get(i).setStyle(botonesCasillas.get(i).getStyle().replace("-fx-text-fill: #786706","-fx-text-fill: green" ));
                                System.out.println(botonesCasillas.get(i).getStyle());
                            }
                            else if(botonesCasillas.get(i).getStyle().contains("-fx-text-fill: blue")){
                                botonesCasillas.get(i).setStyle(botonesCasillas.get(i).getStyle().replace("-fx-text-fill: blue", "-fx-text-fill: green"));
                            }
                            else{
                                botonesCasillas.get(i).setStyle(botonesCasillas.get(i).getStyle() + "-fx-text-fill: green");
                            }

                        }
                    }
                    case AMARILLO -> {
                        if(!botonesCasillas.get(i).getStyle().contains("-fx-text-fill: #786706")) {

                            if(botonesCasillas.get(i).getStyle().contains("-fx-text-fill: red")){
                                botonesCasillas.get(i).setStyle(botonesCasillas.get(i).getStyle().replace("-fx-text-fill: red", "-fx-text-fill: #786706"));
                            }
                            else if(botonesCasillas.get(i).getStyle().contains("-fx-text-fill: green")){
                                botonesCasillas.get(i).setStyle(botonesCasillas.get(i).getStyle().replace("-fx-text-fill: green","-fx-text-fill: #786706" ));
                                System.out.println(botonesCasillas.get(i).getStyle());
                            }
                            else if(botonesCasillas.get(i).getStyle().contains("-fx-text-fill: blue")){
                                botonesCasillas.get(i).setStyle(botonesCasillas.get(i).getStyle().replace("-fx-text-fill: blue", "-fx-text-fill: #786706"));
                            }
                            else{
                                botonesCasillas.get(i).setStyle(botonesCasillas.get(i).getStyle() + "-fx-text-fill: #786706");
                            }

                        }
                    }
                    case AZUL -> {
                        if(!botonesCasillas.get(i).getStyle().contains("-fx-text-fill: blue")) {

                            if(botonesCasillas.get(i).getStyle().contains("-fx-text-fill: red")){
                                botonesCasillas.get(i).setStyle(botonesCasillas.get(i).getStyle().replace("-fx-text-fill: red", "-fx-text-fill: blue"));
                            }
                            else if(botonesCasillas.get(i).getStyle().contains("-fx-text-fill: green")){
                                botonesCasillas.get(i).setStyle(botonesCasillas.get(i).getStyle().replace("-fx-text-fill: green","-fx-text-fill: blue" ));
                                System.out.println(botonesCasillas.get(i).getStyle());
                            }
                            else if(botonesCasillas.get(i).getStyle().contains("-fx-text-fill: #786706")){
                                botonesCasillas.get(i).setStyle(botonesCasillas.get(i).getStyle().replace("-fx-text-fill: #786706", "-fx-text-fill: blue"));
                            }
                            else{
                                botonesCasillas.get(i).setStyle(botonesCasillas.get(i).getStyle() + "-fx-text-fill: blue");
                            }

                        }
                    }
                }


                for (int j=0; j<arraylistAux.size();j++){
                    aux = aux+ ficha.toString();
                    botonesCasillas.get(i).setText(aux);
                }
            }
            else{
                botonesCasillas.get(i).setText("");
            }
        }

        String auxStyle = "";

        renderCarceles(utilidades.getCarcelRojo(), botonesCarcel.get(0));
        renderCarceles(utilidades.getCarcelVerde(), botonesCarcel.get(1));
        renderCarceles(utilidades.getCarcelAmarillo(), botonesCarcel.get(2));
        renderCarceles(utilidades.getCarcelAzul(), botonesCarcel.get(3));

        renderCielo(utilidades.getCieloRojo(), botonesCieloRojo);
        renderCielo(utilidades.getCieloVerde(), botonesCieloVerde);
        renderCielo(utilidades.getCieloAmarillo(), botonesCieloAmarillo);
        renderCielo(utilidades.getCieloAzul(), botonesCieloAzul);
    }

    private void renderCarceles(ArrayList<Ficha> fichasCarcel, Button carcel){
        //carcel.setText(carcel.getText() + "\n");
        String textAux = "";
        if(fichasCarcel.size() >0) {
            for (int i = 0; i < fichasCarcel.size(); i++) {
                textAux = textAux + ficha.toString();
                carcel.setText(/*carcel.getText()+*/ textAux);
            }
        }else{
            carcel.setText("");
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
                            botonesCielo.get(i).setStyle(botonesCielo.get(i).getStyle()+"-fx-text-fill: #786706;");
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

    public void movementEventHandler(javafx.event.ActionEvent actionEvent) {

        Button button = (Button) actionEvent.getSource();
        int indexAux = botonesCasillas.indexOf(button);

        if (controladorDados.getSumaTotal() != 0 && tablero.getCasillas()[indexAux].getFichas().size() != 0 &&
                tablero.getCasillas()[indexAux].getFichas().get(0).getColor() == jugadorActual.getColor()) {
            Ficha fichaAux = tablero.getCasillas()[indexAux].getFichas().get(0);
            tablero.mover(fichaAux, controladorDados.getSumaTotal());
            render();

            if (fichaAux.getCasilla().getFichas().size() > 1) {
                for (int i = 0; i < fichaAux.getCasilla().getFichas().size(); i++) {
                    if (fichaAux.getCasilla().getFichas().get(i).getColor() != jugadorActual.getColor()) {
                        tablero.comer(fichaAux.getCasilla().getFichas().get(i));
                        i--;
                    }
                }
            }

            controladorDados.setA(0);
            controladorDados.setB(0);
            controladorDados.setSumaTotal(0);
            jugadorActual = jugadorActual.siguiente;

            render();
        } else {
            System.out.println("No hay fichas");
        }

        //controladorDados.setA(0);
        //controladorDados.setB(0);
        //controladorDados.setSumaTotal(0);
        System.out.println(controladorDados.getSumaTotal());
    }

    public ControladorDados getControladorDados() {
        return controladorDados;
    }

    public void setControladorDados(ControladorDados controladorDados) {
        this.controladorDados = controladorDados;
    }

    public void salirCarcelController(ActionEvent actionEvent) {

        System.out.println("A");

        Button button = (Button) actionEvent.getSource();
        System.out.println(utilidades.getCarceles().get(botonesCarcel.indexOf(button)).size());

        if(controladorDados.getA() == controladorDados.getB() && controladorDados.getSumaTotal() !=0 &&
                utilidades.getCarceles().get(botonesCarcel.indexOf(button)).size() != 0){

            if(!jugadorActual.isFichasSacadas()) {
                Ficha fichaAux = (Ficha) utilidades.getCarceles().get(botonesCarcel.indexOf(button)).get(0);
                tablero.salirCarcelInicio(utilidades.getCarceles().get(botonesCarcel.indexOf(button)));
                jugadorActual.setFichasSacadas(true);
                render();
            }
            else{
                tablero.salirCarcelTurno(jugadorActual.getColor());
                render();
            }
        }
        else{
            System.out.println("No hay fichas en la carcel");
        }
        controladorDados.setA(0);
        controladorDados.setB(0);
        controladorDados.setSumaTotal(0);
        jugadorActual = jugadorActual.siguiente;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }
}

