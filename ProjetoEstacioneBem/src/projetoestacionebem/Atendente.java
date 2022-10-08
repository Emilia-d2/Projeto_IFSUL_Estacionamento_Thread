package projetoestacionebem;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author milif
 */
public class Atendente extends Thread {

    public Estacionamento estacionamento;
    public BlockingQueue<Carro> esperando;


    public Atendente(Estacionamento estacionamento, BlockingQueue<Carro> esperando) {
        this.estacionamento = estacionamento;
        this.esperando = esperando;
    }

    @Override
    public void run() {
        for (int i = 1; i < 13; i++) {
          try {
            System.out.println(" To trabalhando pae!");
            int indexVaga = estacionamento.consultaDispVagas();
            System.out.println(indexVaga);
            Carro carroEsperando = esperando.take();
            System.out.println("espera " + carroEsperando.getPlacaString());
            if (indexVaga == -1 && carroEsperando != null) {
                System.out.println(" Adicionando Carro" + getName());
                //estacionamento.chegaCarro(carroEsperando);
                Thread.sleep(800);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
       

    }
}
