//Jorge Paez
//11-6-11

public class FundTree 
{
	private Fund root;
	
	public FundTree()
	{
		root = null;
	}
	
	public FundTree(Fund r)
	{
		root = r;
	}
	
	public void setRoot(Fund r)

	{
		root = r;
	}
	
	public Fund getRoot()
	{
		return (this.root);
	}

	public void insert(Fund newFund)
	{
		if(insert(newFund, root) )
		{
			System.out.println("Fund inserted: " + newFund.getTicker() );
		}
		else
		{
			System.out.println("Unable to inserted this fund. The ticker " + newFund.getTicker() + " is already on the fund's list.");
		}
	}
	

	//This method inserts a the a new fund has to be to keep the order it uses the compareTo() method 
	//of the String class. It receives the object to be inserted and a Fund object (for recursion).
	private boolean insert(Fund newFund, Fund currentNode)
	{
		boolean ifInserted = true;
		
		if(this.root == null)
		{
			this.root = newFund;
			//TODO delete at end System.out.println(newFund.getTicker() + "is now the root");
		}
		else
		{
			String newName = newFund.getTicker();
			String currentNodeName = currentNode.getTicker();
			
			if(currentNodeName.compareTo(newName) == 0)
			{
				ifInserted = false;
			}
			
			else if(currentNodeName.compareTo(newName) > 0)
			{
				if(currentNode.getLeftChild() == null)
				{
					currentNode.setLeftChild(newFund);
					//TODO delete at end  System.out.println(newFund.getTicker() + " is now the left child of " + currentNode.getTicker());
				}
				else
				{
					ifInserted = insert(newFund,currentNode.getLeftChild());
				}
			}
			else
			{
				if(currentNode.getRightChild() == null)
				{
					currentNode.setRightChild(newFund);
					//TODO delete at end System.out.println(newFund.getTicker() + " is now the right child of " + currentNode.getTicker());
				}
				else
				{
					ifInserted = insert(newFund,currentNode.getRightChild()); 
				}
			}
		}
		
		return ifInserted;
	}
	
	//this method receives a String and uses the searchTick(String, Fund) method of the Fund class and it 
	//returns a string with the information of a Fund object which ticker matches the input. If there is not
	//such an object it informs the user of this.
	public String searchTick(String tick)
	{
		return (searchTick(tick, root));
	}
	
	//This recursive method returns a String with all the information of  a Fund object that has the ticker 
	//of the input. If none of the Fund objects in the tree have this ticker then it returns a message 
	//informing the user. If also receives a Fund object for recursive  purposes.
	private String searchTick(String tick, Fund currentNode)
	{
		String searchResult = "";
		
		if(currentNode == null)
		{
			searchResult = "Search for fund: " +  tick + " not found";
		}
		else
		{
			String currentNodeName = currentNode.getTicker();
			
			if(currentNodeName.compareTo(tick) == 0)
			{
				searchResult = currentNode.toString();
			}
			
			else if(currentNodeName.compareTo(tick) > 0)
			{
				searchResult = searchTick(tick,currentNode.getLeftChild());
			}
			else
			{
				searchResult = searchTick(tick,currentNode.getRightChild()); 
			}
		}
		
		return searchResult;
	}
	
	
	//this method receives an int and uses the searchStar(int, Fund) method of the Fund class to
	// return a list with all Fund objects in the tree matching that rating.
	public String searchStar(int starRating)
	{
		String list = searchStar(starRating, root);
		
		if(list.equals("") )
		{
			list= "Funds with star rating " + starRating + ": none ";
		}
		else
		{
			list= "Funds with star rating " + starRating + ": " + list;
		}
		
		return list;
	}
	
	//This method returns a String with the tickers of all the Fund objects in that tree that have 
	//the "rating" of the input. It also receives a Fund object for recursion purposes.
	private String searchStar(int starRating, Fund currentNode)
	{
		String searchResult = "";
		
		if(currentNode.getLeftChild() == null)
		{
			searchResult += "";
		}
		else
		{
			searchResult += searchStar(starRating, currentNode.getLeftChild());
		}
		
		if( (currentNode.getRating()) == starRating)
		{
			searchResult += currentNode.getTicker() + " ";
		}
		
		if(currentNode.getRightChild() == null)
		{
			searchResult += "";
		}
		else
		{
			searchResult += searchStar(starRating, currentNode.getRightChild());
		}
		
		return searchResult;
		
	}
	
	//This method uses the count(Fund, int) method of the Fund class to inform the user of how many funds are 
	//currently in the tree.
	public String count()
	{
		return ("Total Funds: "  + count(root, 0));
	}
	
	//This recursive method receives a Fund object and passes the sum to calculate and return
	//the total number of Fund objects in the three.
	private int count(Fund currentNode, int sum)
	{
		int totalFunds = sum;
		
		totalFunds++;
		//TODO delete System.out.println("Currently in " + currentNode.getTicker() + "and sum is" + totalFunds);
		
		if(currentNode.getRightChild() == null)
		{
			totalFunds += 0;
		}
		else
		{
			totalFunds = count(currentNode.getRightChild(),totalFunds);
		}
		
		if(currentNode.getLeftChild() == null)
		{
			totalFunds += 0;
		}
		else
		{
			totalFunds = count(currentNode.getLeftChild(),totalFunds);
		}
		
		return totalFunds;
	}
	
	//This  method uses the list(Fund) method of the Fund class to create a list  of all the funds in the tree.
	public String list()

	{
		String list;
		
		if(this.root == null)
		{
			list = "The are no funds on file.";
		}
		else
		{
			list = list(root, "");
			list = "Current funds are: " + list;
		}
		
		return list;
	}
	
	
	//This recursive method receives a Fund to recursively list the ticker name of all the 
	//Fund objects in the tree.
	private String list(Fund currentNode, String fundsSoFar)
	{
		String listOfFunds = fundsSoFar;
		
		//Check  the leftChild's information of the currentNode
		if(currentNode.getLeftChild() == null)
		{
			listOfFunds += "";
		}
		else
		{
			listOfFunds = list(currentNode.getLeftChild(), listOfFunds);
		}
			
		//Add the ticker of the currentNode to the list
		listOfFunds += currentNode.getTicker() + " ";
	
		//Check  the rightChild's information of the currentNode
		if(currentNode.getRightChild() == null)
		{
			listOfFunds += "";
		}
		else
		{
			listOfFunds = list(currentNode.getRightChild(), listOfFunds);
		}
		
		return listOfFunds;
	}
}
