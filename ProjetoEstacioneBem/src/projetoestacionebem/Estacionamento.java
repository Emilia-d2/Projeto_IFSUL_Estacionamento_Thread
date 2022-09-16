/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoestacionebem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milif
 */
public class Estacionamento {
      
private int quantVagas;
private boolean esgotado;
private List<Integer> vagasDisponiv = new ArrayList<Integer>();

    public int getQuantVagas() {
        return quantVagas;
    }

    public void setQuantVagas(int quantVagas) {
        this.quantVagas = quantVagas;
    }

    public boolean isEsgotado() {
        return esgotado;
    }

    public void setEsgotado(boolean esgotado) {
        this.esgotado = esgotado;
    }

    public List<Integer> getVagasDisponiv() {
        return vagasDisponiv;
    }

    public void setVagasDisponiv(List<Integer> vagasDisponiv) {
        this.vagasDisponiv = vagasDisponiv;
    }


}
