package projetoestacionebem;

/**
 *
 * @author milif
 */

import java.time.LocalDateTime;

public class Vaga {

    private int codigo;
    private LocalDateTime dt;
    private Carro carro;

    public Vaga(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getDt() {
        if (dt == null) {
            return -1;
        }
        return dt.getNano();
    }

    public void setDt(LocalDateTime dt) {
        this.dt = dt;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
        if (carro != null) {
            dt = LocalDateTime.now();
        } else {
            dt = null;
        }
    }

}
