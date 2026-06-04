package Entidades;
import java.util.ArrayList;

public class Treino {

    private String nomeTreino;
    private String dataTreino;
    private ArrayList<Exercico> exercicios;

    public Treino(String nomeTreino, String dataTreino) {
        this.nomeTreino = nomeTreino;
        this.dataTreino = dataTreino;
        exercicios = new ArrayList<>();
    }

    public String getNomeTreino() {
        return nomeTreino;
    }

    public void setNomeTreino(String nomeTreino) {
        this.nomeTreino = nomeTreino;
    }

    public String getDataTreino() {
        return dataTreino;
    }

    public void setDataTreino(String dataTreino) {
        this.dataTreino = dataTreino;
    }

    public ArrayList<Exercico> getExercicios() {
        return exercicios;
    }

    public void setExercicios(ArrayList<Exercico> exercicios) {
        this.exercicios = exercicios;
    }

    public void addExercicio(Exercico exercicio) {
        exercicios.add(exercicio);
    }

    public void removerExercicio(Exercico exercicio) {
        exercicios.remove(exercicio);
    }

    public void listarExercicios() {

        if(exercicios.isEmpty()) {
            System.out.println("Nenhum exercício cadastrado!");
            return;
        }
        System.out.println("Treino: " + nomeTreino);
        System.out.println("Data: " + dataTreino);

        for(Exercico exercicio : exercicios) {
            exercicio.exibirExercicio();
        }
    }

    public Exercico buscarExercicio(String nome) {
        for(Exercico exercicio : exercicios) {
            if(exercicio.getNome().equalsIgnoreCase(nome)) {
                return exercicio;
            }
        }
        return null;
    }
    public void editarExercicio(String nomeBusca, String novoNome, int novasSeries, int novasRepeticoes, String novasObservacoes) {

        Exercico exercicioEncontrado = buscarExercicio(nomeBusca);

        if(exercicioEncontrado != null) {
            exercicioEncontrado.setNome(novoNome);
            exercicioEncontrado.setSeries(novasSeries);
            exercicioEncontrado.setRepeticoes(novasRepeticoes);
            exercicioEncontrado.setObservacoes(novasObservacoes);

            System.out.println("Exercício editado com sucesso!");
        } else {
            System.out.println("Exercício não encontrado.");
        }

    }
}