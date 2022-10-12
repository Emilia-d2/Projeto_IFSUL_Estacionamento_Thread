package projetoestacionebem;

/**
 *
 * @author milif
 */
public class Carro {
    private String placaString;

    public Carro() {
    }

    public Carro(String placaString) {
        this();
        this.placaString = placaString;
    }

    public String getPlacaString() {
        return placaString;
    }

    public void setPlacaString(String placaString) {
        this.placaString = placaString;
    }
}
