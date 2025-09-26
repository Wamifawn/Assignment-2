package pkg;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.File;

public class Main {
	
	static String NUM_FILE_NAME = "RandNumb.txt";
	
	public static void main(String args[]) {
 
		int[] nums = generateNumbers();

		saveNumbers(nums,NUM_FILE_NAME);
		
		runLinearSearch(1);
		runLinearSearch(500);
		runLinearSearch(900);
		
		// Record start time
		runBubbleSort();
		
        
	}

	public static void runBubbleSort()
	{
		System.out.println("Bubble Sort");
				
		int[] nums = new int[1000];
		
		nums = readNumbers(NUM_FILE_NAME);
		
		long startTime = System.nanoTime();
		int[] sortedNums = BubbleSort.bubbleSort(nums);
		
	    // Record end time
        long endTime = System.nanoTime();
        double elapsedTimeInSeconds = (endTime - startTime) / 1_000_000_000.0;
        // Print elapsed time
        System.out.println("\nBubble Sort Time taken: " + elapsedTimeInSeconds + " seconds");
        
        saveNumbers(sortedNums,"sortednumbBubbleSort.txt");
 
	}
	
	public static int runLinearSearch(int searchValue)
	{
		 System.out.println("Linear Search for " + Integer.toString(searchValue));
		int[] nums = new int[1000];
		
		nums = readNumbers(NUM_FILE_NAME);
	
		long startTime = System.nanoTime();		
		
		int foundValue = linearSearch(nums, searchValue);
		
	    // Record end time
        long endTime = System.nanoTime();
        double elapsedTimeInSeconds = (endTime - startTime) / 1_000_000_000.0;
        // Print elapsed time
        System.out.println("\nLinear Search Time taken: " + elapsedTimeInSeconds + " seconds");
        return foundValue;
	}
	
	public static int linearSearch(int[] nums, int searchValue ){
		int i;
		
		for (i = 0; i < nums.length; ++i) {
			if (nums[i] == searchValue) {
				return nums[i];
			}
		}
		
		return -1;
	}
		
	public static int[] generateNumbers(){
		int size = 1000; 
        int[] numbers = new int[size]; 
        Random rand = new Random(); 

        for (int i = 0; i < size; i++) { 
            numbers[i] = i; 
        }
        for (int i = 0; i < size; i++ ) { 
            int j = i + rand.nextInt(size - i); 
            int temp = numbers[i]; 
            numbers[i] = numbers[j]; 
            numbers[j] = temp; 
        }
        
		return numbers;
	}	

    public static void saveNumbers(int[] array, String filename) { 
        try { 
            FileWriter writer = new FileWriter(filename); 
            for (int num : array) { 
                writer.write(num + "\n"); 
            }
            writer.close();
            System.out.println("Saved " + array.length +  " numbers to " + filename); 
        } catch (IOException e ) { 
            System.out.println("Errorr saving to file: " + e.getMessage()); 
        }
    }
	
	public static int[] readNumbers(String filePath){
		BufferedReader reader = null;
	 
        String line;
        int[] numbers = new int[1000];
        int lineCounter = -1;

        try{
        	reader = new BufferedReader(new FileReader(filePath));	
            while ((line = reader.readLine()) != null) {
                int data = Integer.parseInt(line);
                lineCounter++;
                numbers[lineCounter] = data;	                
            }
            reader.close();
        }
        catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
            e.printStackTrace();
        }
        

	   return numbers;
	}
}
