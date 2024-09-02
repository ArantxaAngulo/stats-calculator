package def;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Set;
import java.util.*;

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
			Arrays.sort(iArray); //Sorting from low to high, necessary to calculate the median
            if(iarrayLen % 2 == 0) { //if the array is even
            	JOptionPane.showMessageDialog(null, "The median is: " + (((double)iArray[iArray.length/2] + (double)iArray[iarrayLen/2 - 1])/2), "MEDIAN", JOptionPane.INFORMATION_MESSAGE);
            } else if(iarrayLen % 2 !=0) {
            	JOptionPane.showMessageDialog(null, "The median is: " + (iArray[iarrayLen/2]), "MEDIAN", JOptionPane.INFORMATION_MESSAGE);
            }
        
         //Mode
            Map<Float, Float> frequencyMap = new HashMap<>();
            for (int i = 0; i < iarrayLen; i++) {
            	float currentElement = iArray[i];
            	if (frequencyMap.containsKey(currentElement)) {
                    // If the element is already in the map, increase its count
                    frequencyMap.put(currentElement, frequencyMap.get(currentElement) + 1);
                } else {
                    // If the element is not in the map, add it with a count of 1
                    frequencyMap.put(currentElement, (float) 1);
                }
            }
            float mode = iArray[0]; // Start by assuming the first element is the mode
            float maxCount = 0; // Initialize the highest frequency count to 0

            for (float key : frequencyMap.keySet()) {
                float count = frequencyMap.get(key); // Get the frequency of the current element
                if (count > maxCount) {
                    maxCount = count; // Update the maximum frequency
                    mode = key; // Update the mode
                }
            }
            JOptionPane.showMessageDialog(null, "The mode is: " + mode, "MODE", JOptionPane.INFORMATION_MESSAGE);
            
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Exiting. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
}
}
