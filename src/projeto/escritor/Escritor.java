package src.projeto.escritor;

import java.io.*;
import java.util.HashMap;

import src.projeto.leitor.Leitor;

public final class Escritor {
    //Atributo criado para consultar a tabela hash da classe Leitor
    private static final HashMap<String, String> MAPA = Leitor.getMapa();

    //Método para fazer a escrita de perguntas e respostas no banco de textos
    public static void escrever(String entrada, String resposta, File arquivo) {
        //Tratamento de exceção utilizando try-with-resources para fechamento automático do BufferedWriter
        try(BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arquivo, true), "UTF-8"));){
            String pergunta = entrada;

            //Verificação para não repetir perguntas e respostas no banco de textos
            if(!MAPA.containsKey(pergunta)) {
                escritor.write(pergunta + ">" + resposta);
                escritor.newLine();

            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
