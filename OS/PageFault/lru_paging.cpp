//C++ implementation of lru page fault algorithm 
#include<bits/stdc++.h> 
using namespace std; 

int pageFaults(int pages[], int n, int capacity) { 
	set<int> s;  							// for frames
    map<int, int> indexes; 					// for frame uodate index

	int page_faults = 0; 
	for (int i=0; i<n; i++) {           	// iterating through pages array
		if (s.size() < capacity) { 			// if any frame have empty slot
			if (s.find(pages[i])==s.end()) { 
				s.insert(pages[i]); 
				page_faults++; 
			} 
			indexes[pages[i]] = i; 
		} 
		else{ 
			if (s.find(pages[i]) == s.end()) {  
				int lru = INT_MAX, val;
                set<int>::iterator it; 
				for (it=s.begin(); it!=s.end(); it++) // iterating for minimul page index
				{ 
					if (indexes[*it] < lru) 
					{ 
						lru = indexes[*it]; 
						val = *it; 
					} 
				} 
				s.erase(val); 						// remove value which has minimul page index
				s.insert(pages[i]); 				// insert the new value 
				page_faults++; 
			} 
			indexes[pages[i]] = i; 
		} 
	} 

	return page_faults; 
} 

int main() 
{ 
	int pages[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1,7,0,1}; 
	int n = sizeof(pages)/sizeof(pages[0]); 
	int capacity = 3; 
	cout << pageFaults(pages, n, capacity); 
	return 0; 
} 
