/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoestacionebem;

/**
 *
 * @author milif
 */
public class Atendente {
    
private String nome = "Afonso";
private float salarioAtend = (float) 0.50;
private int tempoTrabalhando;
private boolean atendendo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalarioAtend() {
        return salarioAtend;
    }

    public void setSalarioAtend(float salarioAtend) {
        this.salarioAtend = salarioAtend;
    }


    public int getTempoTrabalhando() {
        return tempoTrabalhando;
    }

    public void setTempoTrabalhando(int tempoTrabalhando) {
        this.tempoTrabalhando = verificaAtendendo();
    }

    public boolean isAtendendo() {
        return atendendo;
    }

    public void setAtendendo(boolean atendendo) {
        this.atendendo = atendendo;
    }
     
    public int calculaTempoTrabalho(){
        int minutos = getTempoTrabalhando();
        return minutos;
    }

    public float pagaSalario(){
        int minutos = calculaTempoTrabalho();
        float valor = getSalarioAtend();
        float salario = minutos * valor;
        return salario;
    }
    
    public int verificaAtendendo(){
        boolean atendendo = isAtendendo();
        int tempo = 0; 
        if(atendendo == true){
            for (int i = tempo; i < 5; i++) {
                tempo = i;
                tempo++;
            }
        }
        else{
            tempo++;
        }
        //lembrar de colocar o sleep da threand
        return tempo;
    }

    boolean setTempoTrabalhando() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}


