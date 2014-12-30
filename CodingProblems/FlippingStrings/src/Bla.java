
public class Bla 
{
	public static void main(String[] args)
	{
		
		String s = "cat";
		int len;
		len = s.length();
		s = s.substring(len).concat(s.substring(len-1,len) ).concat(s.substring(1,len-1)).concat(s.substring(0,1));
		
		System.out.println(s);
		
		
		Bla x = new Bla();
		System.out.println( x.sumSquares(6) );
		
		int a = 3;
		int b = 2;
		int c = 1;
		
		System.out.println( x.whichGreater(a, b, c) );
	}
	
	public int sumSquares(int n)
	{
		int result;
		if (n == 1)
		{
			result = 0;
		}
		else if(n%2==0)
		{
			 result = (n*n) + sumSquares(--n);
		}
		else 
		{
			result = sumSquares(--n);
		}
		
		return result;
	}
	
	public int whichGreater(int a, int b, int c)
	{
		int large;
		
		if (a > b) 
		{
			if (a > c) large = a;
			else large = c;
		}
		else if (c < b) large = b;
		else large = c;
		
		return large;
	}
}