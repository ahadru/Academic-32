#include <bits/stdc++.h>
using namespace std;

bool smr(int set[],int n,int sum){
    if(sum == 0){
        return true;
    }
    if(n == 0 && sum != 0){
        return false;
    }

    if(set[n-1] > sum){
        return smr(set,n-1,sum);
    }

    return smr(set,n-1,sum) || smr(set,n-1,sum-set[n-1]);
}

bool smdp(int set[],int n){

}

int main(){
    int set[] = {3, 34, 4, 12, 5, 2}; 
    int sum = 31; 
    int n = sizeof(set)/sizeof(set[0]); 

    if (smr(set, n, sum) == true) 
        printf("Found a subset with given sum"); 
    else
        printf("No subset with given sum"); 

    return 0; 
}