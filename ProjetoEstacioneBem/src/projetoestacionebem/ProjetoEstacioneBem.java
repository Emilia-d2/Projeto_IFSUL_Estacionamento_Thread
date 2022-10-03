package projetoestacionebem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author milif
 */
public class ProjetoEstacioneBem {


    public static void main(String[] args) {

        try {
            BlockingQueue<Carro> listaEsperaCarros = new ArrayBlockingQueue(12);
            Estacionamento estacioneBem = new Estacionamento();

            Atendente atend = new Atendente(estacioneBem, listaEsperaCarros);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            // Reading data using readLine
            String name = reader.readLine();
            // System.out.println(name);
            Carro newCar = new Carro(name);
            listaEsperaCarros.put(newCar);
            atend.start();

            Thread.sleep(100);
            // BlockingQueue<Produto> caminhao
            // = new ArrayBlockingQueue(10);

            // Entregador entregador = new Entregador(caminhao);
            // entregador.start();

            // Thread.sleep(500);

            // Carregador carregador = new Carregador(caminhao);
            // carregador.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

