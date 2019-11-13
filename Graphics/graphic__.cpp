/** Random length random color line with random delay
*   and number of line is also random.
*/

#include<bits/stdc++.h>
#include<graphics.h>
using namespace std;

int main() {
    int i,j,x,y=rand()%6,cn=0;

    int gd=DETECT,gm;
    initgraph(&gd,&gm,"");

    while(1){
        cn++;
        setcolor(rand()%16);
        line(rand()%400,rand()%400,rand()%400,rand()%400);
        delay(rand()%1000);
        if(cn>=y){
            cleardevice();
            y=rand()%6;
        }
    }
    getch();
    closegraph();
}

