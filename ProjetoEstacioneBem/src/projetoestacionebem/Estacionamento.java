package projetoestacionebem;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

/**Classe de Estacionamento extends Thread, onde serão contidos, valores e métodos para o mesmo.
 * @author milif
 */
public class Estacionamento extends Thread {
    BlockingQueue<Carro> listaEsperaCarros;
    private final int tempoLimitePorVagaMilliSecondsSinceEpoch = 3600;
    public ArrayList<Vaga> vagas = new ArrayList(12);
    int pegaCarro = -1;

    public Estacionamento(BlockingQueue<Carro> listaEsperaCarros) {
        this.listaEsperaCarros = listaEsperaCarros;
    }

    
/**Método para inicializar thread que espera a quantidade de 12 carros, já que mais desse valor estacionamento nao aceita.
* Mostra se esta na garagem e controla tempo de cada carro por vaga. 
* @author milif
*/
    @Override
    public void run() {
        while(pegaCarro <= 12){
            try {
                if(vagas.size() == 12){
                    desocupaVagaPorTempo();
                    if(desocupaVagaPorTempo() == true){
                        this.listaEsperaCarros.remove();
                    }
                }
                Carro car = this.listaEsperaCarros.take();
                System.out.println("Está na garagem " + car.getPlacaString());
                System.out.println("Seu salário de trabalho até aqui está de R$: ");
                
                
                
            } catch (InterruptedException e) {
            e.printStackTrace();
            }           
        }      
    }
    
/** Método para consultar se há vagas disponiveis. 
* @return int - se nao esta disponivel
*/
    public synchronized int consultaDispVagas() {
        for (Vaga vaga : vagas) {
            Carro car = vaga.getCarro();
            if (car == null) {
                return vagas.indexOf(vaga);
                
            }
        }
        return -1;
    }
    
/** Método para consultar se há chega um carro novo. 
* @return boolean - valor false
*/
    public synchronized boolean chegaCarro(Carro novoCarro) {
        int codigoVaga = consultaDispVagas();
        if (codigoVaga != -1) {
            Vaga tmp = vagas.get(codigoVaga);
            tmp.setCarro(novoCarro);
            vagas.set(codigoVaga, tmp);
            return true;
        }
        return false;
    }
    
/** Método para desocupar vaga por tempo 
* @return boolean - valor false
*/
    public synchronized boolean desocupaVagaPorTempo() {
        for (Vaga vaga : vagas) {
            int time = vaga.getDt();
            if (time > 0) {
                if (LocalDateTime.now().getNano() + tempoLimitePorVagaMilliSecondsSinceEpoch > time) {
                    Vaga tmp = vaga;
                    tmp.setCarro(null);
                    vagas.set(vagas.indexOf(vaga), tmp);
                }

            }
        }
        return false;
    }
}