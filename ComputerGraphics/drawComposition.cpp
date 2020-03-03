#include <graphics.h>

int main() {
    int gd=DETECT, gm=DETECT;
    initgraph(&gd,&gm,NULL);
    
    setbkcolor(LIGHTGRAY);
    setcolor(BLACK);

    // Kanizsa Square

    circle(150, 150, 75);
    floodfill(150, 150, BLACK);

    circle(150, 350, 75);
    floodfill(150, 350, GREEN);

    circle(350, 150, 75);
    floodfill(350, 150, RED);

    circle(350, 350, 75);
    floodfill(350, 350, BLUE);

    setcolor(WHITE);
    rectangle(150, 150, 350, 350);
    floodfill(200, 200, WHITE);

    delay(10000);
    closegraph();
    return 0;
}