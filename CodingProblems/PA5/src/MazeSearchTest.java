import junit.framework.TestCase;

public class MazeSearchTest extends TestCase
{

	public void iterativeDeepening() 
	{
		/*Test case 1: This test case checks that the search leaves a 2 in the
		 * positions visited and 3 in the correct path out of the maze.
		*/
		int maze1[][] = {{0,1,1,1},
		 		 		 {0,0,0,1},
		 		 		 {0,1,1,1},
		 		 		 {0,0,0,0}};
		
		MazeSearch mazeExplorer = new MazeSearch(maze1);
		mazeExplorer.iterativeDeepening(20);
		
		assertEquals("3111\n" +
					 "3221\n" +
					 "3111\n" +
					 "3333", mazeExplorer.printBoard() );
		
		/*Test case 2: this test case makes the search go up and down. This
		 * assures that the movements are correct and  that the search stay 
		 * in bounds. 
		 */
		int maze2[][]  = {{0,1,0,0,0},
				 		 {0,1,0,1,0},
				 		 {0,1,0,1,0},
				 		 {0,0,0,1,0}};
		
		mazeExplorer.setMaze(maze2);
		mazeExplorer.iterativeDeepening(20);
		
		assertEquals("31333\n" +
					 "31313\n" +
					 "31313\n" +
					 "33313", mazeExplorer.printBoard());
				
		/*test case 3: this test case makes the search left up and right. 
		 * This assures that the movements are correct and  that the search 
		 * stay in bounds. Also it test to see if the search leaves 0s in 
		 * the non-visited positions.
		 */
		int maze3[][] = {{0,1,0,0,0},
						{0,0,0,0,0},
						{1,1,1,1,0},
						{0,0,0,0,0},
						{0,1,1,1,1},
						{0,0,0,0,0}};
		
		mazeExplorer.setMaze(maze3);
		mazeExplorer.iterativeDeepening(20);
						
		assertEquals("31000\n" +
					 "33333\n" +
					 "11113\n" +
					 "33333\n" +
					 "31111\n" +
					 "33333", mazeExplorer.printBoard() );
		
		/*Test case 4: This test the search the search to check possible 
		*movements in order. Also that it doen'st go out of bounds and 
		*it leaves 0 in non-visited locations.
		*/
		int maze4[][] = {{0,0,0,0,0},
						{0,0,0,0,0},
						{0,0,0,0,0},
						{0,0,0,0,0}};
		
		mazeExplorer.setMaze(maze4);
		mazeExplorer.iterativeDeepening(20);
						
		assertEquals("33333\n" +
					 "00003\n" +
					 "00003\n" +
					 "00003\n", mazeExplorer.printBoard() );
		
		/*Test case 5: this test to see how the program handle a maze of 
		*certain complexity. Staying in bound using the proper depth and 
		*leaving the expected values in all positions.
		*/
		int maze5[][] =  {{0,0,0,1,0,1,0,0,0,0},
				 		 {1,1,0,1,0,0,0,1,0,0},
				 		 {0,0,0,1,0,0,1,1,0,0},
				 		 {0,1,0,1,1,0,0,1,1,0},
				 		 {0,1,0,1,1,0,0,0,1,0},
				 		 {0,1,1,1,1,1,0,1,0,0},
				 		 {0,0,0,0,0,0,0,1,1,0}};
				 		 
		mazeExplorer.setMaze(maze5);
		mazeExplorer.iterativeDeepening(20);
		
		assertEquals("3331013333\n" +
					 "1131333103\n" +
					 "3331331103\n" +
					 "3121132113\n" +
					 "3121133213\n" +
					 "3111113103\n" +
					 "3333333113", mazeExplorer.printBoard() );
		
		/*Test case 6: this test case check the limit case of the smallest 
		*valid maze.
		*/
		int maze6[][] = {{0}};
		
		mazeExplorer.setMaze(maze6);
		mazeExplorer.iterativeDeepening(1);
		
		assertEquals("3", mazeExplorer.printBoard() );
	}
}
