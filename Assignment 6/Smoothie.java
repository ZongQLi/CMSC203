public class Smoothie extends Beverage
{
	private int numFruit = 0;
	private final double addProtein = 1.50;
	private final double addFruit = 0.50;
	private boolean proteinPowder;
	
	public Smoothie(String name, SIZE size, int numFruit, boolean proteinPowder)
	{
		super(name, TYPE.SMOOTHIE, size);
		this.numFruit = numFruit;
		this.proteinPowder = proteinPowder;
	}
	
	@Override
	public String toString()
	{
		String str = "Beverage Name: " + this.getBevName() + "\n";
		str += "Beverage Type: " + this.getType() + "\n";
		str += "Beverage Size: " + this.getSize() + "\n";
		if(proteinPowder == true)
		{
			str += "\nProtein Powder Added.";
		}
		else
		{
			str += "\nNo extras.";
		}
		str += "\nNumber of Fruits: " + (this.numFruit + 1);
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
		
		if(proteinPowder == true)
		{
			price += addProtein;
		}
		price += (numFruit * addFruit);
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
	
	public int getNumOfFruits()
	{
		return this.numFruit;
	}

	public boolean getAddProtein()
	{
		return this.proteinPowder;
	}
}
