package etapa2;

import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {

    public static void main(String[] args) {

        Random aleatorio = new Random();
        int tamanhoArray = aleatorio.nextInt(100) + 1;
        Candidato[] candidatos = new Candidato[tamanhoArray];
        String[] nomes = {"João", "Pedro", "Ian", "Rodrigo"};
        String[] partidos = {"Partido 1", "Partido 2", "Partido 3", "Partido 4"};

        for (int i = 0; i < candidatos.length; i++) {
            String nome = nomes[aleatorio.nextInt(nomes.length)];
            String partido = partidos[aleatorio.nextInt(partidos.length)];
            int intencoesVoto = aleatorio.nextInt(10000);

            candidatos[i] = new Candidato(nome, partido, intencoesVoto);
        }

        ordenaCandidatoPorVotos(candidatos);

        ordenaCandidatosPorNome(candidatos);

        ordenaCandidatosPorPartido(candidatos);

        pesquisaCandidatos(candidatos);

    }

    public static void ordenaCandidatosPorNome(Candidato[] candidatos) {
        int n = candidatos.length;
        for (int i = 1; i < n; i++) {
            Candidato copia = candidatos[i];
            int j = i - 1;
            while (j >= 0 && candidatos[j].getNome().compareTo(copia.getNome()) > 0) {
                candidatos[j + 1] = candidatos[j];
                j = j - 1;
            }
            candidatos[j + 1] = copia;
        }
    }

    public static void ordenaCandidatoPorVotos(Candidato[] candidatos) {
        int n = candidatos.length;
        for (int i = 1; i < n; i++) {
            Candidato copia = candidatos[i];
            int j = i - 1;
            while (j >= 0 && candidatos[j].getIntencoesVotos() < copia.getIntencoesVotos()) {
                candidatos[j + 1] = candidatos[j];
                j = j - 1;
            }
            candidatos[j + 1] = copia;
        }
    }

    public static void ordenaCandidatosPorPartido(Candidato[] candidatos) {
        int n = candidatos.length;
        for (int i = 1; i < n; i++) {
            Candidato copia = candidatos[i];
            int j = i - 1;
            while (j >= 0 && candidatos[j].getPartido().compareTo(copia.getPartido()) > 0) {
                candidatos[j + 1] = candidatos[j];
                j = j - 1;
            }
            candidatos[j + 1] = copia;
        }
    }

    public static void imprimeCandidatos(Candidato[] candidatos) {
        for (Candidato candidato : candidatos)
            System.out.println(candidato);
    }

    public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nome) {
        int inicio = 0;
        int fim = candidatos.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int resultado = candidatos[meio].getNome().compareTo(nome); // retorna valor

            if (resultado == 0)
                return meio;
            else if (resultado < 0) // metade inferior
                inicio = meio + 1;
            else // metade superior
                fim = meio - 1;
        }
        return -1;
    }

    public static void pesquisaCandidatos(Candidato[] candidatos) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do candidato a ser pesquisado: ");
        String nome = sc.nextLine();
        int posicao = pesquisaBinariaCandidatos(candidatos, nome);

        if (posicao != -1)
            System.out.println("\nCandidato encontado na posição: " + posicao + candidatos[posicao]);
        else
            System.out.println("Candidato não encontrado.");

        sc.close();
    }
}