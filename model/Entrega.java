package model;

public class Entrega {

    private static int contador = 1;

    private String id;
    private String enderecoDestino;
    private double distanciaKm;
    private StatusEntrega status;
    private Entregador entregador;

    public Entrega(String enderecoDestino, double distanciaKm) {
        this.id = "ENT-" + (contador++);
        this.enderecoDestino = enderecoDestino;
        this.distanciaKm = distanciaKm;
        this.status = StatusEntrega.PENDENTE;
        this.entregador = null;
    }

    public void atribuirEntregador(Entregador entregador) {
        if (!entregador.isDisponivel()) {
            System.out.println("Entregador indisponível.");
            return;
        }
        this.entregador = entregador;
        this.status = StatusEntrega.EM_ROTA;
        entregador.setDisponivel(false);
        System.out.println("Entregador " + entregador.getNome() + " atribuído à entrega " + id + ".");
    }

    public void atualizarStatus(StatusEntrega novoStatus) {
        this.status = novoStatus;
        if (novoStatus == StatusEntrega.ENTREGUE && entregador != null) {
            entregador.setDisponivel(true);
        }
        System.out.println("Status da entrega " + id + " atualizado para: " + novoStatus);
    }

    public void atualizarStatus(StatusEntrega novoStatus, String motivo) {
        atualizarStatus(novoStatus);
        System.out.println("Motivo: " + motivo);
    }

    public void exibirDetalhes() {
        System.out.println("-----------------------------");
        System.out.println("ID: " + id);
        System.out.println("Destino: " + enderecoDestino);
        System.out.printf("Distância: %.1f km%n", distanciaKm);
        System.out.println("Status: " + status);
        if (entregador != null) {
            System.out.println("Entregador: " + entregador.getNome() + " (" + entregador.getVeiculo() + ")");
            System.out.printf("Custo estimado: R$ %.2f%n", entregador.calcularCusto(distanciaKm));
            System.out.println("Tempo estimado: " + entregador.calcularTempoEstimado(distanciaKm) + " min");
        } else {
            System.out.println("Entregador: não atribuído");
        }
        System.out.println("-----------------------------");
    }

    public String getId() { return id; }
    public StatusEntrega getStatus() { return status; }
    public Entregador getEntregador() { return entregador; }
}
