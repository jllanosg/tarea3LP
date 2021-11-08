package Tierra;

import Enemigo.Jefe_Final;
import Enemigo.Monstruo;
import Jugador.Jugador;
import NPC.NPC;

public class Montaña extends Tierra{


    public Montaña(float probabilidad_enemigo, Monstruo monstruo, Jefe_Final jefe_final, NPC npc) {
        super(probabilidad_enemigo, monstruo, jefe_final, npc);
    }

    @Override
    public boolean accion(Jugador player) {
        int energia = player.getEnergia();
        if (energia == 0){
            System.out.println("Montaña: no podi pasar jkajahjkkhj");
            return false;
        }else if (energia == 1 || energia == 2){
            player.setVida(player.getVida() -(3-energia));
            if (player.getVida()<=0) return false;
            System.out.printf("* pierdes "+(3-energia)+" de energía para llegar a esta montaña *\n");
        }else{
            player.setEnergia(player.getEnergia()-3);
            System.out.printf("* pierdes 3 de energía para llegar a esta montaña *\n");
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
