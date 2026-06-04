package Entidades;
import Interfaces.OperacoesTreino;

public class Usuario extends Pessoa implements OperacoesTreino {

    private String email;
    private int id;

    public Usuario(String nome, int idade, String email) {
        super(nome, idade);
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void exibirDados() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Email: " + getEmail());
    }

    @Override
    public void inicarTreino() {
        System.out.println("Treino inicado");
    }

    @Override
    public void finalizarTreino() {
        System.out.println("Treino finalizado");
    }
}
