package Modelo;

public class Telefone {

    private String ddd, num, operadora;
    private int id_telefone;

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public int getId_telefone() {
        return id_telefone;
    }

    public void setId_telefone(int id_telefone) {
        this.id_telefone = id_telefone;
    }

    public Telefone(int id_telefone, String ddd, String num, String operadora){
        this.id_telefone = id_telefone;
        this.ddd = ddd;
        this.num = num;
        this.operadora = operadora;
    }
}
