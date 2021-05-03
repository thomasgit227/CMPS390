#include <stdio.h>

class MyData0 {
    short alpha;
    long beta;
    long gamma;
    short delta;
};

class MyData1 {
    short alpha;
    short beta;
    long gamma;
    long delta;
};

main() {
    printf("The Size of MyData 0 is %d \n", sizeof(MyData0));
    printf("The Size of MyData 1 is %d \n", sizeof(MyData1));
}