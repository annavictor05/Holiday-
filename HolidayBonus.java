
public class HolidayBonus {
	static double [] calculateHolidayBonus (double [] [] data, double high, 
											 double low, double other) {
		        

		        double[] bonuses = new double[data.length];

		        // Iterate over each row in the array
		        for (int i = 0; i < data.length; i++) {
		            // Get the sales for the current row
		            double[] rowSales = data[i];

		           // Calculate the total sales for the row
		            double totalSales = rowSales[0];
		            // Determine the highest and lowest sales for the row
		            double highestSales = rowSales[0];
		            double lowestSales = rowSales[0];
		            
		            // Iterate over each element in the row
		            for (int j = 1; j < rowSales.length; j++) {
		                if (rowSales[j] > highestSales) 
		                {
		                	highestSales = rowSales[j];
		                }
		                if (rowSales[j] < lowestSales)
		                {
		                	lowestSales = rowSales[j];
		                }
		                
		                totalSales += rowSales[j];
		            }
		                
		            double bonus =0;
		            for (int j = 0; j < rowSales.length; j++) {
		                if (rowSales[j] == highestSales) {
		                    bonus += high;
		                } else if (rowSales[j] == lowestSales) {
		                    bonus += low;
		                } else {
		                    bonus += other;
		                }
		            }
		            
		            bonuses[i] = bonus;
		        }
		        
		        return bonuses;
		        }
		    
	public static double calculateTotalHolidayBonus(double [] [] data, double high, 
			                                         double low,  double other) {
		double[] bonuses = HolidayBonus.calculateHolidayBonus(data, high, low, other);
        double totalBonus = 0;
        
        for (int r =0; r <bonuses.length; r++) {
            totalBonus += bonuses[r];
        }
        
        return totalBonus;
    }
}
 

   


