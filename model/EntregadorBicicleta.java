package model;

public class EntregadorBicicleta extends Entregador {

    public EntregadorBicicleta(String id, String nome) {
        super(id, nome, "Bicicleta");
    }

    @Override
    public double calcularCusto(double distanciaKm) {
        return distanciaKm * 1.00;
    }

    @Override
    public int calcularTempoEstimado(double distanciaKm) {
        return (int) ((distanciaKm / 20.0) * 60);
    }
}
