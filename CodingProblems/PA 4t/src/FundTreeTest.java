//Jorge Paez
//11-8-11

import junit.framework.TestCase;

public class FundTreeTest extends TestCase
{

	FundTree n = new FundTree();
	
	Fund f1 = new Fund("LMOPX", 205.04, -13.23, -2.97, "hgh", "low", 1);
	Fund f2 = new Fund("FLCGX", 170.90, -0.20, 4.96, "hgh", "avp", 2);
	Fund f3 = new Fund("DONES", 185.88, -6.28, 0.86, "hgh", "avm", 2);
	Fund f4 = new Fund("KIFAX", 163.73, -4.57, -0.59, "low", "hgh", 4);
	Fund f5 = new Fund("RYMMX", 185.88, -6.28, 0.86, "hgh", "avm", 1);
	
	String s1 = this.n.insert(f1);
	String s2 = this.n.insert(f2);
	String s3 = this.n.insert(f3);
	String s4 = this.n.insert(f4);
	
	
	//This method tests the insert(Fund newFund) of the FundTree class.
	public void testInsert() 
	{
		Fund f6 = new Fund("ACKDX", 205.04, -13.23, -2.97, "hgh", "low", 3);
		Fund f7 = new Fund("ZASKD", 170.90, -0.20, 4.96, "hgh", "avp", 2);
		Fund f8 = new Fund("LMOPX", 205.04, -13.23, -2.97, "hgh", "low", 4);
		
		//Insert an object should go to the right of the tree
		String expectedOutput = this.n.insert(f6);
		assertEquals("Fund inserted: ACKDX", expectedOutput );
		
		//Insert an object should go to the left of the tree
		expectedOutput = this.n.insert(f7);
		assertEquals("Fund inserted: ZASKD", expectedOutput );
		
		//Try to insert a Fund created in the local scope, expecting an unsuccessful outcome.
		expectedOutput = this.n.insert(f8);
		assertEquals("Fund: LMOPX is already stored", expectedOutput );
		
		//Insert an object outside of local scope
		expectedOutput = this.n.insert(f5);
		assertEquals("Fund inserted: RYMMX", expectedOutput );
		
		//Try to insert a Fund created outside local scope, expecting an unsuccessful outcome.
		expectedOutput = this.n.insert(f5);
		assertEquals("Fund: RYMMX is already stored", expectedOutput );
		
		//Check that the proper Fund object is the root of the tree.
		Fund f9 = new Fund();
		f9 = n.getRoot();
		expectedOutput = f9.getTicker();
		assertEquals("LMOPX", expectedOutput );
		
		//Check that the proper Fund object is the root's leftChild
		f9 = f9.getLeftChild();
		expectedOutput = f9.getTicker();
		assertEquals("FLCGX", expectedOutput );
		
		//Check that the proper Fund object is the leftChild of the root's leftChild. Checking 3rd lever insertions.
		f9 = f9.getLeftChild();
		expectedOutput = f9.getTicker();
		assertEquals("DONES", expectedOutput );
		
		//Check that the proper Fund object is the root's leftChild
		Fund f10 = new Fund();
		f10 = n.getRoot();
		f10 = f10.getRightChild();
		expectedOutput = f10.getTicker();
		assertEquals("ZASKD", expectedOutput );
	}
	
	//This method tests the searchTick(String tick) of the FundTree class.
	public void testSearchTick() 
	{
		//Search for the root
		String expectedOutput = this.n.searchTick("LMOPX");
		assertEquals(f1.toString() , expectedOutput);
		
		//Search for a fund in the 3rd level of the tree
		expectedOutput = this.n.searchTick("KIFAX");
		assertEquals(f4.toString() , expectedOutput);
		
		//Search for a fund thatis not present in the tree.
		expectedOutput = this.n.searchTick("HOLAX");
		assertEquals("Search for fund: HOLAX not found", expectedOutput);
	}

	//This method test the searStar(int startRating) method of the FundTree class
	public void testSearchStar() 
	{
		//Search for a rating that several funds match.
		String expectedOutput = this.n.searchStar(2);
		assertEquals("Funds with star rating 2: DONES FLCGX ", expectedOutput);
				
		//Search for a rating that one fund match.
		expectedOutput = this.n.searchStar(4);
		assertEquals("Funds with star rating 4: KIFAX ", expectedOutput);
		
		
		//Search for a rating that no funds match.
		expectedOutput = this.n.searchStar(5);
		assertEquals("Funds with star rating 5: none", expectedOutput);
		
		expectedOutput = this.n.searchStar(0);
		assertEquals("Invalid input... Please enter a rating between 1 and 5.", expectedOutput);
	}

	//This method test the count() method of the FundTree class
	public void testCount() 
	{
		//Count fund in an empty FundTree
		FundTree n2 = new FundTree();
		String expectedOutput = n2.count();
		assertEquals("No funds are stored", expectedOutput);
		
		//Count the funds present in a FundTree
		expectedOutput = this.n.count();
		assertEquals("Total Funds: 4", expectedOutput);
		
		//Count the funds present in a FundTree after adding a fund.
		expectedOutput = this.n.insert(f5);
		expectedOutput = this.n.count();
		assertEquals("Total Funds: 5", expectedOutput);
		
		
	}

	//This method test the list() method of the FundTree class
	public void testList() 
	{
		//List fund in an empty FundTree
		FundTree n2 = new FundTree();
		String expectedOutput = n2.list();
		assertEquals("No funds are stored", expectedOutput);
				
		//List the funds present in a FundTree
		expectedOutput = this.n.list();
		assertEquals("Current funds are: DONES FLCGX KIFAX LMOPX " , expectedOutput);
		
		//List the funds present in a FundTree after inserting a fund.
		expectedOutput = this.n.insert(f5);
		expectedOutput = this.n.list();
		assertEquals("Current funds are: DONES FLCGX KIFAX LMOPX RYMMX ", expectedOutput);
	}

}
