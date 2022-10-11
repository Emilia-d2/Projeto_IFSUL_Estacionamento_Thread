package projetoestacionebem;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author milif
 */
public class Atendente extends Thread {

    public Estacionamento estacionamento;
    public BlockingQueue<Carro> listaEsperaCarros;

    public Atendente(Estacionamento estacionamento, BlockingQueue<Carro> listaEsperaCarros) {
        this.estacionamento = estacionamento;
        this.listaEsperaCarros = listaEsperaCarros;
    }

    @Override
    public void run() {
        for (int indexVaga = 0; indexVaga < 12; indexVaga++) {
            try {
                System.out.println("index Vaga " + indexVaga);
                System.out.println(" To trabalhando pae!");
                int numVaga = estacionamento.consultaDispVagas();
                System.out.println("numero vaga " + numVaga);
                Carro carroEsperando = listaEsperaCarros.take();
                
                if (numVaga != -1) {
                    System.out.println(" Adicionando Carro");
                    estacionamento.chegaCarro(carroEsperando);
                    //Thread.sleep(8000);
                }
                System.out.println("espera " + carroEsperando.getPlacaString());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
