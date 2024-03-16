package lista;

public class Cliente {
    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    private String Nome;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    private String CPF;

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    private String Celular;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    private String Email;

    private Cliente prox;

    public Cliente() {
        super();
    }
    public Cliente(String Nome,String CPF,String Celular,String Email) {
        super();
    }

    public Cliente getProx() {
        return prox;
    }

    public void setProx(Cliente prox) {
        this.prox = prox;
    }
}
