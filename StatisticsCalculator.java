package def;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class StatisticsCalculator {
	public static void main(String[] args) {
	
	// New scanner creation
		Scanner scan = new Scanner(System.in);
		
	// Input data through a dialog box
        String arrayLen = JOptionPane.showInputDialog(null, "Enter the number of elements in your list.", "Statistics Calculator", JOptionPane.QUESTION_MESSAGE);
    
    // Data validation (null) before conversion
        while (arrayLen == null || arrayLen.trim().isEmpty()) {
        	arrayLen = JOptionPane.showInputDialog(null, "Cannot be empty. Please enter an integer:");

            // Case where the window is closed
            if (arrayLen == null) {
                JOptionPane.showMessageDialog(null, "The operation was canceled.");
                System.exit(0); // End the program
            }

            // Case where only ENTER is pressed
            if (arrayLen.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter an integer.");
            }
        }

        try {
            int iarrayLen = Integer.parseInt(arrayLen); // Convert from text string to int
            
            float iArray[] = new float[iarrayLen]; // Array creation with variable length
            
        // Populating array with user input
			for( int i=0; i < iarrayLen; i++ ) {
				String data = JOptionPane.showInputDialog(null, "Enter a number: ", "Data Input", JOptionPane.QUESTION_MESSAGE);
				float iData = Float.parseFloat(data);
				iArray[i] = iData;
			}
		// Printing array
			System.out.print("The list is: ");
			for( int i=0; i < iarrayLen; i++ ) {
            	System.out.print(iArray[i] + " ");
            }
			//JOptionPane.showMessageDialog(null, "The list is: ");
			System.out.println("");
		
		//Average
			float average = 0;
			for( int i=0; i < iarrayLen; i++ ) {
            	average += iArray[i];
            } average = average/iarrayLen;
            JOptionPane.showMessageDialog(null, "The average is: " + average, "AVERAGE", JOptionPane.INFORMATION_MESSAGE);
        
        //Median
			double median = 0;
			int arrayCounter = 0;
			Arrays.sort(iArray); //Sorting from low to high, necessary to calculate the median
            if(arrayCounter % 2 == 0) {
            	JOptionPane.showMessageDialog(null, "The median is: " + (((double)iArray[iArray.length/2] + (double)iArray[iArray.length/2 - 1])/2), "MEDIAN", JOptionPane.INFORMATION_MESSAGE);
            } else if(arrayCounter % 2 !=0) {
            	JOptionPane.showMessageDialog(null, "The median is: " + (iArray[arrayCounter/2]), "MEDIAN", JOptionPane.INFORMATION_MESSAGE);
            }
        
         //Mode
            
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Exiting. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
}
}
