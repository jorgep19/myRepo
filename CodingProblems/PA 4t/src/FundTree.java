//Jorge Paez
//11-8-11

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

	//This method uses the boolean coming from the insert(Fund,Fund) method to return
	//a messsage with the result of the insertion. 
	public String insert(Fund newFund)
	{
		String result;
		
		if(insert(newFund, root) )
		{
			result = "Fund inserted: " + newFund.getTicker();
		}
		else
		{
			result = "Fund: " + newFund.getTicker() + " is already stored";
		}
		
		return result;
	}
	

	//This recursive method receives two Fund object and uses recursive calls to determine
	//where in the tree the newFund should be inserted. If the newFund duplicates the one 
	//that is already stored in the tree it doesn't insert the newFund in  the tree and
	//returns false.
	private boolean insert(Fund newFund, Fund currentNode)
	{
		boolean ifInserted = true;
		
		if(this.root == null)
		{
			this.root = newFund;
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
				}
				else
				{
					ifInserted = insert(newFund,currentNode.getRightChild()); 
				}
			}
		}
		
		return ifInserted;
	}
	
	//This methods returns the String coming from the method searchTick(String, Fund)
	public String searchTick(String tick)
	{
		return (searchTick(tick, root));
	}
	
	//This recursive method receives String and a Fund and uses the structure of the tree 
	//to search for the String coming from the toString() method of the Fund that matches 
	//the inputed ticker by recursive calls. If it doesn't find a Fund that matches the 
	//input it returns a  message informing that  this was the result of the search.
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
	
	
	//this method receives an int and uses list coming from the searchStar(int, Fund) method to return
	//a message with tell the user all the funds that match this criteria. I checks that the inputed
	//rating is between 1 and  5 if it is not it return an error message.
	public String searchStar(int starRating)
	{
		String list;
		
		if(starRating >= 1 && starRating <= 5)
		{
			list = searchStar(starRating, root);
			
			if(list.equals("") )
			{
				list= "Funds with star rating " + starRating + ": none";
			}
			else
			{
				list= "Funds with star rating " + starRating + ": " + list;
			}
		}
		else
		{
			list ="Invalid input... Please enter a rating between 1 and 5.";
		}
		
		return list;
	}
	
	//This recursive method receives an integer rating and a Fund to transverse in-order the tree
	//to create an alphabetical list of the ticker of all the funds in the tree that match that rating.
	private String searchStar(int starRating, Fund currentNode)
	{
		String searchResult = "";
		
		if(currentNode.getLeftChild() != null)
		{
			searchResult += searchStar(starRating, currentNode.getLeftChild());
		}
		
		if( (currentNode.getRating()) == starRating)
		{
			searchResult += currentNode.getTicker() + " ";
		}
		
		if(currentNode.getRightChild() != null)
		{
			searchResult += searchStar(starRating, currentNode.getRightChild());
		}
		
		return searchResult;
		
	}
	
	//This  method uses the list(Fund, int ) method to create a message with the number of funds
	//stored in the tree.
	public String count()
	{
		String fundsCount;
		
		if(this.root == null)
		{
			fundsCount = "No funds are stored";
		}
		else
		{
			fundsCount = "Total Funds: "  + count(root, 0);
		}
		
		return fundsCount;
	}
	
	//This recursive method receives a Fund object and a sum to calculate the total number of 
	//Funds in the tree it does it by pre-orderly transversing the tree.
	private int count(Fund currentNode, int sum)
	{
		int totalFunds = sum;
		
		totalFunds++;
		
		if(currentNode.getLeftChild() != null)
		{
			totalFunds = count(currentNode.getLeftChild(),totalFunds);
		}
		
		if(currentNode.getRightChild() != null)
		{
			totalFunds = count(currentNode.getRightChild(),totalFunds);
		}
		
		return totalFunds;
	}
	
	//This  method uses the list(Fund) method to create a message with a list of all the funds 
	//in the tree.
	public String list()

	{
		String list;
		
		if(this.root == null)
		{
			list = "No funds are stored";
		}
		else
		{
			list = list(root);
			list = "Current funds are: " + list;
		}
		
		return list;
	}
	
	
	//This recursive method receives a Fund to recursively transverse the the tree in-order
	// addting the ticker of all the Fund objects in the tree to a list (alphabetically ordered).
	private String list(Fund currentNode) 
	{
		String listOfFunds ="";
		
		if(currentNode.getLeftChild() != null)
		{
			listOfFunds += list(currentNode.getLeftChild());
		}
			
		listOfFunds += currentNode.getTicker() + " ";
	
		if(currentNode.getRightChild() != null)
		{
			listOfFunds += list(currentNode.getRightChild());
		}
		
		return listOfFunds;
	}
}
