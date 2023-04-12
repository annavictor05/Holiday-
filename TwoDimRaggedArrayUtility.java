import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoDimRaggedArrayUtility {
	public static double[][] readFile(File file) throws FileNotFoundException {
	    Scanner scanner = new Scanner(file);

	    // Read the file into a temporary array of Strings
	    String[][] tempArray = new String[10][10];
	    int rowCount = 0;
	    while (scanner.hasNextLine() && rowCount < 10) {
	        String line = scanner.nextLine();
	        if (!line.isEmpty()) {
	            String[] parts = line.split(" ");
	            for (int i = 0; i < parts.length && i < 10; i++) {
	                tempArray[rowCount][i] = parts[i];
	            }
	            rowCount++;
	        }
	    }
	    scanner.close();

	    // If the file is empty, return null
	    if (rowCount == 0) {
	        return null;
	    }

	    // Create the ragged array based on the number of rows
	    double[][] array = new double[rowCount][];
	    for (int i = 0; i < rowCount; i++) {
	        // Determine the number of columns for this row
	        int columnCount = 0;
	        for (int j = 0; j < 10 && tempArray[i][j] != null; j++) {
	            columnCount++;
	        }

	        // Create the row
	        array[i] = new double[columnCount];

	        // Put the values from the temporary array into the row
	        for (int j = 0; j < columnCount; j++) {
	            array[i][j] = Double.parseDouble(tempArray[i][j]);
	        }
	    }

	    return array;
	}
	
	
	//getTotal
	public static double getTotal(double[][] data) {
	    double total = 0.0;
	    for (int i = 0; i < data.length; i++) {
	        for (int j = 0; j < data[i].length; j++) {
	            total += data[i][j];
	        }
	    }
	    return total;
	}
	
	//getAverage
	public static double getAverage(double[][] data) {
	    double total = getTotal(data);
	    int count = 0;
	    for (int i = 0; i < data.length; i++) {
	        for (int j = 0; j < data[i].length; j++) {
	            count++;
	        }
	    }
	    return (double)(total / count);
	}

	//getRowTotal
	public static double getRowTotal(double[][] data, int row) {
	    double total = 0.0;
	    for (int i = 0; i < data[row].length; i++) {
	        total += data[row][i];
	    }
	    return total;
	}

	//get column total 
	public static double getColumnTotal(double[][] data, int col) {
	    double total = 0.0;
	    for (int i = 0; i < data.length; i++) {
	        if (col < data[i].length) {
	            total += data[i][col];
	        }
	    }
	    return total;
	}

	//get highest in row 
	public static double getHighestInRow(double[][] data, int row) {
	    double highest = data[row][0];
	    for (int i = 1; i < data[row].length; i++) {
	        if (data[row][i] > highest) {
	            highest = data[row][i];
	        }
	    }
	    return highest;
	}

	//get highest in row index
	public static int getHighestInRowIndex(double[][] data, int row) {
	    double highest = data[row][0];
	    int index = 0;
	    for (int i = 1; i < data[row].length; i++) {
	        if (data[row][i] > highest) {
	            highest = data[row][i];
	            index = i;
	        }
	    }
	    return index;
	}

	//get lowest in row
	public static double getLowestInRow(double[][] data, int row) {
	    double lowest = data[row][0];
	    for (int i = 1; i < data[row].length; i++) {
	        if (data[row][i] < lowest) {
	            lowest = data[row][i];
	        }
	    }
	    return lowest;
	}

	//get lowest in row index
	public static int getLowestInRowIndex(double[][] data, int row) {
	    double lowest = data[row][0];
	    int index = 0;
	    for (int i = 1; i < data[row].length; i++) {
	        if (data[row][i] < lowest) {
	            lowest = data[row][i];
	            index = i;
	        }
	    }
	    return index;
	}

	//get highest in column
	public static double getHighestInColumn(double[][] data, int col) {
	    double highest = Double.MIN_VALUE;
	    for (int i = 0; i < data.length; i++) {
	        if (col < data[i].length && data[i][col] > highest) {
	            highest = data[i][col];
	        }
	    }
	    return highest;
	}

	//get highest in column index
	public static int getHighestInColumnIndex(double[][] data, int col) {
	    double highest = Double.MIN_VALUE;
	    int index = -1;
	    for (int i = 0; i < data.length; i++) {
	        if (col < data[i].length && data[i][col] > highest) {
	            highest = data[i][col];
	            index = i;
	        }
	    }
	    return index;
	}

	//get lowest in column 
	public static double getLowestInColumn(double[][] data, int col) {
	    double lowest = Double.MAX_VALUE;
	    for (double[] row : data) {
	        if (row.length > col) {
	            lowest = Math.min(lowest, row[col]);
	        }
	    }
	    return lowest;
	}

	//get lowest in column index
	public static int getLowestInColumnIndex(double[][] data, int col) {
	    double lowest = Double.MAX_VALUE;
	    int lowestIndex = -1;
	    for (int i = 0; i < data.length; i++) {
	        if (data[i].length > col && data[i][col] < lowest) {
	            lowest = data[i][col];
	            lowestIndex = i;
	        }
	    }
	    return lowestIndex;
	}

	//get highest in array 
	public static double getHighestInArray(double[][] data) {
	    double highest = Double.MIN_VALUE;
	    for (double[] row : data) {
	        for (double element : row) {
	            highest = Math.max(highest, element);
	        }
	    }
	    return highest;
	}

	//get lowest in array 
	public static double getLowestInArray(double[][] data) {
	    double lowest = Double.MAX_VALUE;
	    for (double[] row : data) {
	        for (double element : row) {
	            lowest = Math.min(lowest, element);
	        }
	    }
	    return lowest;
	}

	public static void writeToFile(double[][] dataSet4, File outputFile)throws FileNotFoundException {
		// TODO Auto-generated method stub
		 try {
	            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
	            for (double[] row : dataSet4) {
	                for (double value : row) {
	                    writer.write(value + " ");
	                }
	                writer.newLine();
	            }
	            writer.close();
	        } catch (IOException e) {
	            throw new FileNotFoundException("Error writing to file: " + e.getMessage());
	        }
	}



}
