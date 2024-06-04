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

public class TP02Q05 {
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

    public static Personagens separando(String linha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-M-yyyy"); 

        String[] valoresEntrePV = linha.split(";");
        String arruma = valoresEntrePV[2].replace("[", "{").replace("]", "}").replace("'", "");
        valoresEntrePV[2] = arruma;
    
        Personagens personagem = new Personagens();
    
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
        personagem.dateOfBirth = LocalDate.parse(valoresEntrePV[12], formatter);
        personagem.yearOfBirth = Integer.parseInt(valoresEntrePV[13]);
        personagem.eyeColour = valoresEntrePV[14];
        personagem.gender = valoresEntrePV[15];
        personagem.hairColour = valoresEntrePV[16];
        personagem.wizard = valoresEntrePV[17].equalsIgnoreCase("VERDADEIRO");
    
        return personagem;
    }
    
    static int totalPersonagens = 0;
    public static Personagens[] personagens = new Personagens[50];

    public static void procurandoPersonagem (String id) throws IOException {
        String linhaEncontrada = procurarId(id);

        if (linhaEncontrada != null){
            personagens[totalPersonagens++] = separando(linhaEncontrada);  
        }else{
            System.out.println("Personagem nao encontrado");
        }  
    }

    public static void ordenando(){
        Personagens tmp = new Personagens();
        int menor;

        for(int i=0; i < totalPersonagens-1; i++){
            menor = i;
            for(int j = i+1; j < totalPersonagens; j++){
                if (personagens[j].name.compareTo(personagens[menor].name) < 0) {
                    menor = j;
                }
            }    
            tmp = personagens[i];
            personagens[i] = personagens[menor];
            personagens[menor] = tmp;
        }
        
        for(int i=0; i < totalPersonagens; i++){
            personagens[i].imprimir();
        }
        
    }

    public static void main(String[] args) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
                String id;
                while (!(id = br.readLine()).equalsIgnoreCase("FIM")) {
                    procurandoPersonagem(id.trim());
                }

                ordenando();
                
            } catch (IOException e) {
                System.err.println("Erro ao ler a entrada: " + e.getMessage());
            }
        }
}
