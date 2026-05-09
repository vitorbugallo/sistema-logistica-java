package model;

public class EntregadorMoto extends Entregador {

    private double taxaUrgencia;

    public EntregadorMoto(String id, String nome) {
        super(id, nome, "Moto");
        this.taxaUrgencia = 1.5;
    }

    @Override
    public double calcularCusto(double distanciaKm) {
        return distanciaKm * 2.50;
    }

    public double calcularCusto(double distanciaKm, boolean urgente) {
        double custo = calcularCusto(distanciaKm);
        return urgente ? custo * taxaUrgencia : custo;
    }

    @Override
    public int calcularTempoEstimado(double distanciaKm) {
        return (int) ((distanciaKm / 60.0) * 60);
    }
}