package model;

public class EntregadorCarro extends Entregador {

    private double taxaPedagio;

    public EntregadorCarro(String id, String nome) {
        super(id, nome, "Carro");
        this.taxaPedagio = 5.00;
    }

    @Override
    public double calcularCusto(double distanciaKm) {
        return (distanciaKm * 3.50) + taxaPedagio;
    }

    @Override
    public int calcularTempoEstimado(double distanciaKm) {
        return (int) ((distanciaKm / 40.0) * 60);
    }
}
