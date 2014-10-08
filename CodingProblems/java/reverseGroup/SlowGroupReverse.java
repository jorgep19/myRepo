import  java.io.*;
import java.util.Scanner;

public class SlowGroupReverse {
   	private static SlowGroupReverse gr = new SlowGroupReverse();

   public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
       
		// while(scan.hasNext()){
           String input = "3 ABCEHSHSH";// scan.nextLine();

           int groupsCount = Character.getNumericValue(input.charAt(0));
           String inputString = input.substring(2);

           if( ( ( inputString.length() % groupsCount ) != 0 ) || 
           		groupsCount >= 10 || 
           		inputString.length() > 100) {
           		// continue;
           }

			inputString = gr.gReverse(groupsCount, inputString);
           System.out.println(inputString);
		// }
	}

	public String gReverse(int groupsCount, String str) {
		StringBuilder sb = new StringBuilder();
		int groupLength = str.length() / groupsCount;
		int groupstart = 0;
		int groupMiddle;

		for( int i = 0; i < groupsCount; i++ ) {
			groupstart = i * groupLength;
			groupMiddle = groupstart + (groupLength / 2);

			sb.append( gr.reverseString( 
				str.substring( groupstart, ( groupstart+groupLength ) ) ) );
		}

		return sb.toString();
	}

	public String reverseString(String s) {
		return new StringBuilder(s).reverse().toString();
	}
}