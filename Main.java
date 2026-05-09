import model.*;
import service.SistemaLogistica;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaLogistica sistema = new SistemaLogistica();
        int opcao;

        do {
            System.out.println("\n========== SISTEMA DE LOGÍSTICA ==========");
            System.out.println("1. Cadastrar entregador");
            System.out.println("2. Criar entrega");
            System.out.println("3. Listar entregas");
            System.out.println("4. Listar entregadores");
            System.out.println("5. Atribuir entrega a entregador");
            System.out.println("6. Atualizar status de entrega");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do entregador: ");
                    String nome = scanner.nextLine();
                    System.out.println("Tipo: 1-Moto | 2-Bicicleta | 3-Carro");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    String id = "E" + (sistema.getEntregadores().size() + 1);
                    switch (tipo) {
                        case 1 -> sistema.cadastrarEntregador(new EntregadorMoto(id, nome));
                        case 2 -> sistema.cadastrarEntregador(new EntregadorBicicleta(id, nome));
                        case 3 -> sistema.cadastrarEntregador(new EntregadorCarro(id, nome));
                        default -> System.out.println("Tipo inválido.");
                    }
                }
                case 2 -> {
                    System.out.print("Endereço de destino: ");
                    String destino = scanner.nextLine();
                    System.out.print("Distância em km: ");
                    double dist = scanner.nextDouble();
                    scanner.nextLine();
                    sistema.criarEntrega(destino, dist);
                }
                case 3 -> sistema.listarEntregas();
                case 4 -> sistema.listarEntregadores();
                case 5 -> {
                    System.out.print("ID da entrega (ex: ENT-1): ");
                    String idEntrega = scanner.nextLine();
                    sistema.listarEntregadores();
                    System.out.print("Número do entregador (0 = primeiro): ");
                    int idx = scanner.nextInt();
                    scanner.nextLine();
                    sistema.atribuirEntrega(idEntrega, idx);
                }
                case 6 -> {
                    System.out.print("ID da entrega: ");
                    String idEntrega = scanner.nextLine();
                    System.out.println("Status: 1-EM_ROTA | 2-ENTREGUE | 3-CANCELADO");
                    int s = scanner.nextInt();
                    scanner.nextLine();
                    StatusEntrega novoStatus = switch (s) {
                        case 1 -> StatusEntrega.EM_ROTA;
                        case 2 -> StatusEntrega.ENTREGUE;
                        case 3 -> StatusEntrega.CANCELADO;
                        default -> null;
                    };
                    if (novoStatus != null) sistema.atualizarStatus(idEntrega, novoStatus);
                    else System.out.println("Status inválido.");
                }
                case 0 -> System.out.println("Encerrando sistema.");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}