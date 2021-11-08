package Tierra;

import Enemigo.Jefe_Final;
import Enemigo.Monstruo;
import Jugador.Jugador;
import NPC.NPC;

public class Bosque extends Tierra {

    public Bosque(float probabilidad_enemigo, Monstruo monstruo, Jefe_Final jefe_final, NPC npc) {
        super(probabilidad_enemigo, monstruo, jefe_final, npc);
    }

    @Override
    public boolean accion(Jugador player) {
        int mana = player.getMana();
        if (mana == 0){
            System.out.println("Bosque: no podi pasar jkajahjkkhj");
            return false;
        }else if (mana == 1 || mana == 2){
            player.setVida(player.getVida() -(3-mana));
            if (player.getVida()<=0){
                return false;
            }
            System.out.printf("* pierdes "+(3-mana)+" de mana para llegar a este bosque *\n");
        }else{
            player.setMana(player.getMana()-3);
            System.out.printf("* pierdes 3 de mana para llegar a este bosque *\n");
        }
        if (getNpc() != null) {
            getNpc().interaccion(player);
        }
        if (getMonstruo() != null){
            int prob = (int)(getProbabilidad_enemigo()*100);
            int rand = randInt(0,100);
            if (rand <= prob){
                getMonstruo().combate(player);
            }
        }else if (getJefe_final() != null){
            int prob = (int)(getProbabilidad_enemigo()*100);
            int rand = randInt(0,100);
            if (rand <= prob){
                getJefe_final().combate(player);
            }
        }
        return player.getVida() > 0;
    }
}
