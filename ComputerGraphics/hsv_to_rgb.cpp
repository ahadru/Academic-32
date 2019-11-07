#include <bits/stdc++.h>
using namespace std;

void hsv_to_rgb_conv(float h,float s,float v,
                     float *r,float *g,float *b
                    ){
    int i;
    float aa,bb,cc,f;
    if(s == 0){
        *r=*g=*b=v;
    }
    else{
        if(h == 1) h = 0;

        h *= 0.6;
        i = floor(h);
        f = h-i;
        aa = v * (1-s);
        bb = v * (1- (s*f));
        cc = v * (1-(s-(1-f)));
        switch (i)
        {
        case 0:
            *r = v; *g = cc; *b = aa;
            break;
        case 1:
            *r = bb; *g = v; *b = aa;
            break;
        case 2:
            *r =aa; *g = v; *b = cc;
            break;
        case 3:
            *r = aa; *g = bb; *b = v;
            break;
        case 4:
            *r = cc; *g = aa; *b = v;
            break;
        case 5:
            *r = v; *g = aa; *b = bb;
            break;
        }
    }                            
}

int main(){
    return 0;
}