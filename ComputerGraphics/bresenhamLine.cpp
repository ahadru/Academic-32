#include <bits/stdc++.h>
#include <graphics.h>
using namespace std;

void dda(float x0,float y0,float x1,float y1){
    int dy=y1-y0;
    int dx=x1-x0;
    int steps=max(abs(dy),abs(dx));
    float xe=(float)dx/steps;
    float ye=(float)dy/steps;
    cout<<xe<<" "<<ye<<endl;
    for(int i=0;i<steps;i++){
        putpixel(x0,y0,RED);
        x0 = x0 + xe;
        y0 = y0 + ye;
    }
}


int main(){
    int gd=DETECT, gm=DETECT;
    initgraph(&gm,&gd,NULL);
    dda(50,40,400,300);
    delay(10000);
    closegraph();
    return 0;
}