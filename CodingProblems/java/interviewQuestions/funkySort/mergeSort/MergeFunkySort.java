// [1, 2, 3, 1, 2, 4, 4, 1] returns [1, 1, 1, 4, 4, 2, 2, 3]
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeFunkySort {
	private static MergeFunkySort s = new MergeFunkySort();

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

		long startTime = System.currentTimeMillis();

		Data[] sorted = s.sort(data);
		s.printSortedData(sorted);

		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

	private void printSortedData(Data[] data) {
		for (Data d:data) {
			for (int i =0; i < d.getCount(); i++) {
				System.out.printf("%d ", d.getValue());
			}
		}
		
		System.out.println();
	}

	private Data[] sort(int[] data) {
		int length = data.length;
		Map<Integer, Data> countedValues = s.getCountedValues(data);

		Collection<Data> d = countedValues.values();
		Data[] dataSorted =  d.toArray(new Data[d.size()]);
		dataSorted = new MergeSorter().sort(dataSorted);

		return dataSorted;
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

		// -1 less than
		// 0 equrals
		// 1  greater than	
    	public int compareTo(Data o) {
            int result;
			if(this.getCount() == o.getCount()) {
				if(this.getValue() == o.getValue()) {
					result = 0;
				} else if (this.getValue() < o.getValue()) {
					result = 1;
				} else {
					result = -1;
				}
			} else if (this.getCount() < o.getCount()) {
				result = 1;
			} else {
				result = -1;
			}

			return result;
        }
	}

	public class MergeSorter {
		private Data[] dataArray;
		private int length;
		private Data[] supportArray;

		public Data[] sort(Data[] arr) {
			this.dataArray = arr;
	        this.length = arr.length;
	        this.supportArray = new Data[length];
	        doMergeSort(0, length - 1);

	        return dataArray;
		}

		private void doMergeSort(int lower, int upper) {
			if(lower < upper) {
				int middle = lower + ((upper - lower)/2);

				doMergeSort(lower, middle);
				doMergeSort(middle + 1, upper);

				mergeRuns(lower, middle, upper);
			}
		}

		private void mergeRuns(int lower, int middle, int upper) {
			for (int i = lower; i <= upper; i++) {
				supportArray[i] = dataArray[i];
			}

			int i = lower;
			int j = middle + 1;
			int k = lower;

			while(i <= middle && j <= upper) {
				// j > i
				if(supportArray[i].compareTo(supportArray[j]) > 0) {
					dataArray[k] = supportArray[j];
					j++;
				} else { // i <= j
					dataArray[k] = supportArray[i];
					i++;
				}
				k++;
			}

			while( i <= middle ) {
				dataArray[k] = supportArray[i];
				i++;
				k++;
			}
		}
	}
}