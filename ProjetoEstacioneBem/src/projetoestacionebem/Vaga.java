package projetoestacionebem;
import java.time.LocalDateTime;

/**Classe de objeto Vaga para Estacionamento, onde serão contidos, valores e métodos para o mesmo.
 * @author milif
 */
public class Vaga {
    private int codigo;
    private LocalDateTime dt;
    private Carro carro;


    public Vaga(int codigo) {
        this.codigo = codigo;
    }
    
/** Método para retorno do codigo da Vaga
* @return int - codigo da Vaga
*/
    public int getCodigo() {
        return codigo;
    }
    
/** Método para retorno da data da Vaga
* @return int - data da vaga
*/
    public int getDt() {
        if (dt == null) {
            return -1;
        }
        return dt.getNano();
    }

    public void setDt(LocalDateTime dt) {
        this.dt = dt;
    }

/** Método para retorno do objeto do Carro 
* @return Carro carro
*/
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
