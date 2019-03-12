#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* RemoveCaracter(char* string, char c) {
	char* novaString = string;
	int j = 0;
	for (int i=0; string[i] != '\0'; i++) {
		if (string[i] != c) {
			novaString[j] = string[i];
			j++;
		}
	}
	novaString[j] = '\0';
	return novaString;
}

int main() {
	char string[100];

	printf("Digite qualquer coisa: ");
	scanf("%[^\n]s", string);
	if (strlen(string) <= 100) {
		char* novaString = RemoveCaracter(string, ' ');
		printf("A string sem espacos é: %s\n", novaString);
	} else {
		printf("Tamanho máximo aceito é 100.\n");
		exit(8);
	}
}