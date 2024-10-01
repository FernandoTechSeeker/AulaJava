package Projeto;
// pacote o java vai entender que tudo está no pacote para o ecommerce 
public class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    //montando os atributos 
    public Cliente(String nome, String endereco, String telefone, String email){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone= telefone;
        this.email = email;

    }
    // comando get pegar 
    public String getNome(){
        return nome;
    }
    public String getEndereco(){
        return endereco;
    }
    public String getTelefone(){
        return telefone;
    }
    public String getEmail(){
        return email;
    }
    //troca a informação
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public void setEmail(String email){
        this.email = email;
    }




}   