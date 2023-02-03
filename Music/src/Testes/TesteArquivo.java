package Testes;

public class TesteArquivo {

    private static final ConfigArquivo CONFIG = new ConfigArquivo();

    public void writeTest(String caminho, String textoSql) {
        CONFIG.Write(caminho, textoSql);
    }
}