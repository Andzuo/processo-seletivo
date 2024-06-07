package candidatos;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {
                "Candidato 1",
                "Candidato 2",
                "Candidato 3",
                "Candidato 4",
                "Candidato 5",
                "Candidato 6",
        };
        for(String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }
    static void entrandoEmContato(String candidato) {
        int tentativas = 1;
        boolean continuar = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuar = !atendeu;
            if(continuar) {
                tentativas++;
            } else {
                System.out.println("Contato realizado");
            }
        } while (continuar && tentativas < 3);

        if(atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " Na " + tentativas + " Tentativa");
        } else {
            System.out.println("Contato nao realizado");
        }
    }

    static boolean atender() {
        return new Random().nextInt(3)==1;
    }
    static void imprimirSelecionados() {
        String [] candidatos = {
                "Candidato 1",
                "Candidato 2",
                "Candidato 3",
                "Candidato 4",
                "Candidato 5",
                "Candidato 6",
        };
        System.out.println("Imprimindo a lista de candidatos informando indice do elemento");
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("o candidato de nº" + (i+1) + " é: " + candidatos[i]);
        }
        System.out.println("Forma abreviada");

        for (String candidato : candidatos) {
            System.out.println("O candadidato selecionado foi " + candidato);
        }
    }
    static void selecaoCandidatos() {
        String [] candidatos = {
                "Candidato 1",
                "Candidato 2",
                "Candidato 3",
                "Candidato 4",
                "Candidato 5",
                "Candidato 6",
        };
        int candidatoSelecionado = 0;
        int candidatoIndice = 0;
        double salarioBase = 2000.0;
        while (candidatoSelecionado < 5 && candidatoIndice < candidatos.length) {
            String candidato = candidatos[candidatoIndice];
            double salarioPretendido = valorPretendido();

            System.out.println("Candidato: " + candidato + " Solicitou:" + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("Candidato: " + candidato + " foi selecionado para a vaga");
                candidatoIndice++;
            }
            candidatoIndice++;
        }
    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void candidatoAnalise(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioPretendido > salarioBase) {
            System.out.println("Ligar para o candidato");
        } else if (salarioPretendido == salarioBase) {
            System.out.println("Ligar para o candidato com contra proposta");
        } else {
            System.out.println("Aguardando os demais resultados");
        }
    }
}
