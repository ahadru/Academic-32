#include <graphics.h>

void plotLine(int x0, int y0, int x1, int y1) {
    int dx = x1 - x0;
    int dy = y1 - y0;
    int y = y0;
    int eps = 0;

    for(int x = x0; x <= x1; x++) {
        putpixel(x, y, RED);
        eps += dy;
        if((eps << 1) >= dx) {
            y++;
            eps -= dx;
        }
    }
}

int main() {
    int gd=DETECT, gm=DETECT;
    initgraph(&gd,&gm,NULL);
    setbkcolor(WHITE);
    plotLine(3, 30, 500, 105);
    delay(10000);
    closegraph();
    return 0;
}