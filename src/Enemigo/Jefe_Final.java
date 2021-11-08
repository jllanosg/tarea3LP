package Enemigo;

import Jugador.Jugador;

import java.util.Scanner;

public class Jefe_Final implements Enemigo{
    private String nombre;
    private int vida, dano_base;

    public Jefe_Final(String nombre, int vida, int dano_base) {
        this.nombre = nombre;
        this.vida = vida;
        this.dano_base = dano_base;
    }


    @Override
    public void combate(Jugador player) {
        int fase = 2, vida_inicial = vida;
        System.out.println("**************************");
        System.out.println("*~COMBATE FINAL INICIADO~*");
        System.out.println("**************************");
        System.out.println(nombre+": Eres fuerte...\n"+nombre+": PERO CRISTO LO ES MÁS");
        while(player.getVida() >0 && vida > 0){
            if (vida <= vida_inicial/2){
                System.out.println(nombre+" está cansado y pega menos... ¿qué?");
                fase = 1;
            }
            System.out.println("VIDA: "+player.getVida());
            System.out.println("VIDA de "+nombre+": "+vida);
            Scanner scan = new Scanner(System.in);
            System.out.println("COMBATE \n ELIGE UNA OPCIÓN \n 1 --> ATAQUE \n 2 --> HECHIZO\n");
            int opt = scan.nextInt();
            switch (opt) {
                case 1 -> {
                    int atq = player.ataque();
                    System.out.println(" ~ patada nuclear ~ ");
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
                System.out.println("* ganaste el combate final :v *");
                System.exit(0);
                break;
            }
            player.setVida(player.getVida()-dano_base*fase);
            System.out.println("* recibes "+dano_base*fase+" de daño *\n OOF");
        }
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setDano_base(int dano_base) {
        this.dano_base = dano_base;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getDano_base() {
        return dano_base;
    }
}
