/**The Memory class is a virtual set of memory addresses
 * storing values.
 * 
 * @author Jorge Paez
 *@version 1.0 December 4, 2011
 */
public class Memory 
{
	private String[] instructions;
	int capacity;
	
	/**Custom Constructor that takes a size for the memory.
	 * 
	 * @param size		an integer representing the number of 
	 * 					memory addresses.
	 */
	public Memory(int size)
	{
		this.instructions = new String[size];
		this.capacity = size;
	}
	
	/**Getter for the instructions array.
	 * 
	 * @return 		a array of String holding all the values 
	 * 				stored in memory.
	 */
	public String[] getInstructions() 
	{
		return this.instructions;
	}
	
	/**Setter for capacity.
	 * 
	 * @return 	an integer with the number of address of the curretn Memory object.
	 */
	public int getCapacity()
	{
		return  this.capacity;
	}

	//There is no setter for capacity since arrays don't have dynamic size. 

	/**Setter for the array of instructions
	 * 
	 * @param newInstructions	an array of string holding values binary 
	 * 							values. The array have to have the same 
	 * 							of the size of the Memory object.
	 * 					
	 */
	public void setInstructions(String[] newInstructions) 
	{
		if(newInstructions.length != this.instructions.length)
		{
			System.out.println("This instructions can't be hold " +
								"by this memory. Please, create a new Memory object.");
		}
		else
		{
			for(int i = 0; i < this.instructions.length; i++)
			{
				this.instructions[i] = newInstructions[i];
			}
		}
	}
	
	
	/**This method recieves an integer value representing a memory address in the 
	 * Memory object and return the content of that location.
	 * 
	 * @param location		an integer representing the memory address desired.
	 * @return				a String with the content of the desired address.
	 */
	public String read(int location)
	{
		String instruction;
		
		if(location >= 0 && location < this.capacity)
		{
			instruction = this.instructions[location];
		}
		else
		{
			instruction = "Invalid memory address.";
		}
			
		return instruction;
	}
	
	/**Takes a integer and a String to store a new "instruction" in the desired 
	 * memory address.  
	 * 
	 * @param location			an integer that shows the address that is to be changed.
	 * @param newInstruction	a String with the new binary value to be stored.
	 */
	public void store (int location, String newInstruction)
	{
		if(location >= 0 && location < this.capacity)
		{
			this.instructions[location] = newInstruction;
		}
		else
		{
			System.out.println("Invalid memory address.");
		}
	}
	
	/**This method return  a string that shows in binary all the memory 
	 * address and their values stores. 
	 * 
	 * @return 		a String that shows all the address and contents of 
	 * 				the current Memory object.
	 */
	public String toString()
	{
		String output = " Address | Contents \n";
		
		for(int i = 0; i < this.capacity; i++)
		{
			String address = Integer.toBinaryString(i);
			while(address.length() < 5)
			{
				address = "0" + address;
			}
			
			output += "  " + address + "  | " + this.instructions[i]+ "\n";
		}
		
		return output;
	}
	
}
