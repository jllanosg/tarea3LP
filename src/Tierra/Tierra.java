package Tierra;

import Enemigo.Jefe_Final;
import Enemigo.Monstruo;
import Jugador.Jugador;
import NPC.NPC;

import java.util.Random;

public abstract class Tierra {
    private float probabilidad_enemigo;
    private Monstruo monstruo;
    private Jefe_Final jefe_final;
    private NPC npc;

    public static int randInt(int min, int max) {

        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    public Tierra(float probabilidad_enemigo, Monstruo monstruo, Jefe_Final jefe_final, NPC npc) {
        this.probabilidad_enemigo = probabilidad_enemigo;
        this.monstruo = monstruo;
        this.jefe_final = jefe_final;
        this.npc = npc;
    }

    public abstract boolean accion(Jugador player);

    public float getProbabilidad_enemigo() {
        return probabilidad_enemigo;
    }

    public void setProbabilidad_enemigo(float probabilidad_enemigo) {
        this.probabilidad_enemigo = probabilidad_enemigo;
    }

    public Monstruo getMonstruo() {
        return monstruo;
    }

    public void setMonstruo(Monstruo monstruo) {
        this.monstruo = monstruo;
    }

    public Jefe_Final getJefe_final() {
        return jefe_final;
    }

    public void setJefe_final(Jefe_Final jefe_final) {
        this.jefe_final = jefe_final;
    }

    public NPC getNpc() {
        return npc;
    }

    public void setNpc(NPC npc) {
        this.npc = npc;
    }
}
