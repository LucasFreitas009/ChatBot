package src.projeto.main;

import src.projeto.escritor.Escritor;
import src.projeto.leitor.Leitor;
import src.projeto.orador.Orador;

import java.io.*;
import java.util.HashMap;

/*
 * Você pode aplicar melhorias ao bot como bem-entender!
 */

public class Main {
    public static void main(String[] args) {
        //Dados obrigatórios
        File db = new File("dataBase/db.txt");
        HashMap<String, String> dados = Leitor.getMapa();

        //Tratamento de exceção para criação do leitor de input
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
           
            System.out.println("Conversa iniciada! \n ------------------");

            while(true) {
                Leitor.transferirDados(db);

                System.out.print("-> ");

                String entrada = input.readLine();

                if(entrada.equalsIgnoreCase("sair")) {
                    System.out.println("\nConversa encerrada.");
                    break;

                } else if(!dados.containsKey(entrada)) {
                    System.out.print("Não entendi sua pergunta. Como eu devo respondê-la ? ");
                    String resposta = input.readLine();

                    Escritor.escrever(entrada, resposta, db);

                    System.out.println("Entendi!\n----------------");

                } else {
                    Orador.responder(entrada);
                }

            }

        }catch(IOException e){
            e.printStackTrace();
        }

        

    }
}
