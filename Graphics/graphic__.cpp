#include<bits/stdc++.h>
#include<graphics.h>
using namespace std;

int main() {
    int i,j,x,y=10000,cn=0;

    int gd=DETECT,gm;
    initgraph(&gd,&gm,"");

    while(1){
        cn++;
        putpixel (rand()%400,rand()%400,rand()%16);;
        delay(rand()%400);
        if(cn>=y){
            cleardevice();
            y=rand()%6;
        }
    }
    getch();
    closegraph();
}
