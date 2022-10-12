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

    public static void main(String[] args) 
        throws InterruptedException, IOException{
            int totalVagas = 12;
            BlockingQueue<Carro> listaEsperaCarros = new ArrayBlockingQueue(totalVagas);
            Boolean controleDeLaco = true;
            BufferedReader opcaoUsu = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader placa = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader insere = new BufferedReader(new InputStreamReader(System.in));
            String namePlaca;
            String opcaoSelecionada;
            String colocaGaragem;
            
            while(controleDeLaco){
                System.out.println("Bem vindo ao Estacione Bem!");

                System.out.println("Deseja continuar S-Sim | N-Não: ");
                opcaoSelecionada = opcaoUsu.readLine();
                if (opcaoSelecionada.equalsIgnoreCase("S")) {
                    System.out.println("Digite sua placa: ");
                    namePlaca = placa.readLine();

                    Carro newCar = new Carro(namePlaca);
                    listaEsperaCarros.put(newCar);
                    
                    if(totalVagas > 12){
                    System.out.println("quero ver quando vem aqui");
                    listaEsperaCarros.remove();
                    }
                    
                    System.out.println("Deseja colocar na garagem? S-Sim | N-Não: ");
                    colocaGaragem = insere.readLine();

                    if(colocaGaragem.equalsIgnoreCase("s")){

                    Estacionamento estacione = new Estacionamento(listaEsperaCarros);
                    estacione.start();

                    Atendente atend = new Atendente(estacione, listaEsperaCarros);
                    atend.start();   
                }

                } else {
                    break;
                }   
        }   
    }
}
