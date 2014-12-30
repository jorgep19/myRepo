//JORGE PAEZ
//October 2011

public class NumberConversion 
{
	public static void main(String[] arg)
	{
		//Create a DecToNewBase object and use its toString(base) method 
		//to print its conversion to a desired base.
		DecToNewBase n1 = new  DecToNewBase(8);
		
		System.out.println(n1.toString(2));
		System.out.println(n1.toString(3));
		System.out.println(n1.toString(5));
		System.out.println(n1.toString(8));
		System.out.println(n1.toString(9));
		System.out.println(n1.toString(12));
		System.out.println(n1.toString(16));
		System.out.println(n1.toString(35));
		
		//Create a DecToNewBase object and use its toString(base) method 
		//to print its conversion to a desired base.
		DecToNewBase n2 = new  DecToNewBase(57);
		
		System.out.println("\n" + n2.toString(2));
		System.out.println(n2.toString(3));
		System.out.println(n2.toString(5));
		System.out.println(n2.toString(8));
		System.out.println(n2.toString(9));
		System.out.println(n2.toString(12));
		System.out.println(n2.toString(16));
		System.out.println(n2.toString(27));
		
		//Create a DecToNewBase object and use its toString(base) method 
		//to print its conversion to a desired base.
		DecToNewBase n3 = new  DecToNewBase(63);
		
		System.out.println("\n" + n3.toString(2));
		System.out.println(n3.toString(3));
		System.out.println(n3.toString(5));
		System.out.println(n3.toString(8));
		System.out.println(n3.toString(9));
		System.out.println(n3.toString(12));
		System.out.println(n3.toString(16));
		System.out.println(n3.toString(27));
		
		//Create a DecToNewBase object and use its toString(base) method 
		//to print its conversion to a desired base.
		DecToNewBase n4 = new  DecToNewBase(129);

		System.out.println("\n" + n4.toString(2));
		System.out.println(n4.toString(3));
		System.out.println(n4.toString(5));
		System.out.println(n4.toString(8));
		System.out.println(n4.toString(9));
		System.out.println(n4.toString(12));
		System.out.println(n4.toString(16));
		System.out.println(n4.toString(27));
	}
}
