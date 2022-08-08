public class Coffee extends Beverage
{
	private final double extraCoffeeShot = 0.50;
	private final double extraCoffeeSyrup = 0.50;
	private final boolean extraShot;
	private final boolean extraSyrup;
	
	public Coffee(String name, SIZE size, boolean shot, boolean syrup)
	{
		super(name, TYPE.COFFEE, size);
		this.extraShot = shot;
		this.extraSyrup = syrup;
	}

	@Override
	public String toString()
	{
		String str = "Beverage Name: " + this.getBevName() + "\n";
		str += "Beverage Type: " + this.getType() + "\n";
		str += "Beverage Size: " + this.getSize() + "\n";
		if(extraShot == true)
		{
			str += "\nExtra shot.";
		}
		if(extraSyrup == true)
		{
			str += "\nExtra syrup.";
		}
		else
		{
			str += "\nNo extras.";
		}
		str += "Beverage Price: " + this.calcPrice();
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
		
		if(extraShot == true)
		{
			price += extraCoffeeShot;
		}
		if(extraSyrup == true)
		{
			price += extraCoffeeSyrup;
		}
		return price;
	}
	
	@Override
	public boolean equals(Beverage obj)
	{
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

	public boolean getExtraShot()
	{
		return this.extraShot;
	}
	public boolean getExtraSyrup()
	{
		return this.extraSyrup;
	}
}