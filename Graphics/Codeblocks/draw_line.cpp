// C++ Implementation for drawing line
#include <bits/stdc++.h>
#include <graphics.h>
using namespace std;

// driver code
int main()
{
	int gd = DETECT, gm;
	initgraph(&gd, &gm, "");

	line(150, 150, 450, 150);

	line(150, 200, 450, 200);

	line(150, 250, 450, 250);

    circle(250, 200, 50);

	getch();
	closegraph();
}
