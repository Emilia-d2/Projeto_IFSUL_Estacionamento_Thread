package projetoestacionebem;

/**
 *
 * @author milif
 */
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private int tempoLimitePorVagaMilliSecondsSinceEpoch = 360000000;

    public List<Vaga> vagas = new ArrayList<Vaga>() {
        {
            new Vaga(100);
            new Vaga(101);
            new Vaga(102);
            new Vaga(103);
            new Vaga(104);
            new Vaga(105);
            new Vaga(106);
            new Vaga(107);
            new Vaga(108);
            new Vaga(109);
            new Vaga(110);
            new Vaga(111);
        }
    };

    public int consultaDispVagas() {
        for (Vaga vaga : vagas) {
            Carro tmp = vaga.getCarro();
            if (tmp.getPlacaString() == null) {
                return vagas.indexOf(vaga);
            }
        }
        return -1;
    }

    public boolean chegaCarro(Carro novoCarro) {
        int codigoVaga = consultaDispVagas();
        if (codigoVaga != -1) {
            Vaga tmp = vagas.get(codigoVaga);
            tmp.setCarro(novoCarro);
            vagas.set(codigoVaga, tmp);
            return true;
        }
        return false;
    }

    public boolean desocupaVagaPorTempo(Carro novoCarro) {

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