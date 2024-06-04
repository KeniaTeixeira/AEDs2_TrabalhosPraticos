// Trabalho prático - AEDs II 
// Kênia Teixeira de Paula Costa

public class TP01Q1 {
    static boolean verifica(String palavra){
        int tam = palavra.length();
        int i = 0; 
        int j = tam-1;

        while (i <= j && (Character.isDefined(palavra.charAt(j)))){ //verifica se o i é menor que o j para passar por todas as letras,  e se é um caractere válido
            if ((palavra.charAt(i)) != palavra.charAt(j)){ 
                return false; // se for diferente, não é um palindromo
            }
            i++;
            j--;
        }  
        return true; 
    }


     public static void main(String[] args) {
        String palavra;

        while (true){
            palavra = MyIO.readLine(); 
            if (palavra.equalsIgnoreCase("FIM")){
                break;
            }

            boolean resposta = TP01Q1.verifica(palavra);

            if (resposta){
                System.out.println("SIM");
            }else{
                System.out.println("NAO");
            }
        }

     }
}