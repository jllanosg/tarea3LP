package Jugador;


import Mision.Mision;

import java.util.ArrayList;

public class Guerrero extends Jugador{
    public Guerrero(String nombre, int posicion) {
        super(nombre, 20, 20, 9, 1, 10, 10, 2, 2, posicion, new ArrayList<Mision>());
    }

    @Override
    public int ataque() {
        if (getEnergia() > 0){
            int energia = getEnergia();
            setEnergia(getEnergia()-5);
            if (getEnergia() < 0){
                setEnergia(0);
            }
            return ((getFuerza() * 2) + energia);
        }
        return 0;
    }

    @Override
    public int hechizo() {
        if (getMana()>0){
            int mana = getMana();
            setMana(getMana()-3);
            if (getEnergia() < 0){
                setEnergia(0);
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
                setVidaMax(getVidaMax() + 3*lvl);
                setFuerza(getFuerza() + 5*lvl);
                setInteligencia(getInteligencia() +  1);
                setEnergiaMax(getEnergiaMax() + 2*lvl);
                setManaMax(getEnergiaMax() + 1 );
            }
            setVida(getVidaMax());
            setEnergia(getEnergiaMax());
            setMana(getManaMax());
        }

    }
}
