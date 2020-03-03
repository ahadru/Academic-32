#include <graphics.h>
#include <stdlib.h>

void drawRandomLines() {
    setbkcolor(WHITE);

    int maxx = getmaxx();
    int maxy = getmaxy();

    int numberOfLines = rand() % 100;
    int color;

    for(int i = 0; i < numberOfLines; i++) {
        color = rand() % 16;
        setcolor(color);
        line(rand() % maxx, rand() % maxy,
            rand() % maxx, rand() % maxy);
    }
}

int main() {
    int gd=DETECT, gm=DETECT;
    initgraph(&gd,&gm,NULL);
    drawRandomLines();

    delay(5000);
    closegraph();
    return 0;
}