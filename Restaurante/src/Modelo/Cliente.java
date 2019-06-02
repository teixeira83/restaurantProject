package Modelo;

import java.awt.*;

public class Cliente {

    private String nome,cpf;
    private int idTelefone, idEndereco, idCliente;

    public Cliente(int idCliente, String nome, String cpf, int idTelefone, int idEndereco) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.idTelefone = idTelefone;
        this.idEndereco = idEndereco;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }


}
