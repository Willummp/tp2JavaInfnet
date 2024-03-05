package com.infnet.tp2;
import com.infnet.tp2.gerenciador.Pontos;
import com.infnet.tp2.lista.ListaTarefa;
import com.infnet.tp2.lista.Tarefa;
import static com.infnet.tp2.utils.lerInt.lerInt;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;


public class App {
    private static Scanner sc = new Scanner(System.in);
    private static Pontos pontuacao = new Pontos();

    public static void main(String[] args) {
        while (true) {
            int opcao;
            System.out.println("A sua pontuação atual é = " + pontuacao.getPontos());
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Exibir lista de tarefas");
            System.out.println("2 - Adicionar uma tarefa");
            System.out.println("3 - Ver as tarefas");
            System.out.println("4 - Concluir tarefa");
            System.out.println("5 - Fechar");

            try {
                opcao = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Opção incorreta");
                lerInt(sc);
                continue;
            }
            switch (opcao) {
                case 1:
                    List<Tarefa> tarefas = ListaTarefa.getInstance().getTarefas();
                    if (tarefas.isEmpty()) {
                        System.out.println("Não há tarefas cadastradas.");
                    } else {
                        listarTarefas(tarefas);
                    }
                    break;
                case 2:
                    addTarefa();
                    break;
                case 3:
                    tarefas = ListaTarefa.getInstance().getTarefas();
                    if (tarefas.isEmpty()) {
                        System.out.println("Não há tarefas cadastradas.");
                    } else {
                        System.out.println("Selecione a tarefa: ");
                        listarTarefas(tarefas);
                        int indexTarefa = lerInt(sc);
                        if (indexTarefa >= 0 && indexTarefa <= tarefas.size()) {
                            verTarefa(indexTarefa - 1);
                        } else {
                            System.out.println("Tarefa selecionada inválida");
                        }
                    }
                    break;
                case 4:
                    tarefas = ListaTarefa.getInstance().getTarefas();
                    if (tarefas.isEmpty()) {
                        System.out.println("Não existem tarefas cadastradas");
                    } else {
                        System.out.println("Selecione a tarefa: ");
                        listarTarefas(tarefas);
                        int indexTarefa = lerInt(sc);
                        if (indexTarefa >= 0 && indexTarefa <= tarefas.size()) {
                            if (tarefas.get(indexTarefa - 1).isConcluida()) {
                                System.out.println("Tarefa já concluída");
                                break;
                            }
                            tarefas.get(indexTarefa - 1).concluir();
                            System.out.println("Tarefa concluída");
                            pontuacao.atualizarPontuacao(true);
                        } else {
                            System.out.println("Tarefa selecionada inválida");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Fechando o programa");
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    public static void addTarefa() {
        System.out.println("Digite o título da tarefa:");
        String titulo = sc.nextLine();
        System.out.println("Digite a descrição da tarefa:");
        String descricao = sc.nextLine();
        Tarefa tarefa = new Tarefa(titulo, descricao);
        ListaTarefa.getInstance().addTarefa(tarefa);
        System.out.println("Tarefa adicionada com sucesso.");
    }

    public static void listarTarefas(List<Tarefa> tarefas) {
        for (int j = 0; j < tarefas.size(); j++) {
            Tarefa tarefa = tarefas.get(j);
            System.out.println(
                    (j + 1) + " - " + tarefa.getTitulo() + (tarefa.isConcluida() ? "- Concluída" : "- Em Progresso")
            );
        }
    }
    public static void verTarefa(int tarefaIndex) {
        List<Tarefa> tarefas = ListaTarefa.getInstance().getTarefas();
        Tarefa tarefa = tarefas.get(tarefaIndex);
        System.out.println(tarefa.toString());
    }
}
