import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface
{
	private int orderNum;
	private int orderTime;
	private DAY orderDay;
	private Customer orderCustomer;
	ArrayList<Beverage> bevList;
	

	public Order(int time, DAY day, Customer customer)
	{
		this.orderNum = generateOrderNum();
		this.orderTime = time;
		this.orderDay = day;
		this.orderCustomer = customer;
		this.bevList = new ArrayList<Beverage>();
	}
	
	public int generateOrderNum()
	{
		int num = 0;
		final int MIN = 10000;
		final int MAX = 90000;
		
		Random rand = new Random(MIN);
		num = rand.nextInt(MAX - MIN) + 1;
		
		return orderNum;
	}
	
	@Override
	public boolean isWeekend()
	{
		boolean endOfWeek = false;
		if(orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY)
		{
			endOfWeek = true;
		}
		return endOfWeek;
	}
	
	public int getOrderNo()
	{
		return this.orderNum;
	}
	
	public int getOrderTime()
	{
		return this.orderTime;
	}
	
	public DAY getOrderDay()
	{
		return this.orderDay;
	}
	
	public Customer getCustomer()
	{
		return new Customer(orderCustomer);
	}
	
	public int getTotalItems()
	{
		return bevList.size();
	}
	
	public int compareTo(Order obj)
	{
		int value = 0;
		if(this.getOrderNo() == obj.getOrderNo())
		{
			value = 0;
		}
		else if(this.getOrderNo() > obj.getOrderNo())
		{
			value = 1;
		}
		else if(this.getOrderNo() < obj.getOrderNo())
		{
			value = -1;
		}
		return value;
	}

	@Override
	public Beverage getBeverage(int itemNo)
	{
		return bevList.get(itemNo);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup)
	{
		Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
		bevList.add(coffee);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size)
	{
		Alcohol alcohol = new Alcohol(bevName, size, isWeekend());
		bevList.add(alcohol);
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) 
	{
		Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addPRotien);
		bevList.add(smoothie);
	}

	@Override
	public double calcOrderTotal() 
	{
		double orderTotal = 0.0;
		for(int i = 0; i < bevList.size(); i++)
		{
			orderTotal += bevList.get(i).calcPrice();
		}
		return orderTotal;
	}

	@Override
	public int findNumOfBeveType(TYPE type)
	{
		int bevNum = 0;
		for(int i = 0; i < bevList.size(); i++)
		{
			if(bevList.get(i).getType() == type)
			{
				bevNum++;
			}
		}
		return bevNum;
	}
	
	public String toString()
	{
		String str = "Order Number: " + getOrderNo();
		str += "\nCustomer Name: " + getCustomer().getName();
		str += "\nOrder Size: " + getBeverage(getOrderNo()).getSize();
		str += "\nOrder Time: " + getOrderTime();
		str += "\nOrder Day: " + getOrderDay();
		str += "\nBeverage Name: " + "\n"; 
		for(int i = 0; i < bevList.size(); i++)
		{
			str += bevList.get(i).getBevName() + "\n";
		}
		return str;
		
	}
}
