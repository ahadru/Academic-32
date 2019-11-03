//First Come First Serve Sheduling Algorithm
#include <bits/stdc++.h>
using namespace std;

void waiting_times(int burst_time[],int waiting_time[],int n){
    int time_line = 0;
    for(int i = 0;i < n;i++){
        waiting_time[i] = time_line;
        time_line += burst_time[i];
    }
}
float avg_waiting_time(int waiting_time[],int n){
    int total_time = 0;
    for(int i = 0;i<n;i++){
        total_time += waiting_time[i];
    }
    return (float)total_time/n;
}
int fcfs(int burst_time[],int waiting_time[], int n){
    waiting_times(burst_time,waiting_time,n);
    return avg_waiting_time(waiting_time,n);
}

int main(){
    //freopen("in.txt","r",stdin);
    //freopen("out.txt","w",stdout);
    int n = 3;
    int burst_time[] = {24,3,4};
    int waiting_time[n];
    int avg_waiting_time = fcfs(burst_time,waiting_time,n);
    cout<<"Average Waiting Time "<<avg_waiting_time<<endl;
    for(int i = 0; i < n; i++){
        cout<<i+1<<" "<<burst_time[i]<<" "<<waiting_time[i]<<" \n";
    }
    return 0;
}