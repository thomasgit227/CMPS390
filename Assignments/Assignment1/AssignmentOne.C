#include <stdio.h>

main() {

    int arr [10]; //Array of 10 Integers
    int *p = &arr[0]; //Pointer @ address of arr[0]

    printf("Preloaded Array \n");
    for(int i = 0; i < 10; i++) {
        printf("arr[] = %d\n", arr[i]); //Print arr[i]
    }

    printf("\n--------------- \n\n");

    printf("Loaded Array \n");
    for(int i = 0; i < 10; i++) {
        *p = i; //Pointer equal to i
        printf("arr[] = %d\n", arr[i]); //Print arr[i]
        p++; //Increment pointer
    }
}