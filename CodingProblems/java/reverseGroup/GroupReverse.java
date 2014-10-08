import  java.io.*;
import java.util.Scanner;

public class Main {
   	private static Main gr = new Main();

   public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
       
		while(scan.hasNext()){
           	String input = scan.nextLine();
			String inputString = "";

			if(!input.equals( "0" ) ) {

           		int groupsCount = Character.getNumericValue(input.charAt(0));
           		inputString = input.substring(2);

				inputString = gr.gReverse(groupsCount, inputString.toCharArray());
			
				System.out.println(inputString);
			}
		}
	}

	public String gReverse(int groupsCount, char[] str) {
		int groupLength = str.length/ groupsCount;
		int groupstart = 0;
		int groupEnd;
		char tmp;

		for( int i = 0; i < groupsCount; i++ ) {
			groupstart = i * groupLength;
			groupEnd = groupstart + groupLength;

			for(int j = 0; j < (groupLength / 2); j++) {
				tmp = str[groupstart + j];
				str[groupstart + j] = str[groupEnd - j - 1];
				str[groupEnd - j - 1] = tmp;
			}
		}

		return new String(str);
	}
}