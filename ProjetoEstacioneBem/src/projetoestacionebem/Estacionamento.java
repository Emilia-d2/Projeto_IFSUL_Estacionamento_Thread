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
private int[] vagasDisponiv = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

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

    public int[] getVagasDisponiv() {
        return vagasDisponiv;
    }

    public void setVagasDisponiv(int[] vagasDisponiv) {
        this.vagasDisponiv = vagasDisponiv;
    }
    
    

}
