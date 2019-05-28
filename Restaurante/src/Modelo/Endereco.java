package Modelo;

public class Endereco {

    public String logradouro, num, complemento,bairro,cep,cidade,estado;
    public Endereco(String logradouro,String num,String complemento,String bairro,String cep,String cidade,String estado){

        this.logradouro = logradouro;
        this.num = num;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }
}
