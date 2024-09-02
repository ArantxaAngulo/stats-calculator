#include <stdio.h>
#define MAX 255

void InvertCase(char *ptruserSentence){
    while( *ptruserSentence!= '\0'){
        *ptruserSentence = tolower( *ptruserSentence);
        ptruserSentence++;
    }

}     

int main(){
    int array[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int *ptr = &array[0];
  
    for(int i=0; i<10; i++){
        printf("The address in index #%d is: %p\n", i, &array[i]);
    }

    printf("\n");

    char userWord[MAX];
    int lenTracker = 0;

    printf("Write the word you wish to know the length of: ");
    scanf("%s", userWord);
    
    for(int i=0; userWord[i] != '\0'; i++){
        lenTracker ++;
    }
    printf("The length of %s is %d\n", userWord, lenTracker);

    //extra
    char userSentence[MAX];
    printf("Write any sentence or word containing uppercase and lowercase: ");
    scanf("%s", userSentence);
    
    InvertCase(userSentence);
    printf("The new string is %s \n", userSentence);

    //extra 2
    
    system("PAUSE");
    return 0;
}
