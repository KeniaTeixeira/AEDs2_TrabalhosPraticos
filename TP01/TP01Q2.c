// Trabalho prático - AEDs II 
// Kênia Teixeira de Paula Costa

#include <stdio.h>
#include <stdbool.h>
#include <ctype.h>
#include <string.h>

bool verifica(char palavra[]){
    int tam = strlen(palavra);
    int j;
    for (int i = 0, j = tam -1; i < j; i++, j--){
        while (i < j && (!isalnum(palavra[i]) && !isprint(palavra[i]))){
            i++;
        }
        while (i < j && (!isalnum(palavra[j]) && !isprint(palavra[j]))){
            j--;
        }
        
        if ((palavra[i]) != (palavra[j])){
            return false;
        } 
    }
    return true;
}

int main(){
    char palavra[500];

    while (fgets(palavra, sizeof(palavra), stdin) != NULL){
        palavra[strcspn(palavra, "\n")] = '\0';
        if (strcmp(palavra, "FIM") == 0){
            break;
        }
        
        bool teste = verifica(palavra);
            if (teste){
                puts("SIM");
            }else{
                puts("NAO");
            }
        }
    
    return 0;
}