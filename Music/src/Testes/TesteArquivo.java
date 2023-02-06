package Testes;

public class TesteArquivo {

    private static final backupDatabase CONFIG = new backupDatabase();

    public void writeTest(String caminho, String textoSql) {
        CONFIG.Write(caminho, textoSql);
    }
}