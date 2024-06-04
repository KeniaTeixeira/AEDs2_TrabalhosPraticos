import java.io.IOException;
import java.io.RandomAccessFile;

public class TP01Q08{
    public static void main(String[] args) {
        LerAoContrario contrario = new LerAoContrario();
        int n;
        try{
        n = MyIO.readInt();

        RandomAccessFile file = new RandomAccessFile("pub.in", "rw");

        for(int i = 0; i < n; i++){
            file.writeDouble(MyIO.readDouble());
        }
        file.close();

        file = new RandomAccessFile("pub.in", "r");
            contrario.contrario(file);
        file.close();
        }catch(IOException e){
        e.printStackTrace();
    }
}
}

class LerAoContrario{
    void contrario(RandomAccessFile file) throws IOException{
        long tamanhoArq = file.length();
        long posicao = tamanhoArq - 8;
        double num;

        while (posicao >= 0) {
            file.seek(posicao);
            num = file.readDouble();

            if (num%1==0) {
                MyIO.println((int)num);
            }else{
                MyIO.println(num);
            }

            posicao -= 8;
        }
    }
}