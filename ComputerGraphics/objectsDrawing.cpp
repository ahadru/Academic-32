#include <iostream>
#include <graphics.h>
using namespace std;

int main(){
    int gd=DETECT, gm=DETECT;
    initgraph(&gm,&gd,NULL);

    line(50,30,400,30);
    circle(250, 100, 50);
    rectangle(100, 100, 400, 400);
    delay(10000);
    closegraph();
    return 0;
}