public class ViveLaDifference 
{
	
	public static void main(String[] args)
	{
		ViveLaDifference n = new ViveLaDifference();
		
		System.out.println( n.calcVLD(1, 3, 5, 9) );
		System.out.println( n.calcVLD(4, 3, 2, 1) );
		System.out.println( n.calcVLD(1, 1, 1, 1) );
		System.out.println( n.calcVLD(0, 0, 0, 0) );
	}
	
	public int calcVLD(int a, int b, int c, int d)
	{
		int steps = 0;
		int x = 0;
		
		while(a!= b || a!=c || a!=d)
		{
			steps++;
			
			x = a;
			
			a = Math.abs( a-b ); 
			b = Math.abs( b-c );
			c = Math.abs( c-d );
			d = Math.abs( d-x );
		}
		
		return steps;
	}
	
}