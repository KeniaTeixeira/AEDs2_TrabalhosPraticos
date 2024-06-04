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

    public void imprimir() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Formatar a data
        String dataNascimentoFormatada = this.dateOfBirth.format(formatter);

        String hogwartsStaffStr = this.hogwartsStaff ? "true" : "false";
        String hogwartsStudentStr = this.hogwartsStudent ? "true" : "false";
        String aliveStr = this.alive ? "true" : "false";
        String wizardStr = this.wizard ? "true" : "false";

        System.out.println("[" + this.id + " ## " + this.name + " ## " + this.alternateNames + " ## " +
                this.house + " ## " + this.ancestry + " ## " + this.species + " ## " +
                this.patronus + " ## " + hogwartsStaffStr + " ## " + hogwartsStudentStr + " ## " +
                this.actorName + " ## " + aliveStr + " ## " + dataNascimentoFormatada + " ## " +
                this.yearOfBirth + " ## " + this.eyeColour + " ## " + this.gender + " ## " +
                this.hairColour + " ## " + wizardStr + "]");
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
        for (CelulaDupla i = primeiro; i != null; i = i.prox) {
            cont++;
        }
        return cont;
    }

    public void mostrar() {
        for (CelulaDupla i = primeiro; i != null; i = i.prox) {
            i.elemento.imprimir();
        }
    }


    // Método QuickSort para a lista dupla
    public void quickSort() {
        quickSort(0, tamanho() - 1);
    }

    private void quickSort(int esq, int dir) {
        int i = esq, j = dir;
        Personagens pivo = getPersonagem((esq + dir) / 2);

        while (i <= j) {
            while (comparaPersonagens(getPersonagem(i), pivo) < 0) {
                i++;
            }
            while (comparaPersonagens(getPersonagem(j), pivo) > 0) {
                j--;
            }
            if (i <= j) {
                trocar(i, j);
                i++;
                j--;
            }
        }
        if (esq < j) {
            quickSort(esq, j);
        }
        if (i < dir) {
            quickSort(i, dir);
        }
    }

    private void trocar(int i, int j) {
        if (i != j) {
            CelulaDupla celI = getCelula(i);
            CelulaDupla celJ = getCelula(j);
            Personagens temp = celI.elemento;
            celI.elemento = celJ.elemento;
            celJ.elemento = temp;
        }
    }

    private CelulaDupla getCelula(int pos) {
        CelulaDupla atual = primeiro;
        for (int i = 0; i < pos; i++) {
            atual = atual.prox;
        }
        return atual;
    }

    private Personagens getPersonagem(int pos) {
        return getCelula(pos).elemento;
    }

    private int comparaPersonagens(Personagens a, Personagens b) {
        int houseCompare = a.house.compareTo(b.house);
        if (houseCompare != 0) {
            return houseCompare;
        } else {
            return a.name.compareTo(b.name);
        }
    }
}


public class listaComQuick {
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

    public static void main(String[] args) {
            Personagens personagem = new Personagens();
            ListaDupla listaDePersonagem = new ListaDupla();
            int conta = 0;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
                String id;
                //lê a linha pra mandar procurar e inserir na lista
                while (!(id = br.readLine()).equalsIgnoreCase("FIM")) {
                    personagem = procurandoPersonagem(id.trim());
                    listaDePersonagem.inserirFim(personagem);
                    conta++;
                }

                listaDePersonagem.quickSort();
                listaDePersonagem.mostrar();
                
            } catch (IOException e) {
                System.err.println("Erro ao ler a entrada: " + e.getMessage());
            }
        }
}