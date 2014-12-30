//JORGE PAEZ
//October 2011

public class DecToNewBase 
{
	
	private int value;
	
	//Default constructor that sets "value" to 13.
	public DecToNewBase()
	{
		this.value = 13;
	}

	//Default constructor that sets "value" to 13.
	public DecToNewBase(int val)
	{
		if(val >= 0)
		{
			this.value = val;
		}
		else
		{
			this.value = 0;
			System.out.println("Invalid input, the value has to be greater or equal to zero.");
			System.out.println("The value of this object is equal to 0.");
		}
	}
	
	//Setter method recieves an integer and assigns this number to "value."
	public void setValue(int val)
	{
		this.value = val;
	}
	
	//Getter method that returns "value."
	public int getValue()
	{
		return this.value;
	}
	
	//This method returns a string with the "value" of the current instance
	//written in binary form.
	public String decToBaseTwo()
	{

		final int  TWO = 2;
		
		String valueToTwo = "";
		int reminder;
		
		if((this.value/TWO)!=0)
		{
			
			reminder = this.value%TWO;
			DecToNewBase n = new DecToNewBase(this.value/TWO);
			valueToTwo += n.decToBaseTwo() + reminder;
			
		}
		else
		{
			valueToTwo += (this.value%TWO);
		}
		
		return valueToTwo;
		
	}
	
	//This method returns a string with the "value" of the current instance 
	//written in number-system-based-three form.
	public String decToBaseThree()
	{

		final int THREE = 3;
		
		String valueToThree = "";
		int reminder;
		
		if((this.value/THREE)!=0)
		{
			
			reminder = this.value%THREE;
			DecToNewBase n = new DecToNewBase(this.value/THREE);
			valueToThree += n.decToBaseThree() + reminder;
			
		}
		else
		{
			valueToThree += (this.value%THREE);
		}
		
		return valueToThree;
		
	}
	
	//This method returns a string with the "value" of the current instance 
	//written in number-system-based-five form.
	public String decToBaseFive()
	{

		final int FIVE = 5;
		
		String valueToFive = "";
		int reminder;
		
		if((this.value/FIVE)!=0)
		{
			
			reminder = this.value%FIVE;
			DecToNewBase n = new DecToNewBase(this.value/FIVE);
			valueToFive += n.decToBaseFive() + reminder;
			
		}
		else
		{
			valueToFive += (this.value%FIVE);
		}
		
		return valueToFive;
		
	}
	
	//This method returns a string with the "value" of the current instance 
	//written in octal form.
	public String decToBaseEight()
	{

		final int EIGHT = 8;
		
		String valueToEight = "";
		int reminder;
		
		if((this.value/EIGHT)!=0)
		{
			
			reminder = this.value%EIGHT;
			DecToNewBase n = new DecToNewBase(this.value/EIGHT);
			valueToEight += n.decToBaseEight() + reminder;
			
		}
		else
		{
			valueToEight += (this.value%EIGHT);
		}
		
		return valueToEight;
		
	}
	
	//This method returns a string with the "value" of the current instance 
	//written in number-system-based-nine form.
	public String decToBaseNine()
	{
		final int NINE = 9;
		
		String valueToN = "";
		int reminder;
		
		if((this.value/NINE)!=0)
		{
			
			reminder = this.value%NINE;
			DecToNewBase n = new DecToNewBase(this.value/NINE);
			valueToN += n.decToBaseNine() + reminder;
			
		}
		else
		{
			valueToN += (this.value%NINE);
		}
		
		return valueToN;
		
	}
	
	//This method returns a string with the "value" of the current instance 
	//written in number-system-based-twelve form.
	public String decToBaseTwelve()
	{	
		final int TWELVE = 12;
		
		String validCharacters = "0123456789AB";
		String valueToTwelve = "";
		int reminder;
		
		if((this.value/TWELVE)!=0)
		{
			
			reminder = this.value%TWELVE;
			DecToNewBase n = new DecToNewBase(this.value/TWELVE);
			valueToTwelve += n.decToBaseTwelve() + validCharacters.charAt(reminder);
			
		}
		else
		{
			valueToTwelve += validCharacters.charAt(this.value%TWELVE);
		}
		
		return valueToTwelve;
	}
	
	//This method returns a string with the "value" of the current instance 
	//written in hexadecimal form.
	public String decToBaseSixteen()
	{	
		final int SIXTEEN = 16;
		
		String validCharacters = "0123456789ABCDEF";
		String valueToSixteen = "";
		int reminder;
		
		if((this.value/SIXTEEN)!=0)
		{
			
			reminder = this.value%SIXTEEN;
			DecToNewBase n = new DecToNewBase(this.value/SIXTEEN);
			valueToSixteen += n.decToBaseSixteen() + validCharacters.charAt(reminder);
			
		}
		else
		{
			valueToSixteen += validCharacters.charAt(this.value%SIXTEEN);
		}
		
		return valueToSixteen;
	}
	
	
	//This method receives and integer "base" and returns a string with the
	//"value" of the current instance  written in number-system-based-"base" form.
	public String decToN(int base)
	{	
		String validCharacters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String valueToN = "";
		int reminder;
		
		if(base >= 2 && base <=36)
		{
			if((this.value/base)!=0)
			{
				
				reminder = this.value%base;
				DecToNewBase n = new DecToNewBase(this.value/base);
				valueToN += n.decToN(base) + validCharacters.charAt(reminder);
				
			}
			else
			{
				valueToN += validCharacters.charAt(this.value%base);
			}
		}
		else
		{
			valueToN = "Invalid input, please entry a base between 2 and 36 (including 2 and 36).";
		}
		
		return valueToN;
	}
	
	//This method receives an integer "base" and returns a string of the form
	// Decimal "value" = "number converted  to another number system" base "base."
	// Example: Decimal 13 = 1101 base 2.
	public String toString(int base)
	{
		String stringForm;
		
		switch(base)
		{
			case 2:
				stringForm = "Decimal " + this.value + " = " + decToBaseTwo() + " base " + base;
				break;
				
			case 3:
				stringForm = "Decimal " + this.value + " = " + decToBaseThree() + " base " + base; 
				break;
			
			case 5:
				stringForm = "Decimal " + this.value + " = " + decToBaseFive() + " base " + base;
				break;
				
			case 8:
				stringForm = "Decimal " + this.value + " = " + decToBaseEight() + " base " + base;
				break;
				
			case 9:
				stringForm = "Decimal " + this.value + " = " + decToBaseNine() + " base " + base;
				break;
			
			case 12:
				stringForm = "Decimal " + this.value + " = " + decToBaseTwelve() + " base " + base;
				break;
				
			case 16:
				stringForm = "Decimal " + this.value + " = " + decToBaseSixteen() + " base " + base;
				break;
			default:
				if(base >= 2 && base <=36)
				{
					stringForm = "Decimal " + this.value + " = " + decToN(base) + " base " + base;
				}
				else 
				{
					stringForm =decToN(base);
				}
				break;
		}
		
		return stringForm;
		
	}
}
	
