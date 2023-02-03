package Testes;

public class Rodar {
    private static final TesteArquivo TESTE = new TesteArquivo();
    
    public static void main(String[] args) {
        TESTE.writeTest("src/resources/bancoTeste.sql", "Testando");
    }
}
