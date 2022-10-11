package projetoestacionebem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author milif
 */
public class ProjetoEstacioneBem {

    public static void main(String[] args) throws InterruptedException, IOException {
        BlockingQueue<Carro> listaEsperaCarros = new ArrayBlockingQueue(12);
        
        System.out.println("Bem vindo ao Estacione Bem!");
        BufferedReader placa = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("Digite sua placa: ");
        String namePlaca = placa.readLine();

        Carro newCar = new Carro(namePlaca);
        listaEsperaCarros.put(newCar);
       
        System.out.println(" sua placa é " + newCar.getPlacaString());
        
        Estacionamento estacioneBem = new Estacionamento(listaEsperaCarros);
        estacioneBem.start();

        Atendente atend = new Atendente(estacioneBem, listaEsperaCarros);
        atend.start();

    }

}
