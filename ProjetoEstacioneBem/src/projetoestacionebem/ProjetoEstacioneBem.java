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
        Boolean controleDeLaco = true;
        BufferedReader opcaoUsu = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader placa = new BufferedReader(new InputStreamReader(System.in));
        String namePlaca;
        String opcaoSelecionada;
        while(controleDeLaco){
            System.out.println("Bem vindo ao Estacione Bem!");

            System.out.println("Deseja continuar S-Sim | N-Não: ");
            opcaoSelecionada = opcaoUsu.readLine();
            if (opcaoSelecionada.equalsIgnoreCase("S")) {
                System.out.println("Digite sua placa: ");
                namePlaca = placa.readLine();
            
                Carro newCar = new Carro(namePlaca);
                listaEsperaCarros.add(newCar);
            } else {
                Atendente atend = new Atendente(listaEsperaCarros);
                atend.start();

                Estacionamento estacione = new Estacionamento(atend, listaEsperaCarros);
                estacione.start();                          
                
                break;
            }   
        }   
    }
}
