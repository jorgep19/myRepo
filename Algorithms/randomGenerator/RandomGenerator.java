import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class RandomGenerator {
	public static void main(String[] args) {
		PrintWriter writer = null;

		try {
			writer = new PrintWriter("bigInput.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Random rand = new Random();
		int randomNum = 0;
		int min = 0;
		int max = 1000000;
		int count = 10000000;

		for (int i = 0; i < count; i++) {
	    	randomNum = rand.nextInt((max - min) + 1) + min;
	    	writer.printf("%d ", randomNum);
		}

		writer.close();
	}
}