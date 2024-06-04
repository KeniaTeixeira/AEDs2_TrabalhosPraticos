// Trabalho prático - AEDs II 
// Kênia Teixeira de Paula Costa

public class TP01Q03 {
    static String cifrando(String palavra){
        int tam = palavra.length();
        String cifrada = ""; //cria string vazia para preencher com 3 depois
        for(int i=0; i < tam; i++){
            char x = palavra.charAt(i); //salva a lettra
            if (!Character.isLetterOrDigit(x) || Character.isLetterOrDigit(x)){ //verifica se e um digito,letra,sinais etc
                cifrada = cifrada + (char)(x+3); //string vazia recebe a digitada+3
            }else{ //se nao for nenhum imprimivel
                cifrada = cifrada + (char)(x); //recebe ele mesmo
            }

        }
        return cifrada;
    }

    public static void main(String[] args) {
        String palavra;

        while (true){
            palavra = MyIO.readLine();

            if (palavra.equals("FIM")) {
                return;
            }
            String cifrado = TP01Q03.cifrando(palavra);
            MyIO.println(cifrado);
        }
    }
}
