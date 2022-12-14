package projetoestacionebem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Método main que inicializa o projeto e as threads
 *
 * @author milif
 */
public class ProjetoEstacioneBem {

    public static void main(String[] args)
            throws InterruptedException, IOException {
        //Declara variaveis utilizadas no main
        String namePlaca;
        String opcaoSelecionada;
        boolean controleDeLaco = true;

        //Declara blockingQueue
        BlockingQueue<Carro> listaCarros = new ArrayBlockingQueue(12);

        //Declara inputs
        BufferedReader opcaoUsu = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader placa = new BufferedReader(new InputStreamReader(System.in));

        Estacionamento estacione = new Estacionamento(listaCarros);
        estacione.start();

        Atendente atend = new Atendente(estacione, listaCarros);
        atend.start();

        //laco de repeticao para programa
        while (controleDeLaco) {
            //Inicializa
            System.out.println("Bem vindo ao Estacione Bem!");
            System.out.println("Deseja continuar S-Sim | N-Não: ");
            opcaoSelecionada = opcaoUsu.readLine();
            //Condicao para usuario
            if (opcaoSelecionada.equalsIgnoreCase("S")) {
                System.out.println("Digite sua placa: ");
                namePlaca = placa.readLine();
                Carro newCar = new Carro(namePlaca);
                listaCarros.put(newCar);

                //Condicao se passar de 12 vagas, remove os carros que estao esperando
                if (listaCarros.size() > 12) {
                    listaCarros.remove();
                }
                
            } else {
                break;
            }
        }
    }
}
