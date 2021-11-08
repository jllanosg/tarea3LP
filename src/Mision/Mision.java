package Mision;

public class Mision {

    private char requisito;
    private int valor, cantidad, recompensa;

    public Mision(char requisito, int valor, int cantidad, int recompensa) {
        this.requisito = requisito;
        this.valor = valor;
        this.cantidad = cantidad;
        this.recompensa = recompensa;
    }

    public boolean verificar_requisito(){
        return valor == cantidad;
    }

    public char getRequisito() {
        return requisito;
    }

    public int getValor() {
        return valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getRecompensa() {
        return recompensa;
    }

    public void setRequisito(char requisito) {
        this.requisito = requisito;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }
}
