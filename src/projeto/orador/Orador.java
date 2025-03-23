package src.projeto.orador;

import java.util.HashMap;

import src.projeto.leitor.Leitor;

public final class Orador {
    private static final HashMap<String,String> MAPA = Leitor.getMapa();

    public static void responder(String pergunta) {
        animation(Orador.MAPA.get(pergunta));
    }

    private static void animation(String texto) {
        try{
            for(int i = 0; i < texto.length(); i++) {
                Thread.sleep(30);
                System.out.print("\rBot: " + texto.substring(0, i + 1));
            }

            System.out.println("\n------------------");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}