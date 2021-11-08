package NPC;
import Jugador.Jugador;
import java.util.Random;

public class Malo extends NPC{

    int cantidad_energia, cantidad_mana;

    public Malo(String nombre, int cantidad_energia, int cantidad_mana){
        super(nombre);
        this.cantidad_energia = cantidad_energia;
        this.cantidad_mana = cantidad_mana;
    }

    public static int randInt(int min, int max) {

        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    /*
    Finalmente deberá tirar un número al azar entre 1 y 10 si el
    número es menor o igual a 6 se disminuye la energía del Jugador en cantidad energia,
    luego debe repetir este proceso para el maná del Jugador
     */

    @Override
    public void interaccion(Jugador player) {
        System.out.println(getNombre()+": SOY MALO TE VOY A DISMINUIR TU ENERGIA y MANA EN "+cantidad_energia+" energia  y  "+cantidad_mana+" mana ");
        int a = randInt(1,10);
        int b = randInt(1,10);
        if (a<=6){
            System.out.println("PERDISTE "+cantidad_energia+" DE ENERGIAAAAAAAAAAAAAAAAAA "+player.getNombre()+" XD");
            if (player.getEnergia()-cantidad_energia <=0){
                player.setEnergia(0);
            }else{
                player.setEnergia(player.getEnergia()-cantidad_energia);
            }
        }
        if (b<=6){
            System.out.println("PERDISTE "+cantidad_mana+" DE MANAAAAAAAAAAAAAAAAAA "+player.getNombre()+" XD");
            if (player.getMana()-cantidad_mana <=0){
                player.setMana(0);
            }else{
                player.setMana(player.getMana()-cantidad_mana);
            }
        }
    }
}
