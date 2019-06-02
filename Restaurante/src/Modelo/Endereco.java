package Modelo;

public class Endereco {

    private String logradouro, num, complemento,bairro,cep,cidade,estado;
    private int id_endereco;

    public Endereco(int id_endereco, String logradouro, String num, String complemento, String bairro, String cep, String cidade, String estado){
        this.id_endereco = id_endereco;
        this.logradouro = logradouro;
        this.num = num;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getId_endereco() {
        return id_endereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }
}
