// [1, 2, 3, 1, 2, 4, 4, 1] returns [1, 1, 1, 4, 4, 2, 2, 3]
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FunkySort {
	private static FunkySort s = new FunkySort();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
       
       	List<Integer> input = new ArrayList<Integer>();
		while(scan.hasNext()){
			input.add(scan.nextInt());
		}


		int[] data = new int[input.size()];
		for(int i = 0; i < input.size(); i++) {
			data[i] = input.get(i);
		}

		// long startTime = System.currentTimeMillis();
		// s.printArr(data);

		int[] sorted = s.sort(data);
		s.printArr(sorted);

		// long endTime = System.currentTimeMillis();
		// System.out.println(endTime - startTime);
	}

	// private void printCountedValues(Map<Integer, Data> countedValues) {
	// 	for ( Integer key : countedValues.keySet() ) {
 //    		System.out.println( countedValues.get(key) );
	// 	}
	// }

	private void printArr(int[] data) {
		for(int i = 0; i < data.length; i++) {
			System.out.printf("%d ", data[i]);
		}
		System.out.println();
	}

	private int[] sort(int[] data) {
		int length = data.length;
		Map<Integer, Data> countedValues = s.getCountedValues(data);

		// printCountedValues(countedValues);

		return s.createSortedArray(sortCountedValues(countedValues) , length);
	}

	private Map<Integer, Data> getCountedValues(int[] data) {
		Map<Integer, Data> countedValues = new HashMap<Integer, Data>();
		Data d;

		for(int i = 0; i < data.length; i++) {
			d = countedValues.get(data[i]);

			if(d != null) {
				d.increaseCount();
			} else {
				countedValues.put(data[i], new Data(data[i]));
			}
		}

		return countedValues;
	}

	private List<Data> sortCountedValues(Map<Integer, Data> countedValues) {
		List<Data> dataSorted = new ArrayList<Data>(countedValues.values());

    	Collections.sort(dataSorted, new Comparator<Data>() {
			// -1 greater than
			// 0 equrals
			// 1  less than	
        	public int compare(Data d1, Data d2) {
	            int result;
				if(d1.getCount() == d2.getCount()) {
					if(d1.getValue() == d2.getValue()) {
						result = 0;
					} else if (d1.getValue() < d2.getValue()) {
						result = 1;
					} else {
						result = -1;
					}
				} else if (d1.getCount() < d2.getCount()) {
					result = 1;
				} else {
					result = -1;
				}

				return result;
	        }
    	});

    	return dataSorted;
	}

	private int[] createSortedArray(List<Data> data, int length) {
		int[] sortedData = new int[length];
		int currentIndex = 0;
		
		for (Data d:data){
			for(int i = 0; i < d.getCount(); i++) {
				sortedData[currentIndex] = d.getValue();
				currentIndex++;
			}
		}

		return sortedData;
	}

	private class Data {
		private int value;
		private int count;

		public Data(int val) {
			value = val;
			count = 1;
		}

		public void increaseCount() {
			count++;
		}

		public int getCount() {
			return count;
		}

		public int getValue(){
			return value;
		}	

		// public String toString() {
		// 	StringBuilder sb = new StringBuilder();
		// 	sb.append("Value: ");
		// 	sb.append(this.value);
		// 	sb.append(",count: ");
		// 	sb.append(this.count);
		// 	sb.append("\n");

		// 	return sb.toString();
		// }	
	}
}