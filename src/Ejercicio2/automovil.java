package Ejercicio2;

public class automovil {
    private int placa;
    private int movimientos;

    public automovil(int placa) {
        this.placa = placa;
        this.movimientos = 0;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public int getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(int movimientos) {
        this.movimientos = movimientos;
    }
}
