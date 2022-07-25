/**
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg 
 * Description: Write a Sales Report that takes an input File and reads its contents
 * and performs calculations to determine the total, average, highest, and lowest values
 * Due: 07/24/2022
 * Platform/compiler: Eclipse Java IDE SE 18
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Zong Qiang Li
*/

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility
{
	/**
	 * This method returns the average of the elements in the data array
	 * @param data
	 * @return average 
	 */
	public static double getAverage(double[][] data)
	{
		double average;
		int count = 0;
		double total = 0.0;
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				total += data[row][col];
				count++;
			}
		}
		average = total / count;
		return average;
	}
	
	/** 
	 * This method returns the total of a specified column's values 
	 * in the data array
	 * @param data
	 * @param col
	 * @return total
	 */
	public static double getColumnTotal(double[][] data, int col)
	{
		double total = 0.0;
		
		for(int row = 0; row < data.length; row++)
		{
			if(col >= data[row].length)
			{
				continue;
			}
			total += data[row][col];
		}
		return total;
	}
	
	/**
	 * This method finds and returns the highest value in the data array
	 * @param data
	 * @return highest
	 */
	public static double getHighestInArray(double[][] data)
	{
		double highest = data[0][0];
		for(int row = 1; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col ++)
			{
				if(data[row][col] > highest)
				{
					highest = data[row][col];
				}
			}
		}
		return highest;
	}
	
	/**
	 * This method finds and returns the highest column value
	 * @param data
	 * @param col
	 * @return highest
	 */
	public static double getHighestInColumn(double[][] data, int col)
	{
		double highest = Double.MIN_VALUE;
		for(int row = 0; row < data.length; row++)
		{
			if(col >= data[row].length)
			{
				continue;
			}
			else
			{
				if(data[row][col] > highest)
				{
					highest = data[row][col];
				}
			}
		}
		return highest;
	}
	
	/**
	 * This method finds and returns the index of the element with the greatest
	 * value of the specified column
	 * @param data
	 * @param col
	 * @return index
	 */
	public static int getHighestInColumnIndex(double[][] data, int col)
	{
		double highest = Double.MIN_VALUE;
		int index = 0;
		for(int row = 0; row < data.length; row++)
		{
			if(col >= data[row].length)
			{
				continue;
			}
			else 
			{
				if(data[row][col] > highest)
				{
					highest = data[row][col];
					index = row;
				}
			}
		}
		return index;
	}
	
	/**
	 * This method returns the highest value in a given row
	 * @param data
	 * @param row
	 * @return highest
	 */
	public static double getHighestInRow(double[][] data, int row)
	{
		double highest = data[row][0];
		for(int col = 0; col < data[row].length; col ++)
		{
			if(data[row][col] > highest)
			{
				highest = data[row][col];
			}
		}
		return highest;
	}
	
	/**
	 * This method finds and retrieves the highest value in
	 * the data array, and returns the index with the highest value
	 * @param data
	 * @param row
	 * @return index
	 */
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		double highest = data[row][0];
		int index = row;
		for(int col = 0; col < data[row].length; col ++)
		{
			if(data[row][col] > highest)
			{
				highest = data[row][col];
				index = row;
			}
		}
		return index;
	}
	
	/**
	 * This method finds and returns the lowest value in the data array
	 * @param data
	 * @return lowest
	 */
	public static double getLowestInArray(double[][] data)
	{
		double lowest = data[0][0];
		for(int row = 0; row < data.length; row++)
		{
			for(int col = 0; col < data[row].length; col++)
			{
				if(data[row][col] < lowest)
				{
					lowest = data[row][col];
				}
			}
		}
		return lowest;
	}
	/**
	 * Find and return the lowest value of a given column in the data array
	 * @param data
	 * @param col
	 * @return lowest
	 */
	public static double getLowestInColumn(double[][] data, int col)
	{
		double lowest = Double.MAX_VALUE;
		for(int row = 0; row < data.length; row++)
		{
			if(col >= data[row].length)
			{
				continue;
			}
			else
			{
				if(data[row][col] < lowest)
				{
					lowest = data[row][col];
				}
			}
		}
		return lowest;
	}
	
	/**
	 * This method finds and returns the column index with the lowest
	 * value of the given column
	 * @param data
	 * @param col
	 * @return
	 */
	public static int getLowestInColumnIndex(double[][] data, int col)
	{
		double lowest = Double.MAX_VALUE;
		int index = 0;
		for(int row = 0; row < data.length; row++)
		{
			if(col >= data[row].length)
			{
				continue;
			}
			else 
			{
				if(data[row][col] < lowest)
				{
					lowest = data[row][col];
					index = row;
				}
			}
		}
		return index;
	}
	
	/**
	 * This method returns the lowest value in a given row
	 * @param data
	 * @param row
	 * @return highest
	 */
	public static double getLowestInRow(double[][] data, int row)
	{
		double highest = data[row][0];
		for(int col = 0; col < data[row].length; col ++)
		{
			if(data[row][col] > highest)
			{
				highest = data[row][col];
			}
		}
		return highest;
	}
	
	/**
	 * This method finds and retrieves the lowest value in
	 * the data array, and returns the index of that value
	 * @param data
	 * @param row
	 * @return index
	 */
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		double lowest = data[row][0];
		int index = row;
		for(int col = 0; col < data[row].length; col ++)
		{
			if(data[row][col] < lowest)
			{
				lowest = data[row][col];
				index = row;
			}
		}
		return index;
	}
	
	/**
	 * This method returns the total of the elements' values in the data array
	 * @param data
	 * @return total
	 */
	public static double getTotal(double[][] data)
	{
		double total = 0.0;
		for(int i = 0; i < data.length; i++)
		{
			for(int j = 0; j < data[i].length; j ++)
			{
				total += data[i][j];
			}
		}
		return total;
	}
	
	/**
	 * Get and return the total of a given row
	 * @param data
	 * @param row
	 * @return total
	 */
	public static double getRowTotal(double[][] data, int row)
	{
		double total = 0.0;
		for(int col = 0; col < data[row].length; col++)
		{
			total += data[row][col];
		}
		return total;
	}

	/**
	 * Reads from a file and returns a ragged array of doubles
	 * @param file
	 * @return double[][] array
	 * @throws java.io.FileNotFoundException
	 */
	public static double[][] readFile(File file) throws java.io.FileNotFoundException
	{
		final int MAX_ROW = 10, MAX_COL = 10; // temp row and col length for temporary String
		// array to read in and store the inputFile
		String[][] temp = new String[MAX_ROW][MAX_COL];
		
		Scanner inputFile = new Scanner(file);
		
		// initialize row value to 0; value will be updated via while loop
		// until the data sheet has no more lines
		int row = 0;
		while(inputFile.hasNextLine())
		{
			// Method chain remove white spaces and tokenize data in each line, get length of line
			String[] findRow = inputFile.nextLine().split(" ");
			temp[row] = new String[findRow.length]; // Ragged array with the length of this line/row
			for(int i = 0; i < findRow.length; i++) // Step into the findRow array 
			{
				temp[row][i] = findRow[i]; // store column values for the ragged array's row
			}
			row++; // update so the while loop will continue to next line
		}

		inputFile.close();
		
		double[][] array = new double[row][]; // create array with newly-found ragged array row length
		
		for(int r = 0; r < array.length; r++)
		{
			array[r] = new double[temp[r].length];
			for(int c = 0; c < array[r].length; c++)
			{
				if(temp[r][c] != null) // Determine if value is valid
				{
					System.out.print(temp[r][c] + " "); // 
					array[r][c] = Double.parseDouble(temp[r][c]); // Convert to double and store
					// in array to be returned
				}
			}
			System.out.println();
		}
		return array;
	}
	
	/**
	 * This method writes the ragged array of doubles into the file.
	 * @param data
	 * @param outputFile
	 * @throws java.io.FileNotFoundException
	 */
	public static void writeToFile(double[][] data, File outputFile) throws java.io.FileNotFoundException
	{
		PrintWriter outFile = new PrintWriter(outputFile);
		for(int row = 0; row < data.length; row++) // Step into row
		{
			for(int col = 0; col < data[row].length; col++) // Step into column
			{
				outFile.print(data[row][col] + " "); // print each element value, separate by a space
			}
			outFile.println(); // each row separated by a line
		}
		outFile.close();
	}
}
