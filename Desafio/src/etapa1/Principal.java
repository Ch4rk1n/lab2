package etapa1;

public class Principal {
    public static void main(String[] args) {

        Labirinto labirinto = new Labirinto("src/labirinto.txt");

        boolean encontrouSaida = labirinto.percorreLabirinto();

        if (encontrouSaida)
            System.out.println("Encontrou saída");
        else
            System.out.println("Não encontrou saída");
    }
}