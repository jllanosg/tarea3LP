package Enemigo;

import Jugador.Jugador;
import Mision.Mision;

import java.util.Scanner;

public class Monstruo implements Enemigo{
    private int vida, dano;

    public Monstruo(int vida, int dano) {
        this.vida = vida;
        this.dano = dano;
    }

    @Override
    public void combate(Jugador player) {
        int vida_zero = vida;
        System.out.println("COMBATE INICIADO");
        System.out.println("Monstruo: Me gustan tus pantalones!");
        while(player.getVida() >0 && vida > 0){
            System.out.println("VIDA: "+player.getVida());
            System.out.println("VIDA MONSTRUO: "+vida);
            Scanner scan = new Scanner(System.in);
            System.out.println("COMBATE \n ELIGE UNA OPCIÓN \n 1 --> ATAQUE \n 2 --> HECHIZO\n");
            int opt = scan.nextInt();
            switch (opt) {
                case 1 -> {
                    int atq = player.ataque();
                    System.out.println(" >~ patada nuclear ~< ");
                    System.out.println("* le pegas un charchazo de " + atq + " daño XD *");
                    setVida(getVida() - atq);
                }
                case 2 -> {
                    int hech = player.hechizo();
                    System.out.println("* le pegas un rasho laser de " + hech + " daño XD *");
                    setVida(getVida() - hech);
                }
                default -> System.out.println("lo pusiste mal aaaaaaaaa");
            }
            if(vida < 0){
                System.out.println("* ganas el combate :v *");

                for (int i =0; i < player.getLista_misiones().size();i++){
                    Mision m = player.getLista_misiones().get(i);
                    if (m.getRequisito() == 'm'){
                        m.setCantidad(m.getCantidad()+1);
                        if (m.verificar_requisito()){
                            System.out.println("Has completado una misión de matar! recompensa: "+m.getRecompensa());
                            player.subir_experiencia(m.getRecompensa());
                            player.getLista_misiones().remove(m);
                        }
                    }
                }
                break;
                }
            player.setVida(player.getVida()-dano);
            System.out.println("* recibes "+dano+" de daño *\n OOF");
            }
        setVida(vida_zero);
    }

    public int getVida() {
        return vida;
    }

    public int getDano() {
        return dano;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

}
