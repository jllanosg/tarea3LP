package Tierra;

import Enemigo.Jefe_Final;
import Enemigo.Monstruo;
import Jugador.Jugador;
import NPC.NPC;

public class Planicie extends Tierra{


    public Planicie(float probabilidad_enemigo, Monstruo monstruo, Jefe_Final jefe_final, NPC npc) {
        super(probabilidad_enemigo, monstruo, jefe_final, npc);
    }

    @Override
    public boolean accion(Jugador player) {
        if (getNpc() != null) {
            getNpc().interaccion(player);
        }
        if (getMonstruo() != null){
            int prob = (int)getProbabilidad_enemigo()*100;
            int rand = randInt(0,100);
            System.out.println("prob: "+prob+"%"+" dado: "+rand);
            if (rand <= prob){
                getMonstruo().combate(player);
            }
        }else if (getJefe_final() != null){
            int prob = (int)getProbabilidad_enemigo()*100;
            int rand = randInt(0,100);
            System.out.println("prob:"+prob+"%"+" dado:"+rand);
            if (rand <= prob){
                getJefe_final().combate(player);
            }
        }
        return player.getVida() > 0;
    }
}
