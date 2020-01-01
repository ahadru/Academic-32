<<<<<<< HEAD
#include <bits/stdc++.h>
#include <iostream>
#define MAX 20
using namespace std;
 
class bankers
{
    private:
        int al[MAX][MAX],m[MAX][MAX],n[MAX][MAX],avail[MAX];
        int nop,nor,k,result[MAX],pnum,work[MAX],finish[MAX];
 
    public:
        bankers();
        void input();
        void method();
        int search(int);
        void display();
};
 
bankers::bankers()
{
    k=0;
    for(int i=0;i<MAX;i++)
    {
        for(int j=0;j<MAX;j++)
        {
            al[i][j]=0;
            m[i][j]=0;
            n[i][j]=0;
        }
        avail[i]=0;
        result[i]=0;
        finish[i]=0;
    }
}
 
void bankers::input()
{
    int i,j;
    cout << "Enter the number of processes:";
    cin >> nop;
    cout << "Enter the number of resources:";
    cin >> nor;
    cout << "Enter the allocated resources for each process: " << endl;
    for(i=0;i<nop;i++)
    {
        cout<<"\nProcess "<<i;
        for(j=0;j<nor;j++)
        {
            cout<<"\nResource "<<j<<":";
            cin>>al[i][j];
        }
    }
    cout<<"Enter the maximum resources that are needed for each process: "<<endl;
    for(i=0;i<nop;i++)
    {
        cout<<"\nProcess "<<i;
        for(j=0;j<nor;j++)
        {
            cout<<"\nResouce "<<j<<":";
            cin>>m[i][j];
            n[i][j]=m[i][j]-al[i][j];
        }
    }
    cout << "Enter the currently available resources in the system: ";
    for(j=0;j<nor;j++)
    {
        cout<<"Resource "<<j<<":";
        cin>>avail[j];
        work[j]=-1;
    }
    for(i=0;i<nop;i++)
        finish[i]=0;
}
 
void bankers::method()
{
    int i=0,j,flag;
    while(1)
    {
        if(finish[i]==0)
        {
            pnum =search(i);
            if(pnum!=-1)
            {
                result[k++]=i;
                finish[i]=1;
                for(j=0;j<nor;j++)
                {
                    avail[j]=avail[j]+al[i][j];
                }
            }
        }
        i++;
        if(i==nop)
        {
            flag=0;
            for(j=0;j<nor;j++)
                if(avail[j]!=work[j])
 
            flag=1;
            for(j=0;j<nor;j++)
                work[j]=avail[j];
 
            if(flag==0)
                break;
            else
                i=0;
        }
    }
}
 
int bankers::search(int i)
{
    int j;
    for(j=0;j<nor;j++)
        if(n[i][j]>avail[j])
            return -1;
    return 0;
}
 
void bankers::display()
{
    int i,j;
    cout<<endl<<"OUTPUT:";
    cout<<endl<<"========";
    cout<<endl<<"PROCESS\t     ALLOTED\t     MAXIMUM\t     NEED";
    for(i=0;i<nop;i++)
    {
        cout<<"\nP"<<i+1<<"\t     ";
        for(j=0;j<nor;j++)
        {
            cout<<al[i][j]<<"  ";
        }
        cout<<"\t     ";
        for (j=0;j<nor;j++)
        {
            cout<<m[i][j]<<"  ";
        }
        cout<<"\t     ";
        for(j=0;j<nor;j++ )
        {
            cout<<n[i][j]<<"  ";
        }
    }
    cout<<"\nThe sequence of the safe processes are: \n";
    for(i=0;i<k;i++)
    {
        int temp = result[i]+1 ;
        cout<<"P"<<temp<<" ";
    }
    cout<<"\nThe sequence of unsafe processes are: \n";
    int flg=0;
    for (i=0;i<nop;i++)
    {
        if(finish[i]==0)
        {
        flg=1;
        }
        cout<<"P"<<i<<" ";
    }
    cout<<endl<<"RESULT:";
    cout<<endl<<"=======";
    if(flg==1)
        cout<<endl<<"The system is not in safe state and deadlock may occur!!";
    else
        cout<<endl<<"The system is in safe state and deadlock will not occur!!";
}
 
int main()
{
    cout<<" DEADLOCK BANKER’S ALGORITHM "<<endl;
    bankers B;
    B.input ( );
    B.method ( );
    B.display ( );
}
=======
// Banker's Algorithm 
#include <stdio.h> 
int main() 
{ 
	// P0, P1, P2, P3, P4 are the Process names here 

	int n, m, i, j, k; 
	n = 5; // Number of processes 
	m = 3; // Number of resources 
	int alloc[5][3] = { { 0, 1, 0 }, // P0 // Allocation Matrix 
						{ 2, 0, 0 }, // P1 
						{ 3, 0, 2 }, // P2 
						{ 2, 1, 1 }, // P3 
						{ 0, 0, 2 } }; // P4 

	int max[5][3] = { { 7, 5, 3 }, // P0 // MAX Matrix 
					{ 3, 2, 2 }, // P1 
					{ 9, 0, 2 }, // P2 
					{ 2, 2, 2 }, // P3 
					{ 4, 3, 3 } }; // P4 

	int avail[3] = { 3, 3, 2 }; // Available Resources 

	int f[n], ans[n], ind = 0; 
	for (k = 0; k < n; k++) { 
		f[k] = 0; 
	} 
	int need[n][m]; 
	for (i = 0; i < n; i++) { 
		for (j = 0; j < m; j++) 
			need[i][j] = max[i][j] - alloc[i][j]; 
	} 
	int y = 0; 
	for (k = 0; k < 5; k++) { 
		for (i = 0; i < n; i++) { 
			if (f[i] == 0) { 

				int flag = 0; 
				for (j = 0; j < m; j++) { 
					if (need[i][j] > avail[j]){ 
						flag = 1; 
						break; 
					} 
				} 

				if (flag == 0) { 
					ans[ind++] = i; 
					for (y = 0; y < m; y++) 
						avail[y] += alloc[i][y]; 
					f[i] = 1; 
				} 
			} 
		} 
	} 

	printf("Following is the SAFE Sequence\n"); 
	for (i = 0; i < n - 1; i++) 
		printf(" P%d ->", ans[i]); 
	printf(" P%d", ans[n - 1]); 

	return (0); 

	// This code is contributed by Deep Baldha (CandyZack) 
} 
>>>>>>> 50176a2f27d44f0181c6172a21fe9ea76088cef8
