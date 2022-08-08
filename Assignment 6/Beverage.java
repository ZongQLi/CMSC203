public abstract class Beverage
{
	private String name;
	private TYPE type;
	private SIZE size;
	private final double basePrice = 2.0;
	private final double sizeUpPrice = 1.0;
	
	public Beverage(String name, TYPE type, SIZE size)
	{
		this.name = name;
		this.type = type;
		this.size = size;
	}
		
	public abstract double calcPrice();
	
	@Override
	public String toString()
	{
		String str = "Beverage Name: " + this.getBevName() + "\n";
		str += "Beverage Type: " + this.getType() + "\n";
		str += "Beverage Size: " + this.getSize() + "\n";
		str += "Beverage Price: " + this.calcPrice();
		return str;
	}
	
	public boolean equals(Beverage bevObj)
	{
		boolean equal = false;
		
		if(this.name.equals(bevObj.getBevName())
				&& (this.type == bevObj.getType())
				&& (this.size == bevObj.getSize()))
		{
			equal = true;
		}
		return equal;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setType(TYPE type)
	{
		this.type = type;
	}
	
	public void setSize(SIZE size)
	{
		this.size = size;
	}
	
	public String getBevName()
	{
		return this.name;
	}
	
	public TYPE getType()
	{
		return this.type;
	}
	
	public SIZE getSize()
	{
		return this.size;
	}
	
	public double getBasePrice()
	{
		return basePrice;
	}
	
	public double getSizeUpPrice()
	{
		return sizeUpPrice;
	}
}
