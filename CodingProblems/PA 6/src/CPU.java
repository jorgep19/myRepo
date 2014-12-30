/**The CPU class emulates the behavior of CPU when reading instructions
 * from a memory and executing them.
 * 
 * @author Jorge Paez
 *@version 1.0 December 4, 2011
 */
public class CPU 
{
	private String instRegister;
	private String higherLangInstruction;
	private String PC;
	private int PCDecimal;
	private String accumulator;
	private int accumulatorDecimal;
	private Memory memory;
	private boolean haltCalled;
	
	/**The default constructor
	 * 
	 */
	public CPU()
	{
		this.instRegister = "";
		this.higherLangInstruction = "";
		this.PC = "";
		this.PCDecimal = 0;
		this.accumulator = "";
		this.accumulatorDecimal = 0;
		this.memory =  null;
		this.haltCalled = false;
	}
	
	/**A custom constructor that allows the user to set a program 
	 * to the memory
	 * 
	 * @param program	a Memory object that hold the instructions 
	 *					to be executed.
	 */
	public CPU(Memory program)
	{
		this.instRegister = "";
		this.higherLangInstruction = "";
		this.PC = "";
		this.PCDecimal = 0;
		this.accumulator = "00000000";
		this.accumulatorDecimal = 0;
		this.memory =  program;
		this.haltCalled = false;
	}
	
	/**getter for the instRegister
	 * 
	 * @return 	a String with the current value of 
	 * 			the insRegister
	 */
	public String getInstRegister()
	{
		return (this.instRegister);
	}
	
	/**getter for the higherLangInstruction
	 * 
	 * @return 	a String with the current value of 
	 * 			the higherLangInstruction
	 */
	public String getHigherLangInstruction()
	{
		return (this.higherLangInstruction);
	}
	
	/**getter for the PC
	 * 
	 * @return 	a String with the current value of 
	 * 			the PC
	 */
	public String getPC()
	{
		return (this.PC);
	}
	
	/**getter for the PCDecimal
	 * 
	 * @return 	an integer with the current value of 
	 * 			the PCDecimal
	 */
	public int getPCDecimal()
	{
		return (this.PCDecimal);
	}
	
	/**getter for the accumulator
	 * 
	 * @return 	a String with the current value of 
	 * 			the accumulator
	 */
	public String getAccumulator()
	{
		return (this.accumulator);
	}
	
	/**getter for the accumulatorDecimal
	 * 
	 * @return 	an integer with the current value of 
	 * 			the accumulatorDecimal
	 */
	public int getAccumulatorDecimal()
	{
		return (this.accumulatorDecimal);
	}
	
	/**getter for the memory
	 * 
	 * @return 	aMemory object with the current value of 
	 * 			the memory
	 */
	public Memory getMemory()
	{
		return (this.memory);
	}
	
	/**getter for the haltCalled
	 * 
	 * @return 	an boolean with the current value of 
	 * 			the haltCalled
	 */
	public boolean getHaltCalled()
	{
		return (this.haltCalled);
	}
	
	
	/**setter for instRegister
	 * 
	 * @param newInst	a String with a new desired value 
	 * 					for instRegister
	 */
	public void setInstRegister(String newInst)
	{
		this.instRegister = newInst;
	}
	
	/**setter for higherLangInstruction
	 * 
	 * @param newInst	a String with a new desired value 
	 * 					for higherLangInstruction
	 */
	public void setHigherLangInstruction(String newInst)
	{
		this.higherLangInstruction = newInst;
	}
	
	/**setter for PC
	 * 
	 * @param newPC		a String with a new desired value 
	 * 					for PC
	 */
	public void setPC(String newPC)
	{
		this.PC = newPC;
	}
	
	/**setter for PCDecimal
	 * 
	 * @param newPC		an integer with a new desired value 
	 * 					for PCDecimal
	 */
	public void setPCDecimal(int newPC)
	{
		this.PCDecimal = newPC;
	}
	
	/**setter for accumulator
	 * 
	 * @param newAccum	an String with a new desired value 
	 * 					for accumulator
	 */
	public void setAccumulator(String newAccum)
	{
		this.accumulator = newAccum;
	}
	
	/**setter for accumulatorDecimal
	 * 
	 * @param newAccum	an integer with a new desired value 
	 * 					for accumulatorDecimal
	 */
	public void setAccumulatorDecimal(int newAccum)
	{
		this.accumulatorDecimal = newAccum;
	}
	
	/**setter for memory
	 * 
	 * @param newPC		a Memory object with a new desired value 
	 * 					for memory
	 */
	public void setMemory(Memory newMemory)
	{
		this.instRegister = "";
		this.higherLangInstruction = "";
		this.PC = "";
		this.PCDecimal = 0;
		this.accumulator = "00000000";
		this.accumulatorDecimal = 0;
		this.memory =  newMemory;
		this.haltCalled = false;
	}
	
	/**setter for haltCalled
	 * 
	 * @param call		a boolean with a new desired value 
	 * 					for haltCalled
	 */
	public void setHaltCalled(boolean call)
	{
		this.haltCalled = call;
	}
	
	/**This a method that simulates an execution cycle of the CPU.
	 */
	public void cycle()
	{
		
		//PC take the  first part of the OPcodeto  determine which location are we on  
		instRegister = this.memory.read(PCDecimal);
		
		//The instRegister is splited into the OPCode and its argument
		int OPCode = Integer.parseInt(instRegister.substring(0, 3), 2);			
		int argument  = Integer.parseInt(instRegister.substring(3),2);
		this.higherLangInstruction = instRToHigherLang(OPCode, argument);
		System.out.println(cycleToString() );
		
		//PC is incremented 
		PCDecimal++; 
		this.PC = Integer.toBinaryString(PCDecimal); 
		
		//action performed
		if(!haltCalled)
		{
			switch(OPCode)
			{
				case 0:
					halt();
					break;
				
				case 1:
					janz(argument);
					break;
					
				case 2:
					stam(argument);
					break;
					
				case 3:
					ldam(argument);
					break;
					
				case 4:
					addm(argument);
					break;
					
				case 5:
					addi(argument);
					break;
					
				case 6:
					subm(argument);
					break;
					
				case 7:
					subi(argument);
					break;
					
				default:
					System.out.println("Invalid OPCode.");
					break;
			}
		}
		
	}
	/**This method simulates the execution of the halt instruction, 
	 * which makes the CPU execute no more instructions
	 */
	private void halt()
	{
		this.haltCalled = true;
	}
	
	/**This method simulates the execution of the JANZ instruction, 
	 * which takes a memory address to which the PC will jump if the accumulator 
	 * is not equal to zero (0).
	 * 
	 * @param argument 	a memory address to move the PC when the accumulator 
	 * 					is not zero.
	 */
	private void janz(int argument)
	{
		if(this.accumulatorDecimal != 0)
		{
			this.PCDecimal = argument;
			this.PC = Integer.toBinaryString(PCDecimal);
		}
	}
	
	/**This method simulates the execution of the StAM instruction, 
	 * which takes a memory address where the current value of  the accumulator
	 * will be stored. 
	 * 
	 * @param argument	a memory address for storing the accumulator
	 */
	private void stam(int argument)
	{
		this.memory.store(argument, this.accumulator);
	}
	
	/**This method simulates the execution of the LdAM instruction, 
	 * which takes a memory address in order to load its content to set it as 
	 * a the new value for the accumulator. 
	 * 
	 * @param argument  a memory address to load a value for the accumulator
	 */
	private void ldam(int argument)
	{
		this.accumulator = this.memory.read(argument);
		this.accumulatorDecimal = Integer.parseInt(accumulator, 2);
	}
	
	/**This method simulates  the execution of the AddM instruction,
	 * which takes a memory address to read its value and add it to the 
	 * accumulator. 
	 * 
	 * @param argument 	a memory address to read the value from
	 */
	private void addm(int argument)
	{
		int valueToBeAdded = Integer.parseInt(this.memory.read(argument), 2);	
		this.accumulatorDecimal +=  valueToBeAdded;
		this.accumulator = Integer.toBinaryString(accumulatorDecimal);
	}
	
	/**This method simulates the execution of the AddI instruction,
	 * which takes a value and add it to the accumulator.
	 * 
	 * @param argument		a binary value to be added to the accumulator 
	 */
	private void addi(int argument)
	{
		this.accumulatorDecimal +=  argument;
		this.accumulator = Integer.toBinaryString(accumulatorDecimal);
	}
	
	/**This method simulates the execution of the SubM instructions,
	 * which takes a memory address reads its value and substract that value 
	 * from the accumulator.
	 * 
	 * @param argument		a memory address to read the value from
	 */
	private void subm(int argument)
	{
		int valueToBeSubtracted = Integer.parseInt(this.memory.read(argument), 2);	
		this.accumulatorDecimal -=  valueToBeSubtracted;
		this.accumulator = Integer.toBinaryString(accumulatorDecimal);
	}

	/**this method simulates the execution of the SubI instruction,
	 * which takes a value and subtract it from the accumulator.
	 * 
	 * @param argument 		a value to subtract from  the accumulator.
	 */	
	private void subi(int argument)
	{
		this.accumulatorDecimal -=  argument;
		this.accumulator = Integer.toBinaryString(accumulatorDecimal);
	}
	
	/**This method print out current step being  performed by the CPU
	 * 
	 * @return 	a String with showing the action performed this cycle.
	 */
	private String cycleToString()
	{
		while(this.PC.length() < 5)
		{
			this.PC = "0" + this.PC;
		}
		
		while(this.accumulator.length() < 8)
		{
			this.accumulator = "0" + this.accumulator;
		}
		
		String output = this.PC + " | " + this.higherLangInstruction + " |  " + this.accumulator;
		
		return output;
	}
	
	/**This method returns a string with that shows all the memory address
	 * and its content.
	 * 
	 * @return 	a String showing all the values stored currently stored 
	 * 			in memory.
	 */
	public String memoryToString()
	{
		return (this.memory.toString() );
	}
	
	/**This method returns an integer that shows the number of addresses in 
	 * the CPU's memory.
	 * 
	 * @return  an integer with the number of memory address
	 */
	public int getMemoryCapacity()
	{
		return  (this.memory.getCapacity() );
	}
	
	/**This method takes integers representing the OPCode and argument
	 * collected from the current memory address and return a string show 
	 * the instruction in a more readable form. 
	 * 
	 * @param OPCode		an integer that determines which instruction 
	 * 						will be executed.
	 * @param argument		an integer representing the argument the argument
	 * 						use to perform the instruction.
	 *  
	 * @return				a String with a more readable form of the 
	 * 						instruction to be performed.
	 */
	private String instRToHigherLang(int OPCode, int argument)
	{
		String instruction = " ";
		switch(OPCode)
		{
			case 0:
				instruction = "  Halt " + argument;
				break;
			
			case 1:
				instruction = "  JANZ " + argument;
				break;
				
			case 2:
				instruction = "  StAM " + argument;
				break;
				
			case 3:
				instruction = "  LdAM " + argument;
				break;
				
			case 4:
				instruction = "  AddM " + argument;
				break;
				
			case 5:
				instruction = "  AddI " + argument;
				break;
				
			case 6:
				instruction = "  SubM " + argument;
				break;
				
			case 7:
				instruction = "  SubI " + argument;
				break;
				
			default:
				System.out.println("Invalid OPCode.");
				break;
		}
		
		while(instruction.length() < 11)
		{
			instruction += " ";
		}
		return instruction;
	}
	
	public void executeProgramInMemory()
	{
		do
		{
			this.cycle();
			
		}while(this.PCDecimal < this.getMemoryCapacity());
	}
	
	public static void main(String[] args)
	{
		Memory myProgram = new Memory(32);
		
		myProgram.store(0, "01101011");
		myProgram.store(1, "10001101");
		myProgram.store(2, "01001011");
		myProgram.store(3, "01100001");
		myProgram.store(4, "10100001");
		myProgram.store(5, "01000001");
		myProgram.store(6, "01101100");
		myProgram.store(7, "11100001");
		myProgram.store(8, "01001100");
		myProgram.store(9, "00100000");
		myProgram.store(10, "00000000");
		myProgram.store(11, "00000000");
		myProgram.store(12, "00000011");
		myProgram.store(13, "00000010");
		myProgram.store(14, "00000100");
		myProgram.store(15, "00000101");
		myProgram.store(16, "00000000");
		myProgram.store(17, "00000000");
		myProgram.store(18, "00000000");
		myProgram.store(19, "00000000");
		myProgram.store(20, "00000000");
		myProgram.store(21, "00000000");
		myProgram.store(22, "00000000");
		myProgram.store(23, "00000000");
		myProgram.store(24, "00000000");
		myProgram.store(25, "00000000");
		myProgram.store(26, "00000000");
		myProgram.store(27, "00000000");
		myProgram.store(28, "00000000");
		myProgram.store(29, "00000000");
		myProgram.store(30, "00000000");
		myProgram.store(31, "00000000");
		
		CPU myCPU = new CPU(myProgram);
		
		System.out.println("CPU state before execution:");
		System.out.println(myCPU.memoryToString() );
		
		System.out.println("\nExecution of the program: ");
		System.out.println("  PC  | Instruction | Accumulator");
		
		myCPU.executeProgramInMemory();
		
		System.out.println("\nCPU state after execution:");
		System.out.println(myCPU.memoryToString() );
	}
}
