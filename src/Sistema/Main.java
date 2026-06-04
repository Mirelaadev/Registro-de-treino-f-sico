package Sistema;
import Entidades.Exercico;
import Entidades.Treino;
import Entidades.Usuario;
import Banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    private static PreparedStatement ps;
    private static ResultSet rs;

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

        try {
            String SQL = "INSERT INTO usuario(nome, idade, email, nome_treino, data_treino) values (?, ?, ?, ?,?)";

            ps = new Conexao().getCon().prepareStatement(SQL);

            ps.setString(1, usuario.getNome());
            ps.setInt(2, usuario.getIdade());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, treino.getNomeTreino());
            ps.setString(5, treino.getDataTreino());


            ps.executeUpdate();
            ps.close();
            System.out.println("Dados salvos com sucesso");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        int opcao;

        do {
            System.out.println("\n-------------------------------");
            System.out.println("1 - Adicionar exercício");
            System.out.println("2 - Listar exercícios");
            System.out.println("3 - Atualizar exercício");
            System.out.println("4 - Remover exercício");
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


                try {
                    String SQL = "INSERT INTO exercicio(nome, series, repeticoes, observacoes) VALUES (?, ?, ?, ?)";

                    Connection con = new Conexao().getCon();

                    PreparedStatement ps = con.prepareStatement(SQL);

                    ps.setString(1, exercicio.getNome());
                    ps.setInt(2, exercicio.getSeries());
                    ps.setInt(3, exercicio.getRepeticoes());
                    ps.setString(4, exercicio.getObservacoes());

                    ps.executeUpdate();

                    ps.close();

                    System.out.println("Exercício salvo no banco!");

                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }


            else if(opcao == 2) {
                System.out.println("\nLISTA DE EXERCÍCIOS");
                //treino.listarExercicios();

                try {
                    String SQL = "SELECT * FROM exercicio";

                    rs = new Conexao().getCon().createStatement().executeQuery(SQL);

                    while(rs.next()){
                        System.out.println("ID: " + rs.getInt("id"));
                        System.out.println("Nome: " + rs.getString("nome"));
                        System.out.println("Séries: " + rs.getInt("series"));
                        System.out.println("Repetições: " + rs.getInt("repeticoes"));
                        System.out.println("Observações: " + rs.getString("observacoes"));
                        System.out.println("-------------------");

                    }
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            else if(opcao == 3){

                System.out.println("Digite o ID do exercício que deseja editar:");
                int id = Integer.parseInt(sc.nextLine());

                System.out.println("Novo nome do exercício:");
                String novoNome = sc.nextLine();

                System.out.println("Nova quantidade de séries:");
                int novasSeries = Integer.parseInt(sc.nextLine());

                System.out.println("Nova quantidade de repetições:");
                int novasRepeticoes = Integer.parseInt(sc.nextLine());

                System.out.println("Novas observações:");
                String novasObservacoes = sc.nextLine();

                try {

                    String SQL = "UPDATE exercicio SET nome=?, series=?, repeticoes=?, observacoes=? WHERE id=?";

                    ps = new Conexao().getCon().prepareStatement(SQL);

                    ps.setString(1, novoNome);
                    ps.setInt(2, novasSeries);
                    ps.setInt(3, novasRepeticoes);
                    ps.setString(4, novasObservacoes);
                    ps.setInt(5, id);

                    ps.executeUpdate();

                    ps.close();

                    System.out.println("Exercício atualizado com sucesso!");

                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }
            else if(opcao == 4) {

                System.out.println("Digite o ID do exercício que deseja remover:");
                int id = Integer.parseInt(sc.nextLine());

                try {
                    String SQL = "DELETE FROM exercicio WHERE id = ?";

                    ps = new Conexao().getCon().prepareStatement(SQL);
                    ps.setInt(1, id);
                    ps.executeUpdate();

                    ps.close();

                    System.out.println("Exercício removido com sucesso!");

                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        } while(opcao != 0);
        System.out.println("Sistema encerrado.");
        sc.close();
    }
}