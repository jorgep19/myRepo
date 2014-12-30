import junit.framework.TestCase;

public class CPUTest  extends TestCase
{

	public void testCycleHaltAddM() 
	{
		//this program callhalt at the beginning
		Memory testProgram1 = new Memory(3);
		testProgram1.store(0, "00000000");
		testProgram1.store(1, "00100111");
		testProgram1.store(2, "11100111");
		
		CPU testCPU = new CPU(testProgram1);
		
		//check haltCalledbefore the action is executed
		assertEquals(false, testCPU.getHaltCalled());		
		testCPU.cycle();
		//check haltCalled after the action is performed
		assertEquals(true, testCPU.getHaltCalled());	
		
		//Check the accumulator before the rest is program is executed
		assertEquals("00000000", testCPU.getAccumulator());
		assertEquals(0, testCPU.getAccumulatorDecimal());
		testCPU.executeProgramInMemory();
		//Check the accumulator after the program has been executed
		assertEquals("00000000", testCPU.getAccumulator());
		assertEquals(0, testCPU.getAccumulatorDecimal());
		
		//This program modifies the aaccumulator and then call halt
		Memory testProgram2 = new Memory(3);
		testProgram2.store(0, "10100111");
		testProgram2.store(1, "00000000");
		testProgram2.store(2, "11100111");
		
		testCPU.setMemory(testProgram2);
		
		//Check the accumulator before execution
		assertEquals("00000000", testCPU.getAccumulator());
		assertEquals(0, testCPU.getAccumulatorDecimal());
		//check accumulator after the rest of the program has  been executed
		testCPU.executeProgramInMemory();
		assertEquals("00000111", testCPU.getAccumulator());
		assertEquals(7, testCPU.getAccumulatorDecimal());
		
		
		//This program call halt at the beginning then call it again
		//it check that even the halt it call again nothing is execute
		//after the first call
		Memory testProgram3 = new Memory(4);
		testProgram3.store(0, "00000000");
		testProgram3.store(1, "10100111");
		testProgram3.store(2, "00000000");
		testProgram3.store(3, "10100111");
		
		testCPU.setMemory(testProgram3);
	
		//Check the accumulator before execution
		assertEquals("00000000", testCPU.getAccumulator());
		assertEquals(0, testCPU.getAccumulatorDecimal());
		testCPU.executeProgramInMemory();
		//check accumulator after the rest of the program has  been executed
		assertEquals("00000000", testCPU.getAccumulator());
		assertEquals(0, testCPU.getAccumulatorDecimal());
	}

	
	public void testCycleJANZStAMLdAMSubI() 
	{
		Memory testProgram1 = new Memory(6);
		testProgram1.store(0, "01100101");
		testProgram1.store(1, "11100001");
		testProgram1.store(2, "01000101");
		testProgram1.store(3, "00100000");
		testProgram1.store(4, "00000000");
		testProgram1.store(5, "00000010");
		
		CPU testCPU = new CPU(testProgram1);
		
		//Check that the value in address 5 in load to the accumulator
		testCPU.cycle();
		assertEquals(2, testCPU.getAccumulatorDecimal());
		//Substract the immediate value of 1
		testCPU.cycle();
		assertEquals(1, testCPU.getAccumulatorDecimal());
		//Check that the accumulator was placed in address 5
		testCPU.cycle();
		assertEquals("00000001", testProgram1.read(5));
		//Check that since the accumulator is not 0 PC goes to the address 0
		testCPU.cycle();
		assertEquals(0, testCPU.getPCDecimal());
		
		//see that the program finishes its execution  properly
		testCPU.executeProgramInMemory();
		assertEquals("00000000", testCPU.getAccumulator());
		assertEquals(0, testCPU.getAccumulatorDecimal());
		
		
		
	}
	
	public void testCycleAddMSubM() 
	{
		Memory testProgram1 = new Memory(5);
		testProgram1.store(0, "10000011");
		testProgram1.store(1, "11000011");
		testProgram1.store(2, "00000000");
		testProgram1.store(3, "00000001");
		
		CPU testCPU = new CPU(testProgram1);
		
		//add the value in address 3
		testCPU.cycle();
		assertEquals(1, testCPU.getAccumulatorDecimal());

		//Subtract the value in address 3
		testCPU.cycle();
		assertEquals(0, testCPU.getAccumulatorDecimal());

		
		
	}

}
	