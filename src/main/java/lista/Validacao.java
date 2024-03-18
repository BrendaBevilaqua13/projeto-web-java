package lista;

public class Validacao {

    public boolean validacaoDados(String nome,String cpf,String celular,String email){
        if (nome.isEmpty()){
            return false;
        }else if (cpf.isEmpty()){
            return false;
        }else if (celular.isEmpty()){
            return false;
        }else if (email.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    public String validacaoNome(String nome){
        String mensagem = "";
        if(!nome.matches("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ'\\s]+$")) {
            mensagem ="Nome não pode conter números";
        }

        return mensagem;
    }

    public String validacaoCPF(String cpf){
        String mensagem = "";
        if(!cpf.matches("^[0-9]*$")) {
            mensagem ="Preencha o campo cpf apenas com números";
        }
        if(cpf.length() <11 || cpf.length() >11){
            return mensagem = "CPF Inválido";
        }
        return mensagem;
    }
    public String validacaoCelular(String celular){
        String mensagem = "";
        if(!celular.matches("^[0-9]*$")) {
            mensagem ="Preencha o campo celular apenas com números";
        }
        if(celular.length() <9 || celular.length() >10){
            return mensagem = "Número de celular inválido";
        }

        return mensagem;
    }
}
