return counter&1; // isOdd?

----------------------------------------------------

for(int i = 0 ; i < (1<<6) ; i++){
	int sum =0;
	for(int j = 0 ; j < 6 ; j++){
		if(i&(1<<j) > 0){
			sum += set[j];
		}
	}
	if(sum == T)return true;
}

--------------------------------------------------

int row[] = {1,0,-1,0};
int col[] = {0,1,0,-1};

visited[start_x][start_y] = true;

for(int i = 0 ; i < 4 && !found; i++){
	found  =doScape(start_x + row[i], start_y, S, currentSteps + col[i]); 
}

visited[start_x][start_y] = false;

return found;