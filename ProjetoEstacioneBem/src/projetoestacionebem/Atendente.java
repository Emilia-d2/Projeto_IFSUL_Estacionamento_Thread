package projetoestacionebem;
import java.util.concurrent.BlockingQueue;

/**Classe de Atendente extends Thread, onde serão contidos, valores e métodos para o mesmo.
 * @author milif
 */
public class Atendente extends Thread {
    public Estacionamento estaciona;
    public BlockingQueue<Carro> listaEsperaCarros;

    public Atendente(Estacionamento estaciona, BlockingQueue<Carro> listaEsperaCarros) {
        this.estaciona = estaciona;
        this.listaEsperaCarros = listaEsperaCarros;
    }

/**Método para inicializar thread, percorrendo index da lista por index e efetuando o controle do atendente.
 * Pegando o carro e adiocionando na garagem
 * @author milif
 */
    @Override
    public void run() {
        for (int indexVaga = 0; indexVaga < 12; indexVaga++) {
            try {
                System.out.println("To trabalhando!");
                int numVaga = estaciona.consultaDispVagas();  
                Carro carroEsperando = listaEsperaCarros.take();
                System.out.println("Carro ficou esperando e saiu! " + carroEsperando.getPlacaString());
                Thread.sleep(800);
                if (numVaga == -1) {
                    System.out.println("Colocando carros na garagem! ");                    
                    estaciona.chegaCarro(carroEsperando);
                }else{
                    System.out.println("Oops");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }
        Thread.interrupted();
    }
}
