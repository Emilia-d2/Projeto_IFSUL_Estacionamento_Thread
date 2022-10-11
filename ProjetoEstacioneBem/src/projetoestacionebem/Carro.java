package projetoestacionebem;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author milif
 */
public class Carro {

    private String placaString;

    public Carro() {
    }

    public Carro(String placaString) {
        this.placaString = placaString;
    }

    public String getPlacaString() {
        return placaString;
    }

    void put(BlockingQueue<Carro> listaEsperaCarros) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
