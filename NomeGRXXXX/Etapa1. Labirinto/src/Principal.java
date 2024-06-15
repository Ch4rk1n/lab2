public class Principal {

    public static void main(String[] args) {

        Labirinto labirinto = new Labirinto("labirinto.txt");

        boolean encontrouSaida = labirinto.percorreLabirinto();

        if (encontrouSaida)
            System.out.println("Saída encontrada!");
        else
            System.out.println("Saída não encontrada.");
    }
}