package Sistema;
import Entidades.Exercico;
import Entidades.Treino;
import Entidades.Usuario;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("REGISTRO DE TREINO FÍSICO ONLINE");
        System.out.println("=================================");

        System.out.println("Digite seu nome:");
        String nome = sc.nextLine();

        System.out.println("Digite sua idade:");
        int idade = Integer.parseInt(sc.nextLine());

        System.out.println("Digite seu email:");
        String email = sc.nextLine();

        Usuario usuario = new Usuario(nome, idade, email);

        Treino treino = new Treino();

        System.out.println("Digite o nome do treino:");
        String nomeTreino = sc.nextLine();
        treino.setNomeTreino(nomeTreino);

        System.out.println("Digite a data do treino:");
        String dataTreino = sc.nextLine();
        treino.setDataTreino(dataTreino);

        int opcao;

        do {
            System.out.println("\n-------------------------------");
            System.out.println("1 - Adicionar exercício");
            System.out.println("2 - Listar exercícios");
            System.out.println("3 - Buscar exercício");
            System.out.println("4 - Atualizar exercício");
            System.out.println("5 - Remover exercício");
            System.out.println("0 - Sair");
            System.out.println("-------------------------------");

            opcao = Integer.parseInt(sc.nextLine());

            if(opcao == 1) {
                System.out.println("Nome do exercício:");
                String nomeExercicio = sc.nextLine();

                System.out.println("Quantidade de séries:");
                int series = Integer.parseInt(sc.nextLine());

                System.out.println("Quantidade de repetições:");
                int repeticoes = Integer.parseInt(sc.nextLine());

                System.out.println("Observações:");
                String observacoes = sc.nextLine();

                Exercico exercicio = new Exercico(nomeExercicio, series, repeticoes, observacoes);

                treino.addExercicio(exercicio);

                System.out.println("Exercício adicionado com sucesso!");

            }

            else if(opcao == 2) {
                System.out.println("\nLISTA DE EXERCÍCIOS");
                treino.listarExercicios();
            }

            else if(opcao == 3) {

                System.out.println("Digite o nome do exercício:");
                String nomeBusca = sc.nextLine();

                Exercico exercicioEncontrado = treino.buscarExercicio(nomeBusca);

                if(exercicioEncontrado != null) {
                    System.out.println("Exercício encontrado:");
                    exercicioEncontrado.exibirExercicio();

                } else {
                    System.out.println("Exercício não encontrado.");
                }
            }
            else if(opcao == 4){

                System.out.println("Digite o nome do exercício que deseja editar:");
                String nomeBusca = sc.nextLine();

                System.out.println("Novo nome do exercício:");
                String novoNome = sc.nextLine();

                System.out.println("Nova quantidade de séries:");
                int novasSeries = Integer.parseInt(sc.nextLine());

                System.out.println("Nova quantidade de repetições:");
                int novasRepeticoes = Integer.parseInt(sc.nextLine());

                System.out.println("Novas observações:");
                String novasObservacoes = sc.nextLine();

                treino.editarExercicio(
                        nomeBusca,
                        novoNome,
                        novasSeries,
                        novasRepeticoes,
                        novasObservacoes
                );

            }

            else if(opcao == 5) {
                System.out.println("Digite o nome do exercício que deseja remover:");
                String nomeBusca = sc.nextLine();

                Exercico exercicioEncontrado = treino.buscarExercicio(nomeBusca);

                if(exercicioEncontrado != null) {
                    treino.removerExercicio(exercicioEncontrado);
                    System.out.println("Exercício removido com sucesso!");

                } else {
                    System.out.println("Exercício não encontrado.");
                }
            }

            else if(opcao != 0) {
                System.out.println("Opção inválida.");
            }

        } while(opcao != 0);
        System.out.println("Sistema encerrado.");
        sc.close();
    }
}