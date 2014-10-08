N bits.

ex: n =2

00
01
10
11

n = 3

000
001
010
011
100

i = 101

j = 001
j = 010
j = 100

i&(1<<j)
101 & 001 = 001
101 & 010 = 000
101 & 100 = 100

public int countOddBytes(int bit) {
int sumOfOdds = 0;

1 = 00000001
(1<<2) = 00000100
int counter =0;

for (int i = 0; i < (1<<bit); i++)  {
	counter =0;

	for(int j = 0 ; j  < bit ; j++){
		if(i&(1<<j))counter++;	  11
	}

if(oddBits(i)) {
sumOfOdds++;	
}
}
return counter&1;
//return sumOfOdds;
}

1011

public boolean oddBits(int i) {
	int oddBitsCount = 0;
	
	int[] bytes = i.toByteArray();
for(int i = 0; i < bytes.length; i++) {
	if(bytes[i] != 0) {
		oddBitsCount++;
	}
}	


while(i > 0) {
		oddBitsCount = (i % 2 == 0) ? oddBitsCount : oddBitsCount++;	// 2 -> 10
		i = i /2;
}

	return (oddBitsCount % 2 != 0);
}

----------------------------------------------------------------------------------------------------------------------------



N*N grid

S = steps

uuuuu
uoooo
uouuu
uooou
uuuuu


public interface Grid {
	void setLocation(x, y);
	void goUp();
	…
	char checkLocation(); 
}

private int N;
private boolean[][] visited = new boolean[N][N];

boolean canEscape(int start_x, int start_y, int S) {
	return doScape(start_x, start_y, S, 0);	
}
int row[] = {1,0,-1,0};
int col[] = {0,1,0,-1};

public boolean doScape(int start_x, int start_y, int S, int currentSteps) {
	if(currentSteps > S ||  grid.At(start_x, start_y - 1) == u || visited(start_y, start_y - 1)) {
		return false;
} else if (start_x == N || start_y == N || start_x == 0 || start_y == 0) {
	return true;
} 
boolean found = false;

visited[start_x][start_y] = true;

for(int i = 0 ; i < 4 && !found; i++){
	found  =doScape(start_x + row[i], start_y, S, currentSteps + col[i]); 
}

visited[start_x][start_y] = false;

return found;

visited[start_x][start_y] = true;

boolean escaped =  doScape(start_x, start_y - 1, S, currentSteps +1) || 
doScape(start_x + 1, start_y, S, currentSteps +1) || 
doScape(start_x, start_y + 1, S, currentSteps +1) || 
doScape(start_x -1, start_y - 1, S, currentSteps +1);

visited[start_x][start_y] = false;

return escaped;
}


public boolean visited(int x, int y) {
	return visited[x][y];
}

----------------------------------------------------------------------------------------------------------------------------


int set[] = {1,5,3,6,3,5}

000001
000010
000011
000100

for(int i = 0 ; i < (1<<6) ; i++){
	int sum =0;
	for(int j = 0 ; j < 6 ; j++){
		if(i&(1<<j) > 0){
			sum += set[j];
		}
	}
	if(sum == T)return true;
}

000001 & 000001 = 000001
000001 & 000010 = 000000
000001 & 000100 = 000000
000001 & 000100 = 000000

000010 & 000001 = 000000
000010 & 000010 = 000010
