public class Alcohol extends Beverage
{
	private boolean weekEnd;
	private final double weekEndPrice = 0.60;
	
	public Alcohol(String name, SIZE size, boolean weekEnd)
	{
		super(name, TYPE.ALCOHOL, size);
		this.weekEnd = weekEnd;
	}
	
	@Override
	public String toString()
	{
		String str = "Beverage Name: " + this.getBevName() + "\n";
		str += "Beverage Type: " + this.getType() + "\n";
		str += "Beverage Size: " + this.getSize() + "\n";
		if(weekEnd == true)
		{
			str += "\nServed on Weekends.";
		}
		else
		{
			str += "\nNot Served on Weekends.";
		}
		str += "\nBeverage Price: " + this.calcPrice();
		return str;
	}
	
	@Override
	public double calcPrice()
	{
		double price = getBasePrice(); // SMALL is Base Price, i.e. 2.0.
		if(getSize() == SIZE.MEDIUM)
		{
			price += getSizeUpPrice();
		}
		else if(getSize() == SIZE.LARGE)
		{
			price += (getSizeUpPrice() * 2);
		}
		
		if(weekEnd == true)
		{
			price += weekEndPrice;
		}
		return price;
	}
	
	@Override
	public boolean equals(Beverage obj)
	{
		obj = new Alcohol(getBevName(), getSize(), weekEnd);
		boolean equal = false;
		if(super.equals(obj) && obj instanceof Beverage)
		{
			equal = true;
		}
		return equal;
	}
	
	public double getBasePrice()
	{
		return super.getBasePrice();
	}
	
	public String getBevName()
	{
		return super.getBevName();
	}
}
