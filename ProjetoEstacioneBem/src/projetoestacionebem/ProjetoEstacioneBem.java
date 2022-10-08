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
        
        Estacionamento estacioneBem = new Estacionamento(listaEsperaCarros);
        
        Atendente atend = new Atendente(estacioneBem, listaEsperaCarros);
    
            BufferedReader placa = new BufferedReader(
                    new InputStreamReader(System.in));
            
            BufferedReader escolha = new BufferedReader(
                    new InputStreamReader(System.in));
            
           System.out.println("Bem vindo ao Estacione Bem!");
                System.out.println("Deseja continuar e colocar seu carro em nossa garagem 1(sim) e 0(não) ");
                int escolhaUsuario = escolha.hashCode();
            
            while(escolhaUsuario != 0){ 
            
                System.out.println("Digite sua placa: ");
                String namePlaca = placa.readLine();

                Carro newCar = new Carro(namePlaca);
                listaEsperaCarros.put(newCar);
                System.out.println(" sua placa é " + newCar.getPlacaString());
                atend.start();
                estacioneBem.start();

            }
            
            
          
        

    }

}

