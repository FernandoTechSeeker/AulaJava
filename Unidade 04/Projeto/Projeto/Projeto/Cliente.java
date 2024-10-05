package Projeto;

public class Cliente {
    private String nome;
    private String endereco;
    private String telefone;

    // Construtor
    public Cliente(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }
}
