package Jugador;

import Mision.Mision;

import java.util.ArrayList;

public class Mago extends Jugador{
    public Mago(String nombre, int posicion) {
        super(nombre, 10, 10, 3, 10, 6, 6, 15, 15, posicion, new ArrayList<Mision>());
    }


    @Override
    public int ataque() {
        if (getEnergia() > 0){
            int energia = getEnergia();
            setEnergia(getEnergia()-3);
            if (getEnergia() < 0){
                setEnergia(0);
            }
            return ((getFuerza() * getInteligencia()/4) + energia);
        }
        return 0;
    }

    @Override
    public int hechizo() {
        if (getMana()>0){
            int mana = getMana();
            setMana(getMana()-5);
            if (getMana() < 0){
                setMana(0);
            }
            return ((getInteligencia()*getFuerza()/4)+mana);
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
                setVidaMax(getVidaMax() + 2*lvl);
                setFuerza(getFuerza() + 1);
                setInteligencia(getInteligencia() +  3*lvl);
                setEnergiaMax(getEnergiaMax() + 1);
                setManaMax(getEnergiaMax() + 3*lvl);
            }
            setVida(getVidaMax());
            setEnergia(getEnergiaMax());
            setMana(getManaMax());
        }

    }
}
