#include <iostream>

using namespace std;

void printArray(int * pArr, int n) {

	for (int i = 0; i < n; i++) {
		printf("%d", pArr[i]);
	}
}

void mergeParts(int * arr, int * tmpArr, int lower, int middle, int upper) {
	for (int i = lower; i <= upper; i++) {
		tmpArr[i] = arr[i];
	}

	int i = lower;
	int j = middle + 1;
	int k = lower;

	while(i <= middle && j <= upper) {
		if(tmpArr[i] <= tmpArr[j]) {
			arr[k] = tmpArr[i];
			i++;
		} else {
			arr[k] = tmpArr[j];
			j++;
		}
		k++;
	}

	while(i <= middle) {
		arr[k] = tmpArr[i];
		k++;
		i++;
	}
}

void doMergeSort(int * arr, int * tmpArr, int lower, int upper) {
	if (lower < upper) {
		int middle = lower + ((upper - lower)/ 2);

		doMergeSort(arr, tmpArr, lower, middle);
		doMergeSort(arr, tmpArr, middle, upper);
		mergeParts(arr, tmpArr, lower, middle, upper);
	}
}

void sort(int * arr, int n) {
	int * tmp = new int[n];
	doMergeSort(arr, tmp, 0, n-1);
	delete tmp;
}

int main() {
	int arr[] = {1,3,4,2,5,6};
	int * pArr = arr;
	
	printArray(pArr, 6);

	sort(pArr, 6);
	
	printArray(pArr, 6);
	
	return 0;
}