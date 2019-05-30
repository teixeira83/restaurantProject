package Modelo;


public class Imagem {

    final String caminhoPasta = "../Restaurante/src/Imagens/";

    public String montarCaminho(String s){
        return caminhoPasta + s ;
    }

}
