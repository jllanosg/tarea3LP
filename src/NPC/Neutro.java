package NPC;

import Jugador.Jugador;
import Mision.Mision;
import java.util.Scanner;

public class Neutro extends NPC{

    // requisito
    // 'm' --> matar
    // 'v' --> moverse

    private char requisito;
    private int valor, recompensa, ya_dio_mision = 0;
    public Neutro(String nombre, char requisito, int valor, int recompensa) {
        super(nombre);
        this.requisito = requisito;
        this.valor = valor;
        this.recompensa = recompensa;
    }
    private Mision mision_npc;
    public char getRequisito() {
        return requisito;
    }

    public int getValor() {
        return valor;
    }

    public int getRecompensa() {
        return recompensa;
    }

    public int getYa_dio_mision() {
        return ya_dio_mision;
    }

    public void setRequisito(char requisito) {
        this.requisito = requisito;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }

    public void setYa_dio_mision(int ya_dio_mision) {
        this.ya_dio_mision = ya_dio_mision;
    }

    @Override
    public void interaccion(Jugador player) {
        if (ya_dio_mision == 0){
            if (requisito == 'v'){
                System.out.println(getNombre()+": hola, ¿quieres cumplir esta mision? Deberas llegar a la  "+valor
                        +" del mundo y recibirás "+recompensa+" de xp");
                mision_npc = new Mision(this.requisito,this.valor,player.getPosicion(),this.recompensa);
            }else if (requisito == 'm'){
                System.out.println(getNombre()+": hola, ¿quieres cumplir esta mision? Deberas matar a "+valor
                        +" monstruo(s) y recibirás "+recompensa+" de xp");
                mision_npc = new Mision(this.requisito,this.valor,0,this.recompensa);
            }
            Scanner scan = new Scanner(System.in);
            System.out.println("INGRESE OPCIÓN \n 1 --> ACEPTAR MISIÓN \n 2 --> RECHAZAR MISIÓN");
            int preg = scan.nextInt();
            switch (preg) {
                case 1 -> {
                    //asignar mision
                    System.out.println("GARSIAS :V");
                    player.getLista_misiones().add(mision_npc);
                    this.ya_dio_mision = 1;
                }
                case 2 -> System.out.println("PUXA LA LESERA :'V");
                default -> System.out.println("Pone bien la cosa ");
            }
        }else {
            System.out.println("YA TE DI MISION SALU22222222222222222 !!!!!!!!!!!");
        }
    }
}
