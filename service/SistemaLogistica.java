package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class SistemaLogistica {

    private List<Entregador> entregadores = new ArrayList<>();
    private List<Entrega> entregas = new ArrayList<>();

    public void cadastrarEntregador(Entregador e) {
        entregadores.add(e);
        System.out.println("Entregador cadastrado: " + e.getNome());
    }

    public void criarEntrega(String destino, double distancia) {
        Entrega entrega = new Entrega(destino, distancia);
        entregas.add(entrega);
        System.out.println("Entrega criada para: " + destino);
    }

    public void listarEntregas() {
        if (entregas.isEmpty()) {
            System.out.println("Nenhuma entrega cadastrada.");
            return;
        }
        for (Entrega e : entregas) {
            e.exibirDetalhes();
        }
    }

    public void listarEntregadores() {
        if (entregadores.isEmpty()) {
            System.out.println("Nenhum entregador cadastrado.");
            return;
        }
        for (Entregador e : entregadores) {
            System.out.println(e.exibirInfo());
        }
    }

    public void atribuirEntrega(String idEntrega, int indexEntregador) {
        Entrega entrega = buscarEntrega(idEntrega);
        if (entrega == null) {
            System.out.println("Entrega não encontrada.");
            return;
        }
        if (indexEntregador < 0 || indexEntregador >= entregadores.size()) {
            System.out.println("Entregador inválido.");
            return;
        }
        entrega.atribuirEntregador(entregadores.get(indexEntregador));
    }

    public void atualizarStatus(String idEntrega, StatusEntrega status) {
        Entrega entrega = buscarEntrega(idEntrega);
        if (entrega == null) {
            System.out.println("Entrega não encontrada.");
            return;
        }
        entrega.atualizarStatus(status);
    }

    private Entrega buscarEntrega(String id) {
        for (Entrega e : entregas) {
            if (e.getId().equalsIgnoreCase(id)) return e;
        }
        return null;
    }

    public List<Entregador> getEntregadores() { return entregadores; }
    public List<Entrega> getEntregas() { return entregas; }
}
