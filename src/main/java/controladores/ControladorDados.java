package controladores;
import estructuras.Dado;
import estructuras.Jugador;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class ControladorDados {

    private int sumaTotal;
    private int a;
    private int b;
    private final Dado dadoA = new Dado(6);
    private final Dado dadoB = new Dado(6);

    private Image imgDado1, imgDado2;
    private ImageView imgViewDado1, imgViewDado2;
    private ControladorTablero controladorTablero;

    @FXML
    private final ImageView imageView = new ImageView();
    @FXML
    private Button generarNumero;


    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Label labelTextoTurno;

    @FXML
    public void initialize() {

        labelTextoTurno.setText("Es el turno de: ");

        imgDado1 = new Image("imagenes/Dado1.png");
        imgDado2 = new Image("imagenes/Dado1.png");

        imgViewDado1 = new ImageView(imgDado1);
        imgViewDado2 = new ImageView(imgDado2);

        imgViewDado1.setX(75);
        imgViewDado1.setY(100);

        imgViewDado2.setX(250);
        imgViewDado2.setY(100);


        anchorpane.getChildren().add(imgViewDado1);
        anchorpane.getChildren().add(imgViewDado2);
    }

    public void saltarTurno(){
        a = 0;
        b = 0;
        sumaTotal = 0;
        dadoA.setUsado(false);
        dadoB.setUsado(false);
        controladorTablero.setJugadorActual(controladorTablero.getJugadorActual().siguiente);
        lanzarDados();
        actualizarGrafico();

    }

    public void eventButton(javafx.event.ActionEvent actionEvent) {
        lanzarDados();

        switch (getA()) {
            case 1 -> {
                Image imagenAux = new Image("imagenes/Dado1.png");
                setImgDado1(imagenAux);
                imgViewDado1.setImage(imagenAux);
            }
            case 2 -> {
                Image imagenAux = new Image("imagenes/Dado2.png");
                setImgDado1(imagenAux);
                imgViewDado1.setImage(imagenAux);

            }

            case 3 -> {
                Image imagenAux = new Image("imagenes/Dado3.png");
                setImgDado1(imagenAux);
                imgViewDado1.setImage(imagenAux);

            }

            case 4 -> {
                Image imagenAux = new Image("imagenes/Dado4.png");
                setImgDado1(imagenAux);
                imgViewDado1.setImage(imagenAux);

            }

            case 5 -> {
                Image imagenAux = new Image("imagenes/Dado5.png");
                setImgDado1(imagenAux);
                imgViewDado1.setImage(imagenAux);

            }

            case 6 -> {
                Image imagenAux = new Image("imagenes/Dado6.png");
                setImgDado1(imagenAux);
                imgViewDado1.setImage(imagenAux);

            }
        }
        switch (getB()) {
            case 1 -> {
                Image imagenAux = new Image("imagenes/Dado1.png");
                setImgDado2(imagenAux);
                imgViewDado2.setImage(imagenAux);

            }
            case 2 -> {
                Image imagenAux = new Image("imagenes/Dado2.png");
                setImgDado2(imagenAux);
                imgViewDado2.setImage(imagenAux);

            }

            case 3 -> {
                Image imagenAux = new Image("imagenes/Dado3.png");
                setImgDado2(imagenAux);
                imgViewDado2.setImage(imagenAux);
            }

            case 4 -> {
                Image imagenAux = new Image("imagenes/Dado4.png");
                setImgDado2(imagenAux);
                imgViewDado2.setImage(imagenAux);
            }

            case 5 -> {
                Image imagenAux = new Image("imagenes/Dado5.png");
                setImgDado2(imagenAux);
                imgViewDado2.setImage(imagenAux);
            }

            case 6 -> {
                Image imagenAux = new Image("imagenes/Dado6.png");
                setImgDado2(imagenAux);
                imgViewDado2.setImage(imagenAux);
            }
        }

    }



    //public ControladorDados() {
    //    lanzarDados();
    //}

    public void lanzarDados() {
        if(!dadoA.isUsado() && !dadoB.isUsado()) {
            dadoA.generarNumero();
            dadoB.generarNumero();

            this.a = dadoA.getNumero();
            this.b = dadoB.getNumero();
            this.sumaTotal = a + b;

            labelTextoTurno.setText("Es el turno de: " + controladorTablero.getJugadorActual().getColor());
            actualizarGrafico();
        }

    }

    public void actualizarGrafico(){
        if(dadoA.isUsado()){
            imgViewDado1.setOpacity(0.67);
        }
        else{
            imgViewDado1.setOpacity(1.0);
        }
        if (dadoB.isUsado()){
            imgViewDado2.setOpacity(0.67);

        }
        else{
            imgViewDado2.setOpacity(1.0);
        }

        switch (getA()) {
            case 1 -> {
                Image imagenAux = new Image("imagenes/Dado1.png");
                setImgDado1(imagenAux);
                imgViewDado1.setImage(imagenAux);
            }
            case 2 -> {
                Image imagenAux = new Image("imagenes/Dado2.png");
                setImgDado1(imagenAux);
                imgViewDado1.setImage(imagenAux);

            }

            case 3 -> {
                Image imagenAux = new Image("imagenes/Dado3.png");
                setImgDado1(imagenAux);
                imgViewDado1.setImage(imagenAux);

            }

            case 4 -> {
                Image imagenAux = new Image("imagenes/Dado4.png");
                setImgDado1(imagenAux);
                imgViewDado1.setImage(imagenAux);

            }

            case 5 -> {
                Image imagenAux = new Image("imagenes/Dado5.png");
                setImgDado1(imagenAux);
                imgViewDado1.setImage(imagenAux);

            }

            case 6 -> {
                Image imagenAux = new Image("imagenes/Dado6.png");
                setImgDado1(imagenAux);
                imgViewDado1.setImage(imagenAux);

            }
        }
        switch (getB()) {
            case 1 -> {
                Image imagenAux = new Image("imagenes/Dado1.png");
                setImgDado2(imagenAux);
                imgViewDado2.setImage(imagenAux);

            }
            case 2 -> {
                Image imagenAux = new Image("imagenes/Dado2.png");
                setImgDado2(imagenAux);
                imgViewDado2.setImage(imagenAux);

            }

            case 3 -> {
                Image imagenAux = new Image("imagenes/Dado3.png");
                setImgDado2(imagenAux);
                imgViewDado2.setImage(imagenAux);
            }

            case 4 -> {
                Image imagenAux = new Image("imagenes/Dado4.png");
                setImgDado2(imagenAux);
                imgViewDado2.setImage(imagenAux);
            }

            case 5 -> {
                Image imagenAux = new Image("imagenes/Dado5.png");
                setImgDado2(imagenAux);
                imgViewDado2.setImage(imagenAux);
            }

            case 6 -> {
                Image imagenAux = new Image("imagenes/Dado6.png");
                setImgDado2(imagenAux);
                imgViewDado2.setImage(imagenAux);
            }
        }
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

    public Image getImgDado1() {
        return imgDado1;
    }

    public void setImgDado1(Image imgDado1) {
        this.imgDado1 = imgDado1;
    }

    public Image getImgDado2() {
        return imgDado2;
    }

    public void setImgDado2(Image imgDado2) {
        this.imgDado2 = imgDado2;
    }

    public ImageView getImgViewDado1() {
        return imgViewDado1;
    }

    public void setImgViewDado1(ImageView imgViewDado1) {
        this.imgViewDado1 = imgViewDado1;
    }

    public ImageView getImgViewDado2() {
        return imgViewDado2;
    }

    public void setImgViewDado2(ImageView imgViewDado2) {
        this.imgViewDado2 = imgViewDado2;
    }

    public void setSumaTotal(int sumaTotal) {
        this.sumaTotal = sumaTotal;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Dado getDadoA() {
        return dadoA;
    }

    public Dado getDadoB() {
        return dadoB;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Button getGenerarNumero() {
        return generarNumero;
    }

    public void setGenerarNumero(Button generarNumero) {
        this.generarNumero = generarNumero;
    }

    public AnchorPane getAnchorpane() {
        return anchorpane;
    }

    public void setAnchorpane(AnchorPane anchorpane) {
        this.anchorpane = anchorpane;
    }

    public ControladorTablero getControladorTablero() {
        return controladorTablero;
    }

    public void setControladorTablero(ControladorTablero controladorTablero) {
        this.controladorTablero = controladorTablero;
    }

    public Label getLabelTextoTurno() {
        return labelTextoTurno;
    }

    public void setLabelTextoTurno(Label labelTextoTurno) {
        this.labelTextoTurno = labelTextoTurno;
    }
}

