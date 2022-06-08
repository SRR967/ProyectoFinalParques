package estructuras;

import enumeraciones.Color;

public class Jugador {
    public String numJugador;
    public Jugador siguiente;
    public Jugador anterior;
    private Color color;
    private boolean isGanador;
    private boolean fichasSacadas = false;

    public boolean isGanador() {
        return isGanador;
    }

    public void setGanador(boolean ganador) {
        isGanador = ganador;
    }

    public String getNumJugador() {
        return numJugador;
    }

    public void setNumJugador(String numJugador) {
        this.numJugador = numJugador;
    }

    public Jugador getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Jugador siguiente) {
        this.siguiente = siguiente;
    }

    public Jugador getAnterior() {
        return anterior;
    }

    public void setAnterior(Jugador anterior) {
        this.anterior = anterior;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFichasSacadas() {
        return fichasSacadas;
    }

    public void setFichasSacadas(boolean fichasSacadas) {
        this.fichasSacadas = fichasSacadas;
    }
}
