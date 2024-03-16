package hash;

import lista.Cliente;
import lista.Repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dicionario {

    private static Repositorio Vetor[];

    public Dicionario() {
        Vetor = new Repositorio[10];
        inicializaListas();
    }

    public void inicializaListas() {
        for (int i = 0; i < 10; i++) {
            Vetor[i] = new Repositorio();
        }

    }

    public List<Cliente> getDict() {
        List<Cliente> clientes = new ArrayList<>();
        for (int i = 0; i < Vetor.length; i++) {
            if (!Vetor[i].getClientes().isEmpty()) {
                for (int j = 0; j < Vetor[i].getClientes().size(); j++) {
                    clientes.add(Vetor[i].getClientes().get(j));
                }
            }
        }
        return clientes;
    }

    final int funcaoHash(String cpf) {
        //calcula o valor hash do cpf

        int posicao = cpf.charAt(0);

        return posicao - 48;
    }

    public void addTabela(String cpf, String nome, String celular, String email) {
        for (int i = 0; i < Vetor.length; i++) {
            if (i == funcaoHash(cpf)) {
                Vetor[i].adcionaLista(nome, cpf, celular, email);
            }
        }

    }

    public void imprimiVetor() {
        for (int i = 0; i < Vetor.length; i++) {
            System.out.println("\n");
            System.out.println("Inicio Posição - " + i);
            if (Vetor[i].getClientes().isEmpty()) {
                System.out.println("Lista Vazia");
            } else {
                System.out.println("Posição: " + i);
                Vetor[i].imprimiRepositorio();
            }
        }
    }

    public void excluirCliente(String cpf) {
        Vetor[funcaoHash(cpf)].excluir(cpf);
    }

    public Cliente buscaCliente(String cpf) {
        return Vetor[funcaoHash(cpf)].buscarPorCPF(cpf);
    }

    public Cliente buscarPeloNome(String nome){
        Cliente c= new Cliente();
        for(int i=0; i<Vetor.length;i++){
            if (Vetor[i].buscarPorNome(nome) != null){
                c = Vetor[i].buscarPorNome(nome);
            }
        }
        return c;
    }
}
