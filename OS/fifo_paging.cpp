#include<bits/stdc++.h> 
#include <set>
using namespace std; 

// Function to find page faults using FIFO 
int pageFaults(int pages[], int n, int capacity) 
{ 
	set<int> s; 
	queue<int> page_indexs; //fifo manner paging

	int page_faults = 0; 
	for (int i=0; i<n; i++) { 
		if (s.size() < capacity) { 
			if (s.find(pages[i])==s.end()){ // Insert it into set if not present  
				s.insert(pages[i]); 
				page_faults++; 
				page_indexs.push(pages[i]); // Push the current page into the queue 
			} 
		}  
		else
		{ 
			if (s.find(pages[i]) == s.end()) 
			{ 
				int val = page_indexs.front(); 
				page_indexs.pop(); 
				s.erase(val); 
				s.insert(pages[i]); 
				page_indexs.push(pages[i]); 
				page_faults++; 
			} 
		} 
	} 

	return page_faults; 
} 

// Driver code 
int main() 
{ 
	int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1,7,0,1}; 
	int n = sizeof(pages)/sizeof(pages[0]); 
	int capacity = 3; 
	cout << pageFaults(pages, n, capacity); 
	return 0; 
} 
