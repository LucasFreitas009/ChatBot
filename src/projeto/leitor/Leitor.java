package src.projeto.leitor;

import java.io.*;
import java.util.HashMap;

public final class Leitor {
    //HashMap criado para armazenar os dados do banco de textos
    private static final HashMap<String, String> MAPA = new HashMap<>();

    //Método para leiturar e transferência dos dados do banco de textos para o HashMap
    public static void transferirDados(File arquivo) {
        
        //Tratamento de exceção para BufferedReader
        try{
            //BufferedReader utilizado para leitura do banco de textos
            BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "UTF-8"));
            
            //Váriaveis onde ficará armazenadas, respectivamente, linhas do banco de texto e o split dela.
            String linha;
            String[] dados;

            //Loop para fazer o split linha por linha e adicionar os dados no mapa
            while( (linha = leitor.readLine()) != null) {
                dados = linha.split(">");
                Leitor.MAPA.put(dados[0], dados[1]);
            }

            //Fecha o BufferedReader após seu uso.
            leitor.close();

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    //Retorna o mapa para consulta
    public static HashMap<String, String> getMapa() {
        return Leitor.MAPA;
    }
}
