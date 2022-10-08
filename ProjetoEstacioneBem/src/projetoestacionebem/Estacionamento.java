package projetoestacionebem;

/**
 *
 * @author milif
 */

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Estacionamento extends Thread{
    BlockingQueue<Carro> carroEstacioando;
    int taken = -1;
    private int tempoLimitePorVagaMilliSecondsSinceEpoch = 360000000;
    public List<Vaga> vagas = new ArrayList<Vaga>(12) {};

    public Estacionamento(BlockingQueue<Carro> carroEstacioando) {
        this.carroEstacioando = carroEstacioando;
    }

    
    public void run(){
        while(taken != 12){
            try {
                Carro car = this.carroEstacioando.take();
                System.out.println("Está na garagem " + car.getPlacaString());
                
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized int consultaDispVagas() {
        for (Vaga vaga : vagas) {
            Carro tmp = vaga.getCarro();
            if (tmp.getPlacaString() == null) {
                return vagas.indexOf(vaga);
            }
        }
        return -1;
    }

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

    public synchronized boolean desocupaVagaPorTempo(Carro novoCarro) {

        for (Vaga vaga : vagas) {
            int time = vaga.getDt();
            if (time > -1) {
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