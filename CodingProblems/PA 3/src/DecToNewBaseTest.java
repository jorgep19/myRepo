//JORGE PAEZ
//October 2011

import junit.framework.TestCase;

public class DecToNewBaseTest extends TestCase
{
	
	//Method to test the custom constructor
	public void testDecToNewBaseTestInt()
	{
		//Tests the constructors when receiving an invalid "value"
		DecToNewBase n1 = new DecToNewBase(-1);
		assertEquals(0, n1.getValue());
		
		//Tests the boundary case for valid and invalid input
		DecToNewBase n2 = new DecToNewBase(0);
		assertEquals(0, n2.getValue());
		
		//Tests the constructors when receiving a valid "value"
		DecToNewBase n3 = new DecToNewBase(13);
		assertEquals(13, n3.getValue());
	}

	//Method to test the decToBaseTwo() method of the DecToNewBase class.
	public void testDecToBaseTwo() 
	{
		DecToNewBase n1 = new DecToNewBase(0);
		//0 tests how the method behave when it doesn't perform recursive calls.
		assertEquals("0", n1.decToBaseTwo());
		
		//Tests when the method uses only the reminder of the first division
		n1.setValue(1);
		assertEquals("1", n1.decToBaseTwo());
		
		//This tests the special case when the value and the base are the same number which should return "10"
		n1.setValue(2);
		assertEquals("10", n1.decToBaseTwo());
		
		//Tests the output of the method for value that require it to make recursive calls
		n1.setValue(13);
		assertEquals("1101", n1.decToBaseTwo());
	}
	
	//Method to test the decToBaseThree() method of the DecToNewBase class.
	public void testDecToBaseThree() 
	{
		DecToNewBase n1 = new DecToNewBase(0);
		//0 tests how the method behave when it doesn't perform recursive calls.
		assertEquals("0", n1.decToBaseThree());
		
		//Tests when  the method uses only the reminder of the first division
		n1.setValue(2);
		assertEquals("2", n1.decToBaseThree());
		
		//This tests the special case when the value and the base are the same number which should return "10"
		n1.setValue(3);
		assertEquals("10", n1.decToBaseThree());
		
		//Tests the output of the method for value that require it to make recursive calls
		n1.setValue(13);
		assertEquals("111", n1.decToBaseThree());
	}

	//Method to test the decToBaseFive() method of the DecToNewBase class.
	public void testDecToBaseFive() 
	{
		DecToNewBase n1 = new DecToNewBase(0);
		//0 tests how the method behave when it doesn't perform recursive calls.
		assertEquals("0", n1.decToBaseFive());
		
		//Tests when the method uses only the reminder of the first division
		n1.setValue(4);
		assertEquals("4", n1.decToBaseFive());
		
		//This tests the special case when the value and the base are the same number which should return "10"
		n1.setValue(5);
		assertEquals("10", n1.decToBaseFive());
		
		//Tests the output of the method for value that require it to make recursive calls
		n1.setValue(13);
		assertEquals("23", n1.decToBaseFive());
	}

	//Method to test the decToBaseEight() method of the DecToNewBase class.
	public void testDecToBaseEight() 
	{
		DecToNewBase n1 = new DecToNewBase(0);
		//0 tests how the method behave when it doesn't perform recursive calls.
		assertEquals("0", n1.decToBaseEight());
		
		//Tests when the method uses only the reminder of the first division
		n1.setValue(7);
		assertEquals("7", n1.decToBaseEight());
		
		//This tests the special case when the value and the base are the same number which should return "10"
		n1.setValue(8);
		assertEquals("10", n1.decToBaseEight());
		
		//Tests the output of the method for value that require it to make recursive calls
		n1.setValue(13);
		assertEquals("15", n1.decToBaseEight());
	}

	//Method to tests the decToBaseNine() method of the DecToNewBase class.
	public void testDecToBaseNine() 
	{
		DecToNewBase n1 = new DecToNewBase(0);
		//0 tests how the method behave when it doesn't perform recursive calls.
		assertEquals("0", n1.decToBaseNine());
		
		//Tests when  the method uses only the reminder of the first division
		n1.setValue(8);
		assertEquals("8", n1.decToBaseNine());
		
		//This tests the special case when the value and the base are the same number which should return "10"
		n1.setValue(9);
		assertEquals("10", n1.decToBaseNine());
		
		//Tests the output of the method for value that require it to make recursive calls
		n1.setValue(13);
		assertEquals("14", n1.decToBaseNine());
	}

	//Method to test the decToBaseTwelve() method of the DecToNewBase class.
	public void testDecToBaseTwelve() 
	{
		DecToNewBase n1 = new DecToNewBase(0);
		//0 tests how the method behave when it doesn't perform recursive calls.
		assertEquals("0", n1.decToBaseTwelve());
		
		//Tests when  the method uses only the reminder of the first division
		//Also when the method returns a String with no numbers.
		n1.setValue(11);
		assertEquals("B", n1.decToBaseTwelve());
		
		//This tests the special case when the value and the base are the same number which should return "10"
		n1.setValue(12);
		assertEquals("10", n1.decToBaseTwelve());
		
		//This tests the method return a string without numbers
		n1.setValue(13);
		assertEquals("11", n1.decToBaseTwelve());
		
		//This tests the method return a string that combines letters and numbers
		n1.setValue(22);
		assertEquals("1A", n1.decToBaseTwelve());
	}

	//Method to test the decToBaseSixteen() method of the DecToNewBase class.
	public void testDecToBaseSixteen() 
	{
		DecToNewBase n1 = new DecToNewBase(0);
		//0 tests how the method behave when it doesn't perform recursive calls.
		assertEquals("0", n1.decToBaseSixteen());
		
		//This tests the method when is expected to return a string without numbers
		n1.setValue(13);
		assertEquals("D", n1.decToBaseSixteen());
		
		//Tests when  the method uses only the reminder of the first division
		n1.setValue(15);
		assertEquals("F", n1.decToBaseSixteen());
		
		//This tests the special case when the value and the base are the same number which should return "10"
		n1.setValue(16);
		assertEquals("10", n1.decToBaseSixteen());
		
		//This tests the method return a string without letters
		n1.setValue(25);
		assertEquals("19", n1.decToBaseSixteen());
		
		//This tests the method return a string that combines letters and numbers
		n1.setValue(28);
		assertEquals("1C", n1.decToBaseSixteen());
	}

	//Method to test the decToBaseN() method of the DecToNewBase class.
	public void testDecToN() 
	{
		//The default constructor set the "value" to 13
		DecToNewBase n1 = new DecToNewBase();
		//Tests converting the "value" of 13 to several numeric systems
		assertEquals("1101", n1.decToN(2));
		assertEquals("111", n1.decToN(3));
		assertEquals("23", n1.decToN(5));
		assertEquals("15", n1.decToN(8));
		assertEquals("14", n1.decToN(9));
		assertEquals("11", n1.decToN(12));
		assertEquals("D", n1.decToN(16));
		
		//This tests the upper boundary for valid values for "base
		n1.setValue(0);
		assertEquals("Invalid input, please entry a base between 2 and 36 (including 2 and 36).", n1.decToN(37));
		
		//This tests the lower boundary for valid values for "base"
		n1.setValue(0);
		assertEquals("Invalid input, please entry a base between 2 and 36 (including 2 and 36).", n1.decToN(1));
		
		//The value of 71 tests the method behavior when uses characters and numbers on the returning string
		n1.setValue(71);
		assertEquals("1Z", n1.decToN(36));
		
		//This test the method when it return a string without numbers
		n1.setValue(35);
		assertEquals("Z", n1.decToN(36));	
		
		//This test the special case when the value and the base are the same number which returns 
		//"10" in any numeric system
		n1.setValue(20);
		assertEquals("10", n1.decToN(20));
	}


	public void testToStringInt() 
	{
		//Tests the method when it receives a valid "base"
		DecToNewBase n1 = new DecToNewBase();
		assertEquals("Decimal 13 = 1101 base 2", n1.toString(2));
		
		//Tests the method when receives an invalid "base"
		assertEquals("Invalid input, please entry a base between 2 and 36 (including 2 and 36).", n1.decToN(1));
	}

}
