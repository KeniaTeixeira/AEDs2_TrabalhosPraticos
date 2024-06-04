#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>

char* trocando(char*string, char PL, char SL){
    int tam = strlen(string);

    for (int i = 0; i < tam; i++){
        char aux = string[i];
        if (aux == PL){
            string[i] = SL;
        }else{
            string[i] = aux;
        }
    }

    return string;
}

int main(){
    char string[500];
    char primeiraLetra;
    char segundaLetra;
    
    srand(4);
    primeiraLetra = (char)('a' + (rand())%26 );
    segundaLetra = (char)('a' + (rand())%26);

    while (1){
    scanf(" %[^\n]", string);
    if (strcmp(string, "FIM") == 0){
        break;
    }
    
    trocando(string, primeiraLetra, segundaLetra);
    printf("%s\n", string);
    }
    
    return 0;
}