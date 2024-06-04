#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define alternative_length 50
#define name_length 100
#define MaximoDeToken 20
#define linha_length 1000
#define maximoDePersonagens 500
#define actor_length 50

typedef struct {
    char elementos[alternative_length][name_length];
    int tamanho;
} Lista;

typedef struct {
    char id[name_length];
    char name[name_length];
    Lista alternativeNames;
    char house[name_length];
    char ancestry[name_length];
    char species[name_length];
    char patronus[name_length];
    int hogwartsStaff; 
    int hogwartsStudent; 
    char actorName[name_length];
    Lista alternativeActors;
    int alive; 
    char dateOfBirth[11]; 
    char yearOfBirth[50];
    char eyeColour[50];
    char gender[50];
    char hairColour[50]; 
    int wizard; 
} Personagem;

void separar();
void libera();
void imprimir();
void ordenaBolha();

int main() {
    FILE *file = fopen("/tmp/characters.csv", "r");
    if (file == NULL) {
        printf("Não foi possível abrir o arquivo.\n");
        return 1;
    }

    char linha[linha_length];
    fgets(linha, sizeof(linha), file);

    Personagem personagens[maximoDePersonagens];
    int contPersonagens = 0;

    while (fgets(linha, sizeof(linha), file)) {

            if (linha[0] == '\n') 
            continue;

        separar(&personagens[contPersonagens], linha);
        contPersonagens++;
        if (contPersonagens >= maximoDePersonagens) {
            printf("MAXIMO DE PERSONAGENS\n");
            break;
        }
    }

    fclose(file);
    Personagem *personagens_encontrados[maximoDePersonagens];
    int contEncontrados = 0;

    char idBusca[name_length];
    while (1) {
        scanf("%s", idBusca);
        if (strcmp(idBusca, "FIM") == 0)
            break;

        int encontrado = 0;
        for (int i = 0; i < contPersonagens; i++) {
            if (strcmp(personagens[i].id, idBusca) == 0){
                personagens_encontrados[contEncontrados] = &personagens[i];
                contEncontrados++;
                //imprimir(&personagens[i]);
                encontrado = 1;
                break;
            }
        }
        if (!encontrado) {
            printf("Personagem não encontrado.\n");
            break;
        }
    }

   // verifica se pegou todos
    // for (int i = 0; i < contEncontrados; i++) {
    //     printf("%s\n", personagens_encontrados[i]->id);
    // }

    ordenaBolha(&personagens_encontrados, contEncontrados);
    
    for (int j = 0; j < contEncontrados; j++) {
        imprimir(personagens_encontrados[j]);
    }

    libera(personagens, contPersonagens);

    return 0;
}


void ordenaBolha(Personagem** personagens_encontrados, int contEncontrados){
    //Verifica se puxou todos
    // for (int i = 0; i < contEncontrados; i++) {
    //     printf("%s\n", personagens_encontrados[i]->id);
    // }
    int i, j;
Personagem* tmp;

for (i = 0; i < contEncontrados; i++) {
    for (j = 0; j < contEncontrados - i - 1; j++) {
        if (strcmp(personagens_encontrados[j]->hairColour, personagens_encontrados[j + 1]->hairColour) > 0 ||
            (strcmp(personagens_encontrados[j]->hairColour, personagens_encontrados[j + 1]->hairColour) == 0 &&
             strcmp(personagens_encontrados[j]->name, personagens_encontrados[j + 1]->name) > 0)) {
            tmp = personagens_encontrados[j];
            personagens_encontrados[j] = personagens_encontrados[j + 1];
            personagens_encontrados[j + 1] = tmp;
        }
    }
}


}

void iniciarLista(Lista *lista) {
    lista->tamanho = 0;
}

void adicionar(Lista *lista, const char *elemento) {
    if (lista->tamanho < alternative_length) {
        strncpy(lista->elementos[lista->tamanho], elemento, name_length - 1);
        lista->elementos[lista->tamanho][name_length - 1] = '\0'; 
        lista->tamanho++;
    }
}

void liberar(Lista *lista) {
    lista->tamanho = 0;
}

void libera(Personagem *personagens, int num){
    for (int i = 0; i < num; i++) {
    liberar(&(personagens[i].alternativeNames));
    liberar(&(personagens[i].alternativeActors));
    }
}
int delimitar(char *str, char delim, char *tokens[]) {
    int count = 0;
    char *token = str;

    while (*str != '\0') {
        if (*str == delim) {
            *str = '\0';
            tokens[count++] = token;
            token = str + 1;
        }
        str++;
    }
    tokens[count++] = token;
    return count;
}

void formatarData(char *data) {
    int dia, mes, ano;
    sscanf(data, "%d-%d-%d", &dia, &mes, &ano);
    sprintf(data, "%02d-%02d-%d", dia, mes, ano);
}

void separar(Personagem *personagem, char *line) {
    char *tokens[MaximoDeToken];
    int num_tokens = delimitar(line, ';', tokens);

    strcpy(personagem->id, tokens[0]);
    strcpy(personagem->name, tokens[1]);

    iniciarLista(&(personagem->alternativeNames));
    int i = 0;
    char *alternativeNames_token = strtok(tokens[2], ",");
    while (alternativeNames_token != NULL && i < alternative_length) {
        int length = strlen(alternativeNames_token);
        for (int j = 0; j < length; j++) {
            if (alternativeNames_token[j] == '[' || alternativeNames_token[j] == ']') {
                memmove(&alternativeNames_token[j], &alternativeNames_token[j + 1], length - j);
                length--;
                j--;
            } else if (alternativeNames_token[j] == '\'') {
                memmove(&alternativeNames_token[j], &alternativeNames_token[j + 1], length - j);
                length--;
                j--;
            }
        }
        adicionar(&(personagem->alternativeNames), alternativeNames_token);
        alternativeNames_token = strtok(NULL, ",");
        i++;
    }

    strcpy(personagem->house, tokens[3]);
    strcpy(personagem->ancestry, tokens[4]);
    strcpy(personagem->species, tokens[5]);
    strcpy(personagem->patronus, tokens[6]);
    personagem->hogwartsStaff = (strcmp(tokens[7], "VERDADEIRO") == 0);
    personagem->hogwartsStudent = (strcmp(tokens[8], "VERDADEIRO") == 0);
    strcpy(personagem->actorName, tokens[9]);
    personagem->alive = (strcmp(tokens[11], "VERDADEIRO") == 0);
    iniciarLista(&(personagem->alternativeActors));
    i = 0;
    char *alternativeActors_token = strtok(tokens[10], ",");
    while (alternativeActors_token != NULL && i < actor_length) {
        int length = strlen(alternativeActors_token);
        for (int j = 0; j < length; j++) {
            if (alternativeActors_token[j] == '[' || alternativeActors_token[j] == ']') {
                memmove(&alternativeActors_token[j], &alternativeActors_token[j + 1], length - j);
                length--;
                j--;
            } else if (alternativeActors_token[j] == '\'') {
                memmove(&alternativeActors_token[j], &alternativeActors_token[j + 1], length - j);
                length--;
                j--;
            }
        }
        adicionar(&(personagem->alternativeActors), alternativeActors_token);
        alternativeActors_token = strtok(NULL, ",");
        i++;
    }
    //personagem->alive = (strcmp(tokens[11], "VERDADEIRO") == 0);
    strcpy(personagem->dateOfBirth, tokens[12]);
    formatarData(personagem->dateOfBirth);
    strcpy(personagem->yearOfBirth, tokens[13]);
    strcpy(personagem->eyeColour, tokens[14]);
    strcpy(personagem->gender, tokens[15]);
    strcpy(personagem->hairColour, tokens[16]);
    personagem->wizard = (strcmp(tokens[17], "VERDADEIRO") == 0);
}

void imprimir(Personagem *personagem) {
    printf("[%s ## %s ## {", personagem->id, personagem->name);
    for (int i = 0; i < personagem->alternativeNames.tamanho-1; i++) {
        printf("%s,", personagem->alternativeNames.elementos[i]);
    }
    printf("%s} ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s]\n",
        personagem->alternativeNames.elementos[personagem->alternativeNames.tamanho-1],
        personagem->house,
        personagem->ancestry,
        personagem->species,
        personagem->patronus,
        personagem->hogwartsStaff ? "true" : "false",
        personagem->hogwartsStudent ? "true" : "false",
        personagem->actorName,
        personagem->alive ? "false" : "true",
        personagem->dateOfBirth,
        personagem->yearOfBirth,
        personagem->eyeColour,
        personagem->gender,
        personagem->hairColour,
        personagem->wizard ? "false" : "true");
}

//id;name;alternate_names;house;ancestry;species;patronus;hogwartsStaff;hogwartsStudent;actorName;alive;alternate_actors;dateOfBirth;yearOfBirth;eyeColour;gender;hairColour;wizard