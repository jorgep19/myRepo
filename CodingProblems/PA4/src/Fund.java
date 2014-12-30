//Jorge Paez
//11-6-11

public class Fund 
{
	private String ticker; 
	private double currentValue;
	private double oneYearReturn;
	private double threeYearReturn;
	private String threeYearRiskVsCategory;
	private String threeYearReturnVsCategory;
	private int rating;
	
	private Fund leftChild;
	private Fund rightChild;
	
	public Fund()
	{
	}
	
	public Fund(String tick, double cValue,double oneYReturn, double threeYreturn, String threeYRisk, String threeYReturn, int rating)
	{
		this.ticker = tick; 
		this.currentValue=cValue;
		this.oneYearReturn = oneYReturn;
		this.threeYearReturn = threeYreturn;
		this.threeYearRiskVsCategory = threeYRisk;
		this.threeYearReturnVsCategory = threeYReturn;
		this.rating = rating;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	public void setTicker(String  tick)
	{
		this.ticker = tick;
	}
	
	public void setCurrentValue(double cValue)
	{
		this.currentValue = cValue;
	}
	
	public void setOneYearReturn(double oneYReturn)
	{
		this.oneYearReturn = oneYReturn;
	}
	
	public void setThreeYearReturn(double threeYreturn)
	{
		this.threeYearReturn = threeYreturn;
	}
	
	public void setThreeYearRiskVsCate(String threeYRisk)
	{
		this.threeYearRiskVsCategory = threeYRisk;
	}
	
	public void setThreeYearReturnVsCategory(String threeYReturn)
	{
		this.threeYearReturnVsCategory = threeYReturn;
	}
	
	public void setRating(int rating)
	{
		this.rating = rating;
	}
	
	public void setLeftChild(Fund child)
	{
		this.leftChild = child;
	}
	
	public void setRightChild(Fund child)
	{
		this.rightChild = child;
	}
	
	public String getTicker()
	{
		return (this.ticker);
	}
	
	public double getCurrentValue()
	{
		return (this.currentValue);
	}
	
	public double getOneYearReturn()
	{
		return (this.oneYearReturn);
	}
	
	public double setThreeYearReturn()
	{
		return (this.threeYearReturn);
	}
	
	public String setThreeYearRiskVsCate()
	{
		return (this.threeYearRiskVsCategory);
	}
	
	public String setThreeYearReturnVsCategory()
	{
		return (this.threeYearReturnVsCategory);
	}
	
	public int getRating()
	{
		return (this.rating);
	}
	
	public Fund getLeftChild()
	{
		return (this.leftChild);
	}
	
	public Fund getRightChild()
	{
		return (this.rightChild);
	}
	
	//overrides the toString() method of the Object class so that it shows all the information of the
	//current Fund
	public String toString()
	{
		String fundInfo;
		
		fundInfo = "Fund:" + this.ticker + ", current value: " + this.currentValue;
		fundInfo += ", 1 year return: " + this.oneYearReturn + ", 3 year return: " + this.threeYearReturn;
		fundInfo += ", Risk vs. category: " + this.threeYearRiskVsCategory + ", Return vs. Category: ";
		fundInfo += this.threeYearReturnVsCategory + ", Star rating: " + this.rating;
		
		return fundInfo;
	}
	

}
