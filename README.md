# Sistema de Logística em Java

Projeto desenvolvido para a disciplina de Programação Orientada a Objetos.

## Descrição

Sistema de gerenciamento de entregas com cadastro de entregadores, atribuição de entregas e controle de status, desenvolvido em Java com aplicação dos principais conceitos de POO.

## Conceitos Aplicados

- Herança: EntregadorMoto, EntregadorBicicleta e EntregadorCarro estendem a classe abstrata Entregador
- Interface: Calculavel define os contratos calcularCusto e calcularTempoEstimado
- Classe Abstrata: Entregador concentra os atributos e comportamentos comuns
- Enum: StatusEntrega controla os estados PENDENTE, EM_ROTA, ENTREGUE e CANCELADO
- Sobrecarga de métodos: aplicada em calcularCusto, atualizarStatus e exibirInfo

## Estrutura do Projeto

- model/ — classes de domínio (Entregador, Entrega, StatusEntrega e subclasses)
- interfaces/ — interface Calculavel
- service/ — SistemaLogistica com a lógica de negócio
- Main.java — menu interativo via terminal

