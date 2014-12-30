
public class VampireNumbers 
{
	public static void main(String[] args)
	{
		VampireNumbers n = new VampireNumbers();
		
		System.out.println(n.vNumber(126));
	}
	
	
	//method to determine the lowest vampire number greater than X
	public int vNumber(int X)
	{
		while(!isVampireNum(X))
		{
			X++;
		}
		
		return X;
	}
	
	//method to determine if V is a vampire number
	public boolean isVampireNum(int v)
	{
		boolean itIs = false;
		int[] digits = numberToArrayOfDigits(v);
		int length = digits.length;
		int a = 0;
		int b = 0;
		
	x:	do
		{	
			//create factohtrW	
		
			if(v == (a*b) )
			{
				itIs = true;
				break x;
			}
		}while(v == (a*b));
		
		return itIs;
	}

	//method to get all the digits of a number
	public int[] numberToArrayOfDigits(int x)
	{
		String number = Integer.toString(x);
		int length = number.length();		
		int[] digits = new int[length];
		
		for(int i = 0; i < length; i++)
		{
			digits[i] = Integer.parseInt(number.substring(i, (i+1) ) );
		}
		
		return digits;
	}
}

/*
 *Loop to print all the digits of a number 
 * for(int i = 0; i < length; i++)
		{
			System.out.println(digits[i]); 
		}
		
*/