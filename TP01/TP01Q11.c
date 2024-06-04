// Trabalho prático - AEDs II 
// Kênia Teixeira de Paula Costa

#include <stdio.h>
#include <stdbool.h>
#include <ctype.h>
#include <string.h>

bool verificaR(char palavra[], int i, int j){
    int tam = strlen(palavra);

    if (i>= j || tam == 0){
        return true;
    }
    
    while (i < tam && (!isalnum(palavra[i]) && !isprint(palavra[i]))){
            i++;
    }
    while (i < j && (!isalnum(palavra[j]) && !isprint(palavra[j]))){
            j--;
        }
    
    if ((palavra[i]) != (palavra[j])){
            return false;
        } 
        return verificaR(palavra, i+1, j-1);
}

bool verifica(char palavra[]){
        int tam = strlen(palavra);
        return verificaR(palavra,0,tam-1);
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