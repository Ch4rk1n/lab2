import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class Labirinto {

    private char[][] labirinto;
    private int linhas;
    private int colunas;

    private static final char PAREDE = 'X';
    private static final char SAIDA = 'D';
    private static final char CAMINHO_PERCORRIDO = '*';

    public Labirinto(String filename) {
        criaLabirinto(filename);
    }

    public void criaLabirinto(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String linha;
            linhas = 0;
            colunas = 0;

            // Contar as linhas e colunas
            while ((linha = br.readLine()) != null) {
                linhas++;
                if (linha.length() > colunas)
                    colunas = linha.length();
            }
            br.close();

            labirinto = new char[linhas][colunas];

            br = new BufferedReader(new FileReader(filename));
            int lin = 0;

            // Preencher o array
            while ((linha = br.readLine()) != null) {
                for (int col = 0; col < colunas; col++) {
                    if (col < linha.length())
                        labirinto[lin][col] = linha.charAt(col);
                    else
                        labirinto[lin][col] = ' ';
                }
                lin++;
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
        }
    }

    public boolean percorreLabirinto() {
        return percorreLabirinto(0, 0);
    }

    private boolean percorreLabirinto(int linha, int coluna) {
        boolean posicaoInexistente = linha < 0 || coluna < 0 || linha >= labirinto.length || coluna >= labirinto[linha].length;
        if (posicaoInexistente)
            return false;

        char atual = labirinto[linha][coluna];

        switch(atual) {
            case PAREDE:
            case CAMINHO_PERCORRIDO:
                return false;
            case SAIDA:
                return true;
        }

        labirinto[linha][coluna] = CAMINHO_PERCORRIDO;

        boolean cima = percorreLabirinto(linha - 1, coluna);
        boolean baixo = percorreLabirinto(linha + 1, coluna);
        boolean esquerda = percorreLabirinto(linha, coluna - 1);
        boolean direita = percorreLabirinto(linha, coluna + 1);

        boolean encontrouSaida = cima || baixo || esquerda || direita;
        return encontrouSaida;
    }
}