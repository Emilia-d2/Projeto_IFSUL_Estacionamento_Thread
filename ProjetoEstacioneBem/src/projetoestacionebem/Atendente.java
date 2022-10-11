package projetoestacionebem;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author milif
 */
public class Atendente extends Thread {

    public Estacionamento estacionamento;
    public BlockingQueue<Carro> carroEstacionado;

    public Atendente(Estacionamento estacionamento, BlockingQueue<Carro> carroEstacionado) {
        this.estacionamento = estacionamento;
        this.carroEstacionado = carroEstacionado;
    }

    @Override
    public void run() {
        for (int indexVaga = 0; indexVaga < 12; indexVaga++) {
            try {
                System.out.println("index Vaga " + indexVaga);
                System.out.println(" To trabalhando pae!");
                int numVaga = estacionamento.consultaDispVagas();
                System.out.println("numero vaga " + numVaga);
                Carro carroEsperando = carroEstacionado.take();
                System.out.println("espera " + carroEsperando.getPlacaString());
                if (numVaga != -1) {
                    System.out.println(" Adicionando Carro");
                    estacionamento.chegaCarro(carroEsperando);
                    //Thread.sleep(8000);
                }
                

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
