
public class Problem1 
{
	
	public int sum()
	{
		int sum=0;
		
		for(int x = 3; x < 1000; x++)
		{
			if(x%3==0 || x%5==0)
			{
				sum = sum + x;
			}
		}
		
		return sum;
	}
	
	public int sumFaster()
	{	
		int sum = 0;
		int nextNumToSum = 0;
		
		while(nextNumToSum < 1000)
		{
			
			nextNumToSum += 3;
			sum += nextNumToSum;
		}
		
		nextNumToSum = 5;
		
		while(nextNumToSum < 1000)
		{
			nextNumToSum += 15;
			sum += nextNumToSum;

		}
		
		nextNumToSum = 10;
		
		while(nextNumToSum < 1000)
		{
			nextNumToSum += 15;
			sum += nextNumToSum;
		}
		
		return sum;
	}
	
	
	public static void main(String args[])
	{
		Problem1 n = new Problem1();
		
		System.out.println(n.sum());
		
		System.out.println(n.sumFaster());
	}

}
