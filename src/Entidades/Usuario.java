package Entidades;
import Interfaces.OperacoesTreino;

public class Usuario extends Pessoa implements OperacoesTreino {

    private String email;
    private String senha;
    private Treino[] treinos;

    public Usuario(String nome, int idade, String email) {
        super(nome, idade);
        this.email = email;
    }

    public Treino[] getTreino() {
        return treinos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTreino(Treino[] treino) {
        this.treinos = treino;
    }

    @Override
    public void exibirDados(){
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Email: "+ getEmail());
    }

    @Override
    public void inicarTreino() {
        System.out.println("Entidades.Treino inicado");
    }

    @Override
    public void finalizarTreino() {
        System.out.println("Entidades.Treino finalizado");
    }

    @Override
    public void listarTreino() {
        for(Treino treino : treinos){
            treino.listarExercicios();
        }
    }
}
