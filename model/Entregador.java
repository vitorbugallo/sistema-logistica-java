package model;

import interfaces.Calculavel;

public abstract class Entregador implements Calculavel {

    private String id;
    private String nome;
    private String veiculo;
    private boolean disponivel;

    public Entregador(String id, String nome, String veiculo) {
        this.id = id;
        this.nome = nome;
        this.veiculo = veiculo;
        this.disponivel = true;
    }

    public String exibirInfo() {
        return String.format("[%s] %s | Veículo: %s | Disponível: %s",
                id, nome, veiculo, disponivel ? "Sim" : "Não");
    }

    public String exibirInfo(boolean mostrarDetalhes) {
        if (mostrarDetalhes) {
            return exibirInfo() + String.format(
                    " | Custo/km: R$ %.2f | Tempo/km: %d min",
                    calcularCusto(1), calcularTempoEstimado(1));
        }
        return exibirInfo();
    }

    @Override
    public abstract double calcularCusto(double distanciaKm);

    @Override
    public abstract int calcularTempoEstimado(double distanciaKm);

    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getVeiculo() { return veiculo; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
}