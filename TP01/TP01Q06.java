public class TP01Q06 {
    public static void main(String[] args) {
        Vogal vogal = new Vogal();
        Consoante consoante = new Consoante();
        Inteiro inteiro = new Inteiro();
        Real real = new Real();
        Imprime ver = new Imprime();

        String string;

        while(true){
        string = MyIO.readLine();
            
        if(string.equals("FIM")){
            return;
        }

        boolean juntos[] = new boolean[4];
        juntos[0] = vogal.isVogais(string);
        juntos[1] = consoante.isConsoante(string);
        juntos[2] = inteiro.isInteiro(string);
        juntos[3] = real.isReal(string);

        ver.imprime(juntos);
        }
    }
}

class Vogal{
boolean isVogais(String palavra){
    int tam = palavra.length();
    String compara = "AEIOUaeiou";
    for (int i = 0; i < tam; i++){
        char caractere = palavra.charAt(i);
        if(compara.indexOf(caractere) == -1){
            return false;
        }
    }
    return true;
}}

class Consoante{
boolean isConsoante(String palavra){
    Vogal vogal = new Vogal();
    for(int i=0; i< palavra.length(); i++){
    char apoio = palavra.charAt(i);
    if(Character.isLetter(apoio) && !vogal.isVogais(palavra) && !Character.isLetterOrDigit(apoio)){
        continue;
    }else{
        return false;
        }
    }
        return true;
}}

class Inteiro{
boolean isInteiro(String palavra){
    for(char caractere : palavra.toCharArray()){
        if(!Character.isDigit(caractere)){
            return false;
        }
    }
    return true;
}}

class Real{
boolean isReal(String palavra){
    int tam = palavra.length();
    int ponto = 0;
    boolean v = true;

    for(int i=0; i < tam && v;i++){
        char c = palavra.charAt(i);
        if(c == ',' || c == '.'){
            ponto++;
        }else if(!(c>='0' && c <= '9')){
            v = false;
        }

        if(ponto>1){
            v = false;
        }
    }
    return v;
}}

class Imprime{
void imprime(boolean conjunto[]){
    int tam = conjunto.length;
    for(int i=0; i<tam; i++){
        if(conjunto[i]){
            MyIO.print("SIM ");
        }else{
            MyIO.print("NAO ");
        }
    }
    System.out.println();
}}