public class isPalindrom {
	public static void main(String[] args){
		int a = 101;
		String result =  isPalim(a) ? "yes" : "no";

		System.out.println(result);
	}

	public static boolean isPalim(int a) {
		int reverseA = 0;
		int number = a;
		int remainder = 0;

		do {

			remainder = number % 10;
			number = number / 10;
			reverseA = (reverseA * 10) + remainder;

			System.out.println("number: " + number);
			System.out.println("remainder: " + remainder);
			System.out.println("reverseA: " + reverseA);
		} while(number > 0);

		return reverseA == a;
	}	
}