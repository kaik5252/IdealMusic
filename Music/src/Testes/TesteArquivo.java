package Testes;

public class TesteArquivo {

    private static final ConfigArquivo CONFIG = new ConfigArquivo();
    String texto = "";
    
    public static void main(String[] args) {
        String arq = "src/resouces/bancoTeste.sql";
        
        String texto = """
                       DROP DATABASE IF EXISTS baseteste;
                       CREATE DATABASE baseteste;
                       USE baseteste;
                       """;
        
        if(CONFIG.Write(arq, texto)) {
            System.out.println("Arquivo salvo com sucesso!");
        } else {
            System.out.println("Erro ao salvar o arquivo!");
        }
        
        //LEITURA
        texto = CONFIG.Read(arq);
        if(texto.isEmpty()) {
            System.out.println("Erro ao ler do arquivo!");
        } else {
            System.out.println(texto);
        }
        
        /*String ArqConfig = "conf.con";
        
        String conteudo = ConfigArquivo.Read(ArqConfig);
        String c1 = conteudo.split(";")[0];
        String c2 = conteudo.split(";")[1];
        String c3 = conteudo.split(";")[2];
        
        System.out.println("Nome: "+c1);
        System.out.println("Login: "+c2);
        System.out.println("Versão: "+c3);*/
    }
    
}
