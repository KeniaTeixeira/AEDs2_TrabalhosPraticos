import java.util.Random;

public class TP01Q04 {

    static String TrocandoLetras(String frase){
        String trocada = "";
        int tam = frase.length();

        //Gerando os caracteres aleatórios
        Random gerador1 = new Random();
        gerador1.setSeed(4);

        char primeiro = (char)('a' + gerador1.nextInt(26));
        char segundo = (char)('a' + gerador1.nextInt(26));
        //trocando os caracteres   
        for(int i=0; i<tam; i++){
            if (frase.charAt(i) == primeiro){
                trocada += segundo;
            }else{
                trocada+= frase.charAt(i);
            }
        }

        return trocada;
    }

    public static void main(String[] args) {
        String frase;


        while (true){
            frase = MyIO.readLine();
            if (frase.equalsIgnoreCase("FIM")){
                break;
            }
            String trocado = TP01Q04.TrocandoLetras(frase);
            MyIO.println(trocado);
        }
        
    }
}