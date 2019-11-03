//First Come First Serve Scheduling Algorithm
#include <bits/stdc++.h>
using namespace std;

void waiting_times(vector<pair<int,int> > burst_time,int waiting_time[],int n){
    int time_line = 0;
    sort(burst_time.begin(),burst_time.end());
    for(int i = 0;i < n;i++){
        waiting_time[i] = time_line;
        time_line += burst_time[i].first;
    }
}
float avg_waiting_time(int waiting_time[],int n){
    int total_time = 0;
    for(int i = 0;i<n;i++){
        total_time += waiting_time[i];
    }
    return (float)total_time/n;
}
void turn_around_times(vector<pair<int,int> > burst_time,int waiting_time[],int turn_around_time[],int n) { 
    for (int  i = 0; i < n ; i++) 
        turn_around_time[i] = burst_time[i].first + waiting_time[i]; 
}

int fcfs(vector<pair<int,int> > burst_time,int waiting_time[],int turn_around_time[], int n){
    waiting_times(burst_time,waiting_time,n);
    turn_around_times(burst_time,waiting_time,turn_around_time,n);
    return avg_waiting_time(waiting_time,n);
}

int main(){
    //freopen("in.txt","r",stdin);
    //freopen("out.txt","w",stdout);
    int n = 3;
    vector<pair<int,int>> burst_time = {{24,1},{3,2},{4,3}};
    int waiting_time[n];
    int turn_around_time[n];
    int avg_waiting_time = fcfs(burst_time,waiting_time,turn_around_time,n);
    cout<<"Average Waiting Time "<<avg_waiting_time<<endl;
    for(int i = 0; i < n; i++){
        cout<<"Process "<<burst_time[i].second<<"    "<<burst_time[i].first<<"     "<<waiting_time[i]<<"   "<<turn_around_time[i]<<" \n";
    }
    return 0;
}