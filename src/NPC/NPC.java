package NPC;

import Jugador.Jugador;

public abstract class NPC{
    private String nombre;

    public NPC(String nombre) {
        this.nombre = nombre;
    }

    public abstract void interaccion(Jugador player);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
