package Modelo;

public class Endereco {

    public String logradouro, num, complemento,bairro,cep,cidade,estado;
    public int id_endereco;
    public Endereco(int id_endereco, String logradouro,String num,String complemento,String bairro,String cep,String cidade,String estado){
        this.id_endereco = id_endereco;
        this.logradouro = logradouro;
        this.num = num;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }
}
