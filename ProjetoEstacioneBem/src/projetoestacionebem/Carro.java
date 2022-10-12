package projetoestacionebem;

/**Classe de objeto Carro para Vaga, onde serão contidos, valores e métodos para o mesmo.
* @author milif
*/
public class Carro {
    private String placaString;
    
    /*Classe construtora de Carro*/
    public Carro() {
    }
    
    public Carro(String placaString) {
        this();
        this.placaString = placaString;
    }
    
/** Método para retorno da placa do Carro
* @return String - placa
*/
    public String getPlacaString() {
        return placaString;
    }

    public void setPlacaString(String placaString) {
        this.placaString = placaString;
    }
}
