/**
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg 
 * Description: Calculate the holidays bonuses
 * Due: 07/24/2022
 * Platform/compiler: Eclipse Java IDE SE 18
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Zong Qiang Li
*/

public class HolidayBonus
{
	public static double[] calculateHolidayBonus(double[][] data, double high, 
			double low, double other)
	{
		double[] array = new double[data.length];
		int index = 0;
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				if(data[row][col] <= 0)
				{
					array[index] += 0;
				}
				else if(data[row][col] == TwoDimRaggedArrayUtility.getHighestInColumn(data, col))
				{
					array[index] += high;
				}
				else if(data[row][col] == TwoDimRaggedArrayUtility.getLowestInColumn(data, col))
				{
					array[index] += low;
				}
				else
				{
					array[index] += other;
				}
			}
			index++;
		}
		return array;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data, double high,
			double low, double other)
	{
		double totalBonus = 0.0;
		double[] array = new double[data.length];
		int index = 0;
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				if(data[row][col] <= 0)
				{
					array[index] += 0;
				}
				else if(data[row][col] == TwoDimRaggedArrayUtility.getHighestInColumn(data, col))
				{
					array[index] += high;
				}
				else if(data[row][col] == TwoDimRaggedArrayUtility.getLowestInColumn(data, col))
				{
					array[index] += low;
				}
				else
				{
					array[index] += other;
				}
			}
			index++;
		}
		for(int i = 0; i < data.length; i++)
		{
			totalBonus += array[i];
		}
		return totalBonus;
	}

}
