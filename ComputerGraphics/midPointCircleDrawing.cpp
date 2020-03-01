#include <graphics.h>
#include <iostream>
using namespace std;

void drawCircle(int x,int y,int r,int color){
    int x0 = 0, y0 = r;
    if(r <  0) return;
    int p = 1 - r;
    while(x0 < y0){
        putpixel(x + x0,y + y0, color);
        putpixel(x + x0,y - y0, color);
        putpixel(x - x0,y + y0, color);
        putpixel(x - x0,y - y0, color);
        putpixel(x + y0,y + x0, color);
        putpixel(x + y0,y - x0, color);
        putpixel(x - y0,y + x0, color);
        putpixel(x - y0,y - x0, color);
        x0++;
        if(p < 0){       
            p = p + (2*x0) + 1; 
        }
        else{
            y0--;
            p = p + (2*x0) + 1 - (2*y0); 
        }
    }
}

int main(){
    int gd=DETECT, gm=DETECT;
    initgraph(&gd,&gm,NULL);
    drawCircle(100,100,50,RED);
    //circle(100,100,50);
    delay(5000);
    closegraph();
    return 0;
}