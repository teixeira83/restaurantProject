package Modelo;

public class Telefone {

    public String ddd, num, operadora;
    public int id_telefone;
    public Telefone(int id_telefone, String ddd, String num, String operadora){
        this.id_telefone = id_telefone;
        this.ddd = ddd;
        this.num = num;
        this.operadora = operadora;
    }
}
