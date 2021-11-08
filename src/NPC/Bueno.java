package NPC;

import Jugador.Jugador;

public class Bueno extends NPC{

    private String atributo;
    private int cantidad;

    public Bueno(String nombre, String atributo, int cantidad) {
        super(nombre);
        this.atributo = atributo;
        this.cantidad = cantidad;
    }

    @Override
    public void interaccion(Jugador player) {
        System.out.println(getNombre() + ": Creo que necesitas un poco de ayuda, te subire "+ cantidad +" a tu "+ atributo +"!!!!");
        if (atributo.equals("Vida")){
            if (player.getVida() + cantidad >= player.getVidaMax()) {
                player.setVida(player.getVidaMax());
            }else{
                player.setVida(player.getVida()+cantidad);
            }
        }else if (atributo.equals("Energia")){
            if (player.getEnergia() + cantidad >= player.getEnergiaMax()) {
                player.setEnergia(player.getEnergiaMax());
            }else{
                player.setEnergia(player.getEnergia()+cantidad);
            }
        }else if (atributo.equals("Mana")){
            if (player.getMana() + cantidad >= player.getManaMax()) {
                player.setMana(player.getMana());
            }else{
                player.setMana(player.getMana()+cantidad);
            }
        }else if (atributo.equals("Xp")){
            player.subir_experiencia(cantidad);
        }
    }

}
