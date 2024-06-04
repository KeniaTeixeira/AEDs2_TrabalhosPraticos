import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Class personagens
class Personagens{
     String id;
     String name;
     String house;
     String ancestry;
     String species;
     String patronus;
     Boolean hogwartsStaff;
     Boolean hogwartsStudent;
     String actorName;
     String eyeColour;
     String gender;
     String hairColour;
     Boolean alive;
     Boolean wizard;
     int yearOfBirth;
     String alternateNames;
     String alternativeActors;
     LocalDate dateOfBirth; 
    
    Personagens (){}
    Personagens(String id, String name, String house, String ascestry,
    String species, String patronus, Boolean hogwartsStaff, 
    Boolean hogwartsStudent, String actorName, Boolean alive,
    int yearOfBirth, String eyeColour, String gender, String hairColour,
    Boolean wizard ){
        this.id = id;
        this.name = name;
        this.house = house;
        this.ancestry = ascestry;
        this.species = species;
        this.patronus = patronus;
        this.hogwartsStaff = hogwartsStaff;
        this.hogwartsStudent = hogwartsStudent;
        this.actorName = actorName;
        this.alive = alive;
        this.yearOfBirth = yearOfBirth;
        this.eyeColour = eyeColour;
        this.gender = gender;
        this.hairColour = hairColour;
        this.wizard =wizard;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHouse() {
        return house;
    }
    public void setHouse(String house) {
        this.house = house;
    }
    public String getAncestry() {
        return ancestry;
    }
    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public String getPatronus() {
        return patronus;
    }
    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }
    public Boolean getHogwartsStaff() {
        return hogwartsStaff;
    }
    public void setHogwartsStaff(Boolean hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }
    public Boolean getHogwartsStudent() {
        return hogwartsStudent;
    }
    public void setHogwartsStudent(Boolean hogwartsStudent) {
        this.hogwartsStudent = hogwartsStudent;
    }
    public String getActorName() {
        return actorName;
    }
    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
    public String getEyeColour() {
        return eyeColour;
    }
    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getHairColour() {
        return hairColour;
    }
    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }
    public Boolean getAlive() {
        return alive;
    }
    public void setAlive(Boolean alive) {
        this.alive = alive;
    }
    public boolean isWizard() {
        return wizard;
    }
    public void setWizard(boolean wizard) {
        this.wizard = wizard;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    public String getAlternateNames() {
        return alternateNames;
    }
    public void setAlternateNames(String alternateNames) {
        this.alternateNames = alternateNames;
    }
    public String getAlternativeActors() {
        return alternativeActors;
    }
    public void setAlternativeActors(String alternativeActors) {
        this.alternativeActors = alternativeActors;
    }
    
    public void imprimir(int x) {
        String datas = arruma(this.dateOfBirth);
        System.out.println("[" + x + " ## " + this.id + " ## " + this.name + " ## " + this.alternateNames + " ## " + this.house + " ## "
                + this.ancestry + " ## " + this.species + " ## " + this.patronus + " ## " + this.hogwartsStaff
                + " ## " + this.hogwartsStudent + " ## " + this.actorName
                + " ## " + this.alive + " ## " + datas + " ## " + this.yearOfBirth + " ## "
                + this.eyeColour + " ## " + this.gender + " ## " + this.hairColour + " ## " + this.wizard + "]");
    }

    private String arruma(LocalDate d) {
        if (d == null) {
            return "Data não disponível";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return d.format(formatter).replace("/", "-");
    }
}

//Celula para os personagens
class CelulaDupla{
    public Personagens elemento;
    public CelulaDupla prox;
    public CelulaDupla ant;

    public CelulaDupla(){
        this.elemento = new Personagens();
        this.prox = null;
        this.ant = null;
    }

    public CelulaDupla (Personagens elemento){
        this.elemento = elemento;
        this.prox = null;
        this.ant = null;
    }
}

class ListaDupla {
    public CelulaDupla primeiro, ultimo;

    public ListaDupla() {
        primeiro = null;
        ultimo = null;
    }

    public void inserirInicio(Personagens personagem) {
        CelulaDupla tmp = new CelulaDupla(personagem);
        if (primeiro == null) {
            primeiro = ultimo = tmp;
        } else {
            tmp.prox = primeiro;
            primeiro.ant = tmp;
            primeiro = tmp;
        }
    }

    public void inserirFim(Personagens personagem) {
        CelulaDupla tmp = new CelulaDupla(personagem);
        if (ultimo == null) {
            primeiro = ultimo = tmp;
        } else {
            tmp.ant = ultimo;
            ultimo.prox = tmp;
            ultimo = tmp;
        }
    }

    public void inserirPos(Personagens personagem, int pos) {
        int tamanho = tamanho();
        if (pos < 0 || pos > tamanho) {
            System.out.println("Erro");
            return;
        }else if (pos == 0) {
            inserirInicio(personagem);
        } else if (pos == tamanho) {
            inserirFim(personagem);
        } else {
            CelulaDupla tmp = new CelulaDupla(personagem);
            CelulaDupla i = primeiro;
            for(int j=0; j < pos; j++, i=i.prox);
            tmp.ant = i;
            tmp.prox = i.prox;
            tmp.ant.prox = tmp;
            tmp.prox.ant = tmp;
            tmp = i = null;
        }
    }

    public Personagens removerInicio() {
        if (primeiro == null || primeiro == ultimo) {
            return null;
        }
        CelulaDupla tmp = primeiro;
        Personagens removido = primeiro.elemento;
        primeiro = primeiro.prox;
        if (primeiro != null) {
            primeiro.ant = null;
        } else {
            ultimo = null;
        }
        tmp.prox = null; 
        return removido;
    }

    public Personagens removerFim() {
        if (ultimo == null || primeiro == ultimo) {
            return null;
        }
        Personagens removido = ultimo.elemento;
        ultimo = ultimo.ant;
        if (ultimo == null) {
            primeiro = null;
        } else {
            ultimo.prox = null;
        }
        return removido;
    }

    public Personagens removerPos(int pos) {
        int tamanho = tamanho();
        if (pos < 0 || pos >= tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        if (pos == 0) {
            return removerInicio();
        } else if (pos == tamanho - 1) {
            return removerFim();
        } else {
            CelulaDupla atual = primeiro;
            for (int i = 0; i < pos; i++) {
                atual = atual.prox;
            }
            Personagens removido = atual.elemento;
            atual.ant.prox = atual.prox;
            atual.prox.ant = atual.ant;
            atual.prox = atual.ant = null;
            return removido;
        }
    }

    public int tamanho() {
        int cont = 0;
        for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
            cont++;
        }
        return cont;
    }

    public void mostrar() {
        int j = 0;
        for (CelulaDupla i = primeiro; i != null; j++, i = i.prox) {
            i.elemento.imprimir(j);
        }
    }
}


public class listaFlexivel {
    //Procurar id no arquivos dos characters
    public static String procurarId(String id) throws IOException {
        String linha;
        String arquivo = "/tmp/characters.csv";
        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(";");
                if (valores[0].equalsIgnoreCase(id)) {
                    return linha; 
                }
            }
        }
        
        return null; 
    }

    //separa os personagens por nome, ator ....
    public static Personagens separando(String linha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-M-yyyy"); 
        String[] valoresEntrePV = linha.split(";");
        
        String arruma = valoresEntrePV[2].replace("[", "{").replace("]", "}").replace("'", ""); //so pra mudar a impressao
        valoresEntrePV[2] = arruma;
    
        Personagens personagem = new Personagens();
        //cria tudo dos personagens
        personagem.id = valoresEntrePV[0];
        personagem.name = valoresEntrePV[1];
        personagem.alternateNames = valoresEntrePV[2];
        personagem.house = valoresEntrePV[3];
        personagem.ancestry = valoresEntrePV[4];
        personagem.species = valoresEntrePV[5];
        personagem.patronus = valoresEntrePV[6];
        personagem.hogwartsStaff = valoresEntrePV[7].equalsIgnoreCase("VERDADEIRO");
        personagem.hogwartsStudent = valoresEntrePV[8].equalsIgnoreCase("VERDADEIRO");
        personagem.actorName = valoresEntrePV[9];
        personagem.alive = valoresEntrePV[10].equalsIgnoreCase("VERDADEIRO");
        personagem.alternativeActors = valoresEntrePV[11];
        personagem.dateOfBirth = valoresEntrePV[12].isEmpty() ? null : LocalDate.parse(valoresEntrePV[12], formatter);
        personagem.yearOfBirth = Integer.parseInt(valoresEntrePV[13]);
        personagem.eyeColour = valoresEntrePV[14];
        personagem.gender = valoresEntrePV[15];
        personagem.hairColour = valoresEntrePV[16];
        personagem.wizard = valoresEntrePV[17].equalsIgnoreCase("VERDADEIRO");
    
        return personagem; //retorna o personagens
    }
    
    //procura o personagem MODIFICA AQUI
    public static Personagens procurandoPersonagem(String id) throws IOException {
        String linhaEncontrada = procurarId(id);

        if (linhaEncontrada != null) {
            return separando(linhaEncontrada);  
        } else {
            System.out.println("Personagem não encontrado");
            return null;
        }
    }

    public static void inserirOuRemover(String linhaDaLista, ListaDupla listaDePersonagem) throws IOException{
        String linhaSeparado[] = linhaDaLista.split("\\s");
        Personagens personagem;

        if (linhaSeparado[0].compareTo("II") == 0){
            personagem = procurandoPersonagem(linhaSeparado[1]);
            listaDePersonagem.inserirInicio(personagem);
        }else if (linhaSeparado[0].compareTo("IF") == 0){
            personagem = procurandoPersonagem(linhaSeparado[1]);
            listaDePersonagem.inserirFim(personagem);
        }else if (linhaSeparado[0].compareTo("I*") == 0){
            int posinserir = Integer.parseInt(linhaSeparado[1]);
            personagem = procurandoPersonagem(linhaSeparado[2]);
            listaDePersonagem.inserirPos(personagem, posinserir);
        }else if(linhaSeparado[0].compareTo("R*") == 0){
             int pos = Integer.parseInt(linhaSeparado[1]);
             System.out.println("(R) " + listaDePersonagem.removerPos(pos).getName());
        }else if (linhaSeparado[0].compareTo("RI") == 0){
            System.out.println("(R) " + listaDePersonagem.removerInicio().getName());;
        }else if (linhaSeparado[0].compareTo("RF") == 0){
            System.out.println("(R) " + listaDePersonagem.removerFim().getName());
        }

    }

    public static void main(String[] args) {
            Personagens personagem = new Personagens();
            ListaDupla listaDePersonagem = new ListaDupla();

            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
                String id;
                //lê a linha pra mandar procurar e inserir na lista
                while (!(id = br.readLine()).equalsIgnoreCase("FIM")) {
                    personagem = procurandoPersonagem(id.trim());
                    listaDePersonagem.inserirFim(personagem);
                }

                String numeroDeIR;
                int x = 0;
                while ((numeroDeIR = br.readLine()) != null) {
                    x = Integer.parseInt(numeroDeIR.trim()); 
                    break;
                }
                
                for(int i = 0; i < x; i++){
                    String linhaParaIR = br.readLine();
                    inserirOuRemover(linhaParaIR, listaDePersonagem);
                }

                listaDePersonagem.mostrar();
                
            } catch (IOException e) {
                System.err.println("Erro ao ler a entrada: " + e.getMessage());
            }
        }
}