package lista;
import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    List<Cliente> lista;

    public Repositorio(){
        lista = new ArrayList<>();
    }


    public void adcionaLista(String nome,String cpf,String celular, String email) {
        Cliente novo = new Cliente();
        novo.setNome(nome);
        novo.setCPF(cpf);
        novo.setCelular(celular);
        novo.setEmail(email);
        lista.add(novo);
    }

    public List<Cliente> getClientes() {
        return lista;
    }

    public void excluir(String cpf){
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getCPF().equals(cpf)){
                lista.remove(i);
            }
        }
    }

    public Cliente buscarPorNome(String nome){
        Cliente cliente=null;
        for (Cliente c: lista){
            if (nome.equals(c.getNome())){
                cliente = c;
            }
        }
        return cliente;
    }
    public Cliente buscarPorCPF(String cpf){
        Cliente cliente=null;
        for (Cliente c: lista){
            if (cpf.equals(c.getCPF())){
                cliente = c;
            }
        }
        return cliente;
    }

    public void imprimiRepositorio(){
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Nome: "+lista.get(i).getNome());
            System.out.println("CPF: "+lista.get(i).getCPF()+"\n");
        }
    }

}


