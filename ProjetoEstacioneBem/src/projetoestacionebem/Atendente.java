/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoestacionebem;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author milif
 */
public class Atendente extends Thread {

    public Estacionamento estacionamento;
    public BlockingQueue<Carro> esperando;

    public Atendente() {
    }

    public Atendente(Estacionamento estacionamento, BlockingQueue<Carro> esperando) {
        this.estacionamento = estacionamento;
        this.esperando = esperando;
    }

    @Override
    public void run() {
        try {
            System.out.println("Process " + this.getName()
                    + " To trabalhando pae!");
            int indexVaga = estacionamento.consultaDispVagas();
            Carro carroEsperando = esperando.take();
            if (indexVaga != -1 && carroEsperando != null) {
                System.out.println("Process " + this.getName()
                        + " Adicionando Carro");
                estacionamento.chegaCarro(carroEsperando);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        super.run();
    }
}
