/** The MazeSearch class receives mazes built with 1s as walls and
 * 	0s as open spaces. It is capable of exploring them to find 
 * 	solutions from the upper left corner to the lower right corner
 *  and/or printing the maze.
 * 
 * @author Jorge Paez
 * @version 1.0 November 20, 2011
 */
public class MazeSearch 
{
	/** maze is a 2D array that holds a copy of the original receive
	 * maze*/
	private int maze[][];
	/** mazeSolution is a 2D array that is edited to create a solution
	 *  to  the maze*/
	private int mazeSolution[][];
	/** rows  is an int that holds the number of  rows in the maze*/
	private int rows;
	/** columns  is an int that holds the number of  columns in the maze*/
	private int columns;
	/** maxDepth is an int  that holds the maximum depth for each iterative deepening*/
	private int maxDepth;
	/** depthOfSolution is an int that holds the depth of the solution when founded.*/
	private int depthOfSolution;
	
	
	/**
	 * MazeSearch is a custom constructor
	 * @param mz	is a 2d array of  integers holding the maze to be solved.
	 * 				Constraint: the array have to be rectangular (or square), meaning
	 * 				all the array of the second dimension have to be the same size and 
	 * 				it cannot be an empty array.
	 * */
	public MazeSearch(int mz[][])
	{
		//get the number of rows from the number of arrays in the 1st dimension array
		this.rows = mz.length;
		//get the number of columns from the number of values in the 2nd dimension array
		this.columns = mz[0].length;;
		this.maxDepth = 1;
		this.depthOfSolution = 0;
		this.maze = new int[rows][columns];
		//instead of copying by reference the mz a helper method 
		// is used to copy values
		copyValuesOfArrays(this.maze, mz);
		this.mazeSolution = new int[rows][columns];
		copyValuesOfArrays(this.mazeSolution, mz);
	}
	
	/** setRows is a setter for the rows variable
	 * 
	 * @param r		an int value to be assigned to rows
	 */
	public void setRows(int r)
	{
		this.rows = r;
	}
	
	/** setColumns is a setter for the columns variable
	 * 
	 * @param c		an int value to be assigned to columns
	 */
	public void setColumns(int c)
	{
		this.columns = c;
	}
	
	/** setMaxDepth is a setter for the maxDepth variable
	 * 
	 * @param d		an int value to be assigned to maxDepth
	 */
	public void setMaxDepth(int d)
	{
		this.maxDepth = d;
	}
	
	/**setMaze is a setter for the maze variable. It also
	 * all the other state variables so the new maze can be 
	 * properly explored.
	 * 
	 * @param newMaze	a 2D array of integers holds a new maze to be explored
	 */
	public void setMaze(int newMaze[][])//, int r, int c)
	{
		this.setRows(newMaze.length);
		this.setColumns(newMaze[0].length);
		this.setMaxDepth(1);
		this.setDepthOfSolution(0);
		this.maze = new int[this.rows][this.columns];
		copyValuesOfArrays(this.maze, newMaze);
		this.mazeSolution = new int[this.rows][this.columns];
		copyValuesOfArrays(this.mazeSolution, newMaze);
	}
	
	/**setMaze is a setter for the maze variable. It also
	 * sets the rows and columns variable as these values depend
	 * on the size of the maze
	 * 
	 * @param solution	a 2D array of integers holds a solution to the current maze.
	 * 					Constraint: This array has to match size of the current  maze.
	 */
	public void setMazeSolution(int solution[][])
	{
		if(solution.length == this.rows && solution[0].length == this.columns)
		{
			this.mazeSolution = new int[this.rows][this.columns];
			copyValuesOfArrays(this.mazeSolution, solution);
			
			// the depth of the solution to the proper value
			setDepthOfSolution(0);
			int d = 0;
			for(int y = 0; y < this.rows; y++)
			{
				for(int x = 0; x < this.columns; x++)
				{
					if(mazeSolution[y][x] == 3)
					{
						d++;
					}
				}
			}
			setDepthOfSolution(d);
		}
		else
		{
			System.out.println("The solution of the input doesn't match the size of the current maze.");
		}
	}
	/**setDepthOfSolution setter to the depthOfSolution variable
	 * 
	 * @param d			an int value to assign to the depthOfSolution variable
	 */
	public void setDepthOfSolution(int d)
	{
		this.depthOfSolution = d;
	}
	
	/**getRows is a getter to the rows variable
	 * 
	 * @return rows		an int that holds the number of rows in the maze
	 */
	public int getRows()
	{
		return (this.rows);
	}
		
	/**getColumns is a getter to the columns variable
	 * 
	 * @return columns	an int that holds the number of columns in the maze
	 */
	public int getColumns()
	{
		return (this.columns);
	}
		
	/**getMaxDepth is a getter to the maxDepth variable
	 * 
	 * @return maxDepth	maxDepth is an int  that holds the maximum depth for each iterative deepening
	 */
	public int getMaxDepth()
	{
		return (this.maxDepth);
	}
		
	/**getMaze is a getter to the maze variable
	 * 
	 * @return maze		an int that holds the number of columns in the mazea 2D array that holds a copy of the original receive maze
	 */
	public int[][] getMaze()
	{
		return (this.maze);
	}
		
	/**getMazeSolution is a getter to the mazeSolution variable
	 * 
	 * @return mazeSolution		a 2D array that is edited to create a solution to  the maze
	 */
	public int[][] getMazeSolution()
	{
		return (this.mazeSolution);
	}
	
	/**getDepthOfSolution getter to the depthOfSolution variable
	 * 
	 * @return 			the value of depthOfSolution
	 */
	public int getDepthOfSolution()
	{
		return (this.depthOfSolution);
	}
		
	/**iterativeDeepening is a recursive method that determines if a solution was found at the 
	 * depth receive as a parameter if not it recurses by increasing the depth by 5.
	 * 
	 * @param depth		the maximum depth for the search of the solution
	 * @return 			boolean that is true if successfully found a way out of the maze or
	 * 					false otherwise
	 */
	public boolean iterativeDeepening(int depth)
	{
		this.setMaxDepth(depth);
		boolean result = mazeDepthSearch(1, 0,0);
		
		if(!result)
		{	
			System.out.println("No solution found at the depth of " + depth + ". The " +
								"depth will be increase to " + (depth+5) + ".");
			//if no solution was found at this depth reset the mazeSolution
			this.copyValuesOfArrays(this.mazeSolution, this.maze);
			//call iterativeDeepening recursively increasing the depth by 5.
			iterativeDeepening( (depth+5) );
		}
		else
		{
			System.out.println("Solution found at the  depth of " + depthOfSolution + "." );
		}
		
		
		return result;
	}
	
	/** mazeDepthSearch is private and recursive method that explore the maze 
	 * 
	 * 
	 * @param depth			an int holding the maximum depth for the search of the solution
	 * @param rowPosition	an int holding the row of the initial position of the search
	 * @param colPosition	an int holding the column of the initial position of the search
	 * @return				boolean that is true if successfully found a way out of the maze or
	 * 						false otherwise
	 */
	private boolean mazeDepthSearch(int depth, int rowPosition, int colPosition)
	{
		boolean result = false;
		this.mazeSolution[rowPosition][colPosition] = 2;
		
		//check at what depth is the search
		if(depth > this.maxDepth)
		{
			result = false;
		}
		//check if you are in the desired position at the end of the maze
		else if(rowPosition == (this.rows-1) && colPosition == (this.columns-1) )
		{
			result = true;
		}
		//check what is the next move and expect an answer from a recursive call
		else
		{
			if( checkCell(rowPosition, colPosition, 'R') )
			{
				result = mazeDepthSearch((depth+1), rowPosition, (colPosition + 1));
			}
				
			if(!result &&  checkCell(rowPosition, colPosition, 'D'))
			{
				result = mazeDepthSearch((depth+1), (rowPosition + 1), colPosition);
			}
			
			if(!result &&  checkCell(rowPosition, colPosition, 'L'))
			{
				result = mazeDepthSearch((depth+1), rowPosition, (colPosition - 1));
			}
			
			if(!result && checkCell(rowPosition, colPosition, 'U'))
			{
				result = mazeDepthSearch((depth+1), (rowPosition - 1), colPosition);
			}
		} 
		
		//Assign a 3 to the position of the correct path
		if(result)
		{
			this.mazeSolution[rowPosition][colPosition] = 3;
			depthOfSolution++;
		}
		
		return result;
	}
		
	/**checkCell is a private  method to determine whether the movement to certain adjacent
	 * position is possible and not repeated.
	 * 
	 * @param rowPosition	an int holding the row of the current position of the search
	 * @param colPosition	an int holding the column of the current position of the search
	 * @param direction		a char to determine which direction the next movement will be 
	 * 						'R' for right, 'D' for down, 'L' for left, and  'U'  for up
	 * @return				boolean that is true if the movement is possible or false otherwise
	 */ 
	private boolean checkCell(int rowPosition, int colPosition, char direction)
	{
		boolean isTheStepPosible = false;
		
		switch(direction)
		{
		
			case 'R':
				if((colPosition+1) >= this.columns)
				{
					isTheStepPosible = false;
				}
				else if(this.mazeSolution[rowPosition][(colPosition+1)] == 0)
				{
					isTheStepPosible =  true;
				}
				break;
				
			case 'D':
				if((rowPosition+1) >= this.rows)
				{
					isTheStepPosible = false;
				}
				else if(this.mazeSolution[(rowPosition+1)][colPosition] == 0)
				{
					isTheStepPosible =  true;
				}
				break;
				
			case 'L':
				if((colPosition-1) < 0)
				{
					isTheStepPosible = false;
				}
				else if(this.mazeSolution[rowPosition][(colPosition-1)] == 0)
				{
					isTheStepPosible =  true;
				}
				break;
				
			case 'U':
				if((rowPosition-1) < 0)
				{
					isTheStepPosible = false;
				}
				else if(this.mazeSolution[(rowPosition-1)][colPosition] == 0)
				{
					isTheStepPosible =  true;
				}
				break;
		}
		
		return isTheStepPosible;
	}
	
	/**printBoard is a public method that return a string with current 
	 * state of the solution of the maze so that it can be easily printed.
	 * 
	 * @return 		a string with the maze solution at its current state.
	 */
	public String printBoard()
	{
		return (printBoardR(0,0));
	}
	
	/**printBoardR private and recursive method that prints the current state 
	 * of the solution of the maze
	 * 
	 * @param y  	an int holding the row of the position being added to the string
	 * @param x		an int holding the column of the position being added to the string
	 * @return		a string with the maze solution at its current state.
	 */
	private String printBoardR(int y, int x)
	{
		String board = "";
		
		if(y < this.rows)
		{
			if(x < this.columns)
			{
				board += this.mazeSolution[y][x];
				board += printBoardR(y, (x+1));
			}
			else
			{
				//end the line when the last column is reached
				board += "\n";
				board += printBoardR( (y+1), 0);
			}
		}
		
		return board;
	}
	

	/**copyValuesOfArrays is private method to copy values of array to another.
	 * 
	 * @param array1 	2D array of integers to which the values of the 
	 * 					array2 will be copied to
	 * @param array2	2D array of integers holding values that will be 
	 * 					copied to the array1 
	 */
	private void copyValuesOfArrays(int[][] array1, int[][] array2)
	{
		for(int y = 0; y < array1.length; y++)
		{
			for(int x = 0; x < array1[0].length; x++)
			{
				array1[y][x] = array2[y][x];
			}
		}
	}
}
