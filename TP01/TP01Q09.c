#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void troca(int n){
    FILE *file = fopen("arquivo.txt", "r");
    if (file == NULL){
        printf("ERRO");
        return;
    }

    float *numeros = (float*)malloc(n*sizeof(float));
    for (int i = 0; i < n; i++) {
        if (fscanf(file, "%f\n", &numeros[i]) != 1) {
            free(numeros);
            fclose(file);
            return;
        }
    }
    
    float *trocado = (float*)malloc(n*sizeof(float));
    for (int i = n - 1; i >= 0; i--) {
            printf("%g\n", numeros[i]);
    }

    free(numeros); 
    fclose(file);
}

int main(){
    int quant;
    scanf("%d", &quant);
    FILE *file = fopen("arquivo.txt", "w");
    if (file == NULL){
        printf("ERRO");
        return 1;
    }

    int i =0;
    float x;
    while (i<quant){
        scanf("%f", &x);
        fprintf(file, "%f\n", x);

        i++;
    }
    
    fclose(file);
    troca(quant);

    return 0;
}