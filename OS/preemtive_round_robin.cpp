#include<bits/stdc++.h> 
using namespace std; 

struct Process{
	int id;
	int arival_time;
	int burst_time;
	int waiting_time;
	int turn_arround_time;
	int completion_time;
};
bool compare_p(Process p1, Process p2){
	return (p1.arival_time < p2.arival_time);
}

void calculate(Process){

}

int main() { 
	freopen("non_preemtive_round_robin_input.txt","r",stdin);
	int n = 5;
	int quantam = 2;
	Process process[n];
	for(int i = 0;i<n; ++i){
		cin>>process[i].id;
		cin>>process[i].arival_time;
		cin>>process[i].burst_time;
	}
	sort(process,process+n,compare_p);

	return 0; 
} 
