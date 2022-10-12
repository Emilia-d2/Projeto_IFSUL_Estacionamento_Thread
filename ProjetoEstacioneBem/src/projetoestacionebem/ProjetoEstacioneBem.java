package projetoestacionebem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**Método main que inicializa o projeto e as threads
 * @author milif
 */
public class ProjetoEstacioneBem {

    public static void main(String[] args) 
        throws InterruptedException, IOException{
            //Declara variaveis utilizadas no main
            int totalVagas = 12;
            String namePlaca;
            String opcaoSelecionada;
            String colocaGaragem;
            Boolean controleDeLaco = true;
            
            //Declara blockingQueue
            BlockingQueue<Carro> listaEsperaCarros = new ArrayBlockingQueue(totalVagas);   
            
            //Declara inputs
            BufferedReader opcaoUsu = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader placa = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader insere = new BufferedReader(new InputStreamReader(System.in));
            
            //laco de repeticao para programa
            while(controleDeLaco){
                //Inicializa
                System.out.println("Bem vindo ao Estacione Bem!");
                System.out.println("Deseja continuar S-Sim | N-Não: ");
                opcaoSelecionada = opcaoUsu.readLine();
                //Condicao para usuario
                if (opcaoSelecionada.equalsIgnoreCase("S")) {                                    
                    System.out.println("Digite sua placa: ");
                    namePlaca = placa.readLine();
                    Carro newCar = new Carro(namePlaca);
                    listaEsperaCarros.put(newCar);
                    
                    //Condicao se passar de 12 vagas, remove os carros que estao esperando
                    if(totalVagas > 12){
                    System.out.println("quero ver quando vem aqui");
                    listaEsperaCarros.remove();
                    }
                    
                    System.out.println("Deseja colocar na garagem? S-Sim | N-Não: ");
                    colocaGaragem = insere.readLine();
                    
                    //Condicao que inicializa as threads
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
