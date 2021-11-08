package Jugador;
import Mision.Mision;

import java.util.ArrayList;


public abstract class Jugador {

    private String nombre;
    private int vida;
    private int vidaMax;
    private int fuerza;
    private int inteligencia;
    private int energia;
    private int energiaMax;
    private int mana;
    private int manaMax;

    public Jugador(String nombre, int vida, int vidaMax, int fuerza, int inteligencia, int energia, int energiaMax, int mana, int manaMax, int posicion, ArrayList<Mision> lista_misiones) {
        this.nombre = nombre;
        this.vida = vida;
        this.vidaMax = vidaMax;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.energia = energia;
        this.energiaMax = energiaMax;
        this.mana = mana;
        this.manaMax = manaMax;
        this.posicion = posicion;
        this.xp = 0;
        this.lista_misiones = lista_misiones;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    private int posicion;
    private int xp;
    private ArrayList<Mision> lista_misiones;

    public abstract int ataque();
    public abstract int hechizo();
    public abstract void subir_experiencia(int xp);

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getEnergia() {
        return energia;
    }

    public int getMana() {
        return mana;
    }

    public int getXp() {
        return xp;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
        if (this.energia<=0){
            System.out.println("Te quedaste sin energía!");
        }
    }

    public void setMana(int mana) {
        this.mana = mana;
        if (this.mana<=0){
            System.out.println("Te quedaste sin maná!");
        }
    }

    public void setXp(int xp) {
        this.xp = xp;
    }


    public int getNivel(){
        if (xp < 10){
            return 1;
        }else if (xp < 25){
            return 2;
        }else if (xp < 50){
            return 3;
        }else if (xp < 100){
            return 4;
        }else if (xp <200){
            return 5;
        }else if(xp < 350){
            return 6;
        }else if (xp < 600){
            return 7;
        }else if (xp < 900){
            return 8;
        }return 8;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public int getEnergiaMax() {
        return energiaMax;
    }

    public int getManaMax() {
        return manaMax;
    }

    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    public void setEnergiaMax(int energiaMax) {
        this.energiaMax = energiaMax;
    }

    public void setManaMax(int manaMax) {
        this.manaMax = manaMax;
    }

    public ArrayList<Mision> getLista_misiones() {
        return lista_misiones;
    }

    public void setLista_misiones(ArrayList<Mision> lista_misiones) {
        this.lista_misiones = lista_misiones;
    }

    public void muerte(){
        System.out.println("muelto :'VVVVVVVVVVVVVVVVVVV");
        System.exit(0);
    }
}

