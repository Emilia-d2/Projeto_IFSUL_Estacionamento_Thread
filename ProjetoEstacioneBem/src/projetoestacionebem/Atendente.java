package projetoestacionebem;
import java.util.concurrent.BlockingQueue;

/**Classe de Atendente extends Thread, onde serão contidos, valores e métodos para o mesmo.
 * @author milif
 */
public class Atendente extends Thread {
    public Estacionamento estaciona;
    public BlockingQueue<Carro> listaCarros;

    public Atendente(Estacionamento estaciona, BlockingQueue<Carro> listaCarros) {
        this.estaciona = estaciona;
        this.listaCarros = listaCarros;
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
                Carro chegouCarro = listaCarros.take();
                if (numVaga == -1) {                  
                    estaciona.chegaCarro(chegouCarro);  
                }else{
                    System.out.println("Oops");
                }
                System.out.println("Carro ficou esperando e saiu! " + chegouCarro.getPlacaString());
                Thread.sleep(8000);
            } catch (InterruptedException e) {
            }
            break;
        }
    }
}
