//Jorge Paez
//11-6-11

import java.io.*;
import java.util.Scanner;

public class Funds 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		FundTree funds = new FundTree();
		
		System.out.println("If your file is out of source folder input the full location. " +
				         "Please enter the name of your records file your: ");
		String fileName = keyboard.nextLine();
		
		Scanner file = new Scanner(new File (fileName));
			
		//loop to read the file.
		while(file.hasNext() )
		{
			String instruction = file.next();
			
			if(instruction.equals("insert") )
			{
				String tick = file.next();
				double cValue = file.nextDouble();
				double oneYReturn = file.nextDouble();
				double threeYreturn = file.nextDouble();
				String threeYRisk = file.next();
				String threeYReturn = file.next();
				int rating = file.nextInt();
				
				Fund newFund = new Fund(tick, cValue, oneYReturn, threeYreturn, threeYRisk, threeYReturn, rating);
				
				funds.insert(newFund);
			}
			
			else if(instruction.equals("searchtick") )
			{
				String tick = file.next();
				
				System.out.println(funds.searchTick(tick) );
			}
			
			else if(instruction.equals("searchstar") )
			{
				int starRating = file.nextInt();
				
				System.out.println(funds.searchStar(starRating) );
			}
			
			else if(instruction.equals("count") )
			{
				System.out.println( funds.count() );
			}
			
			else if(instruction.equals("list") )
			{
				System.out.println( funds.list() );
			}
			
			else
			{
				System.out.println("Error... Invalid comand.");
			}
		}
		
		file.close();
	}
}
