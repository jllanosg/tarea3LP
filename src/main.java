import Enemigo.Monstruo;
import Jugador.Guerrero;
import Jugador.Jugador;
import Jugador.Mago;
import Jugador.Druida;
import Mision.Mision;
import NPC.Bueno;
import NPC.Malo;
import NPC.Neutro;
import NPC.NPC;

import java.util.ArrayList;
import java.util.Scanner;

import Enemigo.Jefe_Final;
import Tierra.Montaña;
import Tierra.Tierra;
import Tierra.Bosque;
import Tierra.Planicie;


public class main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Jugador player;
        //CREACIÓN DEL MUNDO Y SUS TIERRAS

        System.out.println("Ingrese tamaño del mundo: ");
        int tam_mundo = in.nextInt();
        in.nextLine();
        ArrayList<Tierra> mundo = new ArrayList<>();

        for (int i=0; i<tam_mundo;i++){
            NPC npc = null;
            Monstruo monstruo = null;
            Jefe_Final jefe_final = null;

            //DEFINICION TIPO DE TIERRA
            System.out.println("Ingrese tipo de tierra para tierra "+i+"\n 1 --> Bosque\n 2 --> Montaña\n 3 --> Planicie");
            int tipo_tierra = in.nextInt();
            in.nextLine();
            //PROBABILIDAD DE ENEMIGO
            System.out.println("Ingrese probabilidad de enemigo para la tierra "+i);
            float prob = in.nextFloat();
            System.out.println(prob);
            in.nextLine();
            //CREACIÓN MONSTRUO O JEFE FINAL
            System.out.println("Desea colocar:\n 1 --> MONSTRUO\n 2 --> JEFE FINAL\n 3 --> NO");
            int opt_enemigo = in.nextInt();
            in.nextLine();
            switch (opt_enemigo) {
                case 1 -> {
                    int dano, vida;
                    System.out.println("Ingrese vida del monstruo: ");
                    vida = in.nextInt();
                    System.out.println("Ingrese daño del monstruo: ");
                    dano = in.nextInt();
                    in.nextLine();
                    monstruo = new Monstruo(vida, dano);
                }
                case 2 -> {
                    int dano_jefe, vida_jefe;
                    String nombre;
                    System.out.println("Ingrese nombre para el jefe final: ");
                    nombre = in.nextLine();
                    System.out.println("Ingrese vida del jefe final: ");
                    vida_jefe = in.nextInt();
                    System.out.println("Ingrese daño del jefe final: ");
                    dano_jefe = in.nextInt();
                    in.nextLine();
                    jefe_final = new Jefe_Final(nombre, vida_jefe, dano_jefe);
                }
                default -> {
                }
            }

            // CREACIÓN NPC
            System.out.println("~ Desea crear NPC?\n 1 --> SI \n 2 --> NO");
            int opt_npc = in.nextInt();
            in.nextLine();
            if (opt_npc==1){
                System.out.println("Ingrese nombre NPC:");
                String nombre = in.nextLine();
                System.out.println("Ingrese tipo NPC\n 1 --> BUENO\n 2 --> MALO\n 3 --> NEUTRO");
                int int_tipo_npc = in.nextInt();
                in.nextLine();
                switch (int_tipo_npc) {
                    case 1 -> {
                        System.out.println("Ingrese atributo (Vida / Mana / Energia / Xp)");
                        String atributo = in.nextLine();
                        System.out.println("Ingrese cantidad de " + atributo);
                        int cantidad_atributo = in.nextInt();
                        npc = new Bueno(nombre, atributo, cantidad_atributo);
                    }
                    case 2 -> {
                        int energia, mana;
                        System.out.println("Ingrese cantidad de energía a quitar: ");
                        energia = in.nextInt();
                        System.out.println("Ingrese cantidad de maná a quitar: ");
                        mana = in.nextInt();
                        npc = new Malo(nombre, energia, mana);
                    }
                    case 3 -> {
                        char requisito;
                        int valor, recompensa;
                        System.out.println("Ingrese requisito\n (v --> viajar / m --> matar)");
                        requisito = in.nextLine().charAt(0);
                        System.out.println("Ingrese valor de -valor-: ");
                        valor = in.nextInt();
                        System.out.println("Ingrese valor de -recompensa-: ");
                        recompensa = in.nextInt();
                        System.out.println("req = "+requisito+"valor = "+valor);
                        npc = new Neutro(nombre, requisito, valor, recompensa);
                    }
                }
            }

            if (tipo_tierra == 1){
                Tierra t = new Bosque(prob,monstruo,jefe_final,npc);
                mundo.add(t);
            }else if (tipo_tierra == 2){
                Tierra t = new Montaña(prob,monstruo,jefe_final,npc);
                mundo.add(t);
            }else if (tipo_tierra == 3){
                Tierra t = new Planicie(prob,monstruo,jefe_final,npc);
                mundo.add(t);
            }
        } // FIN FOR DE TIERRAS

        System.out.println("Mundo creado satisfactoriamente ! \n \n \n");

        //CREACIÓN DEL PERSONAJE
        System.out.println("Ingrese posición inicial en el mundo (0-"+(tam_mundo-1)+")");
        int pos_inicial = in.nextInt();
        in.nextLine();
        System.out.println("Ingrese el nombre del personaje: ");
        String nombre = in.nextLine();
        System.out.println("Ingrese clase de su personaje\n 1 --> Guerrero\n 2 --> Mago \n 3 --> Druida (no está en el meta :p)");
        int clase = in.nextInt();
        in.nextLine();

        switch (clase) {
            case 1 -> player = new Guerrero(nombre, pos_inicial);
            case 2 -> player = new Mago(nombre, pos_inicial);
            case 3 -> player = new Druida(nombre, pos_inicial);
            default -> player = new Guerrero(nombre,pos_inicial+1);
            }

        //Inicio de la partida
        System.out.println("***** BIENVENIDO A THE LEGEND OF MORIO *****");

        System.out.println("Ingrese una acción:\n 1 --> MOVERSE\n 2 --> VER ATRIBUTOS");
        int action = in.nextInt();
        while (action != 3){

            if (action == 1){
                System.out.println("Ingrese una dirección: \n 1 --> DERECHA\n 2 --> IZQUIERda");
                int opt = in.nextInt();
                if (opt == 1){
                    int pos = player.getPosicion();
                    if (pos == tam_mundo-1){
                        pos = 0;
                    }else{
                        pos++;
                    }
                    if (mundo.get(pos).accion(player)){
                        player.setPosicion(pos);
                        for (Mision m:player.getLista_misiones()) {
                            if (m.getRequisito() == 'v') {
                                m.setCantidad(player.getPosicion());
                                if (m.verificar_requisito()) {
                                    player.subir_experiencia(m.getRecompensa());
                                    player.getLista_misiones().remove(m);
                                }
                            }
                        }
                    }else{
                        if (player.getVida()<=0){
                            System.out.println("***** muelto *****");
                            break;
                        }else{
                            System.out.println("No puedes pasar !");
                        }
                    }
                }else if (opt == 2){
                    int pos = player.getPosicion();
                    if (pos == 0){
                        pos = tam_mundo-1;
                    }else{
                        pos--;
                    }
                    if (mundo.get(pos).accion(player)){
                        player.setPosicion(pos);
                        for (Mision m:player.getLista_misiones()) {
                            if (m.getRequisito() == 'v') {
                                m.setCantidad(player.getPosicion());
                                if (m.verificar_requisito()) {
                                    player.subir_experiencia(m.getRecompensa());
                                    player.getLista_misiones().remove(m);
                                }
                            }
                        }
                    }else{
                        if (player.getVida()<=0){
                            System.out.println("***** muelto *****");
                            break;
                        }else{
                            System.out.println("No puedes pasar !");
                        }
                    }

                }
            }else if(action == 2){
                System.out.println("_________________________________");
                System.out.println("ATRIBUTOS DE "+player.getNombre());
                System.out.println("_________________________________");
                System.out.println("Vida: "+player.getVida());
                System.out.println("Experiencia: "+player.getXp());
                System.out.println("Fuerza: "+player.getFuerza());
                System.out.println("Inteligencia: "+player.getInteligencia());
                System.out.println("Energía: "+player.getEnergia());
                System.out.println("Maná: "+player.getMana());
                System.out.println("Posición: "+player.getPosicion());
                System.out.println("_________________________________");
            }

            System.out.println("Ingrese una acción:\n 1 --> MOVERSE\n 2 --> VER ATRIBUTOS");
            action = in.nextInt();
        }


    }
}
