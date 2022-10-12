package projetoestacionebem;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author milif
 */
public class Estacionamento extends Thread {
    public Atendente estacionamento;
    public BlockingQueue<Carro> listaEsperaCarros;

    public Estacionamento(Atendente estacionamento, BlockingQueue<Carro> listaEsperaCarros) {
        this.estacionamento = estacionamento;
        this.listaEsperaCarros = listaEsperaCarros;
    }

    @Override
    public void run() {
        for (int indexVaga = 0; indexVaga < 12; indexVaga++) {
            try {
                System.out.println("To trabalhando!");
                int numVaga = estacionamento.consultaDispVagas();
                Carro carroEsperando = listaEsperaCarros.take();
                System.out.println("espera " + carroEsperando.getPlacaString());
                
                if (numVaga == -1) {
                    System.out.println("Adicionando Carro ");
                    estacionamento.chegaCarro(carroEsperando);
                    Thread.sleep(800);
                } 

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
