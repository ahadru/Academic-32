#include <bits/stdc++.h>
using namespace std;

struct Process{
    int id;
    double arrival;
    double burst;
    double completion_time;
    double turn_arround_time;
    double waiting_time;
};

void calculate_completion_time(Process processes[],int n){
    double time_index = 0.0;
    for(int i = 0; i < n; ++i){
        if(processes[i].arrival > time_index){
            time_index += processes[i].arrival - time_index;
            time_index += processes[i].burst;
            processes[i].completion_time = time_index;
        }
        else{
            time_index += processes[i].burst;
            processes[i].completion_time = time_index;         
        }
    }
}

void calculate_taw_time(Process processes[],int n){
    for(int i = 0; i < n; ++i){
        processes[i].turn_arround_time = processes[i].completion_time - processes[i].arrival;
    }
    for(int i = 0; i < n; ++i){
        processes[i].waiting_time = processes[i].turn_arround_time - processes[i].burst;
    }
}

bool compare_proc(Process p1, Process p2){
    return p1.arrival < p2.arrival;
}


int main(){
    freopen("preemptive_fcfs_input.txt","r",stdin);
    //freopen("out.txt","w",stdout);
    int n;
    cin>>n;
    Process processes[n];
    for(int i = 0; i < n; ++i){
        cin>>processes[i].id>>processes[i].arrival>>processes[i].burst;
    }
    sort(processes,processes+n,compare_proc);
    // for(int i = 0; i < n; ++i){
    //     printf("%d %lf %lf\n",processes[i].id,processes[i].arrival,processes[i].burst);
    // }
    calculate_completion_time(processes,n);
    calculate_taw_time(processes,n);
    printf("ID Arrival Burst Turn Arround Waiting Time\n");
    for(int i = 0; i < n; ++i){
        printf("%2d %6.1lf %5.1lf %12.1lf %12.1lf\n",processes[i].id,processes[i].arrival,processes[i].burst,processes[i].turn_arround_time,processes[i].waiting_time);
    }
    return 0;
}