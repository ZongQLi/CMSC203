import java.util.ArrayList;

public class BevShop implements BevShopInterface
{
	private Order currentOrder;
	private ArrayList<Order> bevList;
	
	public BevShop()
	{
		bevList = new ArrayList<Order>();
	}
	
	@Override
	public boolean validTime(int time)
	{
		if(time >= MIN_TIME && time <= MAX_TIME)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int getMaxNumOfFruits()
	{
		return MAX_FRUIT;
	}

	@Override
	public int getMinAgeForAlcohol()
	{
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits)
	{
		if(numOfFruits > MAX_FRUIT)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int getMaxOrderForAlcohol()
	{
		return MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean eligibleForMore()
	{
		if(getNumOfAlcoholDrink() <= MAX_ORDER_FOR_ALCOHOL)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int getNumOfAlcoholDrink()
	{
		int bevNum = currentOrder.findNumOfBeveType(TYPE.ALCOHOL);
		return bevNum;
	}

	@Override
	public boolean validAge(int age)
	{
		if(age > MIN_AGE_FOR_ALCOHOL)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge)
	{
		this.currentOrder = new Order(time, day, new Customer(customerName, customerAge));
		bevList.add(currentOrder);
	}

	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup)
	{
		this.currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	@Override
	public void processAlcoholOrder(String bevName, SIZE size)
	{
		this.currentOrder.addNewBeverage(bevName, size);
	}

	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien)
	{
		this.currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtien);
	}

	@Override
	public int findOrder(int orderNo)
	{
		int index = -1;
		for(int i = 0; i < bevList.size(); i++)
		{
			if(bevList.get(i).getOrderNo() == orderNo)
			{
				index = i;
			}
		}
		return index;
	}

	@Override
	public double totalOrderPrice(int orderNo)
	{
		double orderTotal = 0.0;
		orderTotal = bevList.get(orderNo).calcOrderTotal();
		return orderTotal;
	}

	@Override
	public double totalMonthlySale()
	{
		double monthTotal = 0.0;
		for(int i = 0; i < bevList.size(); i++)
		{
			monthTotal += bevList.get(i).calcOrderTotal();
		}
		return monthTotal;
	}

	@Override
	public int totalNumOfMonthlyOrders()
	{
		int monthOrderNum = bevList.size();
		return monthOrderNum;
	}

	@Override
	public Order getCurrentOrder()
	{
		return this.currentOrder;
	}

	@Override
	public Order getOrderAtIndex(int index)
	{
		Order orderIndex = bevList.get(index);
		return orderIndex;
	}

	@Override
	public void sortOrders()
	{
		int minVal = 0;
		for(int i = 0; i < bevList.size(); i++)
		{
			minVal = i;
			for(int j = 0; j < bevList.size(); j++)
			{
				if(bevList.get(j).compareTo(bevList.get(minVal)) == -1)
				{
					minVal = j;
				}
				bevList.set(minVal, bevList.get(i));
				bevList.set(i, bevList.get(minVal));
			}
		}
	}
	
	public String toString()
	{
		String str = "Bradley Beverage Shop Month Report: \n";
		for(int i = 0; i < bevList.size(); i++)
		{
			str += "Order: " + i + 1;
			str += "\nCustomer: " + bevList.get(i).getCustomer().getName();
			str += "\nOrder List: " + bevList.get(i).toString();
		}
		str += "\n\nTotal Monthly Orders: " + this.totalNumOfMonthlyOrders();
		str += "\nTotal Month Sales: " + this.totalMonthlySale(); 
		return str;
	}
}
