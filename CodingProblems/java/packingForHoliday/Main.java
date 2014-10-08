// Solution for http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=3794
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// suitcase is length, width and heigh = 20 inches
		int testCount = scan.nextInt(); // number of test cases
		int l;
		int h;
		int w;

		for(int i = 0; i < testCount; i++) {
			l = scan.nextInt();
			h = scan.nextInt();
			w = scan.nextInt();

			System.out.printf(
				"Case %d: %s\n", 
				(i + 1), 
				( packageFits(l,h, w) ? "good" : "bad"));
		}
	}

	private static boolean packageFits(int l, int h, int w) {
		return  l <= 20 &&
				h <= 20 &&
				w <= 20 &&
				(20*20*20) >= (l*h*w);
	}
}