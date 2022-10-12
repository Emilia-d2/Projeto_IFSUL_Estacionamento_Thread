package projetoestacionebem;
import java.util.concurrent.BlockingQueue;
/**
 *
 * @author milif
 */
public class Atendente extends Thread {
    public Estacionamento estaciona;
    public BlockingQueue<Carro> listaEsperaCarros;

    public Atendente(Estacionamento estaciona, BlockingQueue<Carro> listaEsperaCarros) {
        this.estaciona = estaciona;
        this.listaEsperaCarros = listaEsperaCarros;
    }

    @Override
    public void run() {
        for (int indexVaga = 0; indexVaga < 12; indexVaga++) {
            try {
                System.out.println("To trabalhando!");
                int numVaga = estaciona.consultaDispVagas();               
                if (numVaga == -1) {
                    System.out.println("Adicionando Carro ");
                    Carro carroEsperando = listaEsperaCarros.take();
                    System.out.println("espera " + carroEsperando.getPlacaString());
                    estaciona.chegaCarro(carroEsperando);
                    Thread.sleep(800);
                }else{
                    System.out.println("Oops");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
