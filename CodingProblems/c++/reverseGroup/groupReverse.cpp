#include <cstdio>
#include <iostream>
#include <string>


using namespace std;


void rev(string &str, int i, int j){
    while(i < j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
        
        i++;j--;
    }
}

int main(){
    
    int n;
    string line;
    
    cin >> n;
    
    while(n){
        
        cin >> line;
        int groupLength = line.size()/n;
        for(int i = 0 ; i < (int)line.size() ; i += groupLength)
            rev(line, i, i + groupLength-1);
            
        cout << line << endl;
        cin >> n;
    }
    
    return 0;
}