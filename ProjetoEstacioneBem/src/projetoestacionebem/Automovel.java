/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoestacionebem;

/**
 *
 * @author milif
 */
public class Automovel {   
private String placa;
private String modelo;
private String cor;
private int tempoVaga;
private boolean aguardandoFila;
private int numeroVaga;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getTempoVaga() {
        return tempoVaga;
    }

    public void setTempoVaga(int tempoVaga) {
        this.tempoVaga = tempoVaga;
    }

    public boolean isAguardandoFila() {
        return aguardandoFila;
    }

    public void setAguardandoFila(boolean aguardandoFila) {
        this.aguardandoFila = aguardandoFila;
    }

    public int getNumeroVaga() {
        return numeroVaga;
    }

    public void setNumeroVaga(int numeroVaga) {
        this.numeroVaga = numeroVaga;
    }


}
