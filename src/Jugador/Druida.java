package Jugador;

import Mision.Mision;

import java.util.ArrayList;

public class Druida extends Jugador{

    public Druida(String nombre, int posicion ) {
        super(nombre, 15, 15, 5, 5, 5, 5, 5, 5, posicion, new ArrayList<Mision>());
    }

    @Override
    public int ataque() {
        if (getEnergia() > 0){
            int mana = getMana(), energia = getEnergia();
            setEnergia(getEnergia()-3);
            if (getEnergia() < 0){
                setEnergia(0);
            }
            return (((getFuerza() + getInteligencia())/3) * Math.max(energia/3,mana/2));
        }
        return 0;
    }

    @Override
    public int hechizo() {
        if (getMana()>0){
            int mana = getMana(), energia = getEnergia();
            setMana(getMana()-3);
            if (getMana() < 0){
                setMana(0);

            }
            return (((getFuerza() + getInteligencia())/3) * Math.max(energia/2,mana/3));
        }
        return 0;
    }

    @Override
    public void subir_experiencia(int aumentoXp) {
        int nivelInicial = getNivel();
        setXp(getXp() + aumentoXp);
        int nivelFinal = getNivel();
        int difNivel = nivelFinal - nivelInicial;
        if (difNivel > 0){
            for (int lvl = nivelInicial + 1; lvl <= nivelFinal; lvl++){
                System.out.println(getNombre() + " ha alcanzado el nivel " + lvl + "!");
                setVidaMax(getVidaMax() + lvl);
                setFuerza(getFuerza() + lvl);
                setInteligencia(getInteligencia() +  lvl);
                setEnergiaMax(getEnergiaMax() + lvl);
                setManaMax(getEnergiaMax() + lvl);
            }
            setVida(getVidaMax());
            setEnergia(getEnergiaMax());
            setMana(getManaMax());
        }

    }
}
