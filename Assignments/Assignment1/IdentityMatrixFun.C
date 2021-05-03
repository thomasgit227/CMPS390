#include <stdio.h>

main() {
    int I [5][5];

    //Create that Identity Matrix yo! #Math360
    for(int i = 0; i < 5; i++) {
        for(int j = 0; j < 5; j++) {
            if(i == j) {
                I[i][j] = 1;
            }
            else {
                I[i][j] = 0;
            }
        }
    }

    //Print dat Matrix
    for(int i = 0; i < 5; i++) {
        for(int j = 0; j < 5; j++) {
            printf("%d ", I[i][j]);
        }
        printf("\n");
    }

    //Fill the Matrix #pointerstyle
    int *p = &I[0][0];
    for(int i = 0; i < 5; i++) {
        for(int j = 0; j < 5; j++) {
            if(i == j) {
                *p = 1;
            }
            else {
                *p = 0;
            }
        }
    }

    //Print #pointerstyle
    p = &I[0][0]; //pointer reset
    for(int i = 0; i < (5 * 5); i++) {
        if(i % 5 == 0) {
            printf("\n");
        }
        printf("%d ", *p);
        p++;
    }

    //Do the Row Swap R0 w/ R4
    printf("\n\n");

    p = &I[4][0]; //pointer reset
    for(int i = 0; i < 5; i++) {
        printf("%d ", *p);
        p++;
    }
    printf("\n");
    p = &I[1][0]; //pointer reset
    for(int i = 0; i < 5; i++) {
        printf("%d ", *p);
        p++;
    }
    printf("\n");
    p = &I[2][0]; //pointer reset
    for(int i = 0; i < 5; i++) {
        printf("%d ", *p);
        p++;
    }
    printf("\n");
    p = &I[3][0]; //pointer reset
    for(int i = 0; i < 5; i++) {
        printf("%d ", *p);
        p++;
    }
    printf("\n");
    p = &I[0][0]; //pointer reset
    for(int i = 0; i < 5; i++) {
        printf("%d ", *p);
        p++;
    }
}