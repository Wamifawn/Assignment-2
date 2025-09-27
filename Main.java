package pkg;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.Random;
import java.io.BufferedReader; 
import java.io.FileReader;
 

public class Main {
	
	static String NUM_FILE_NAME = "RandNumb.txt";
	
	public static void main(String args[]) {
 
		int[] nums = generateNumbers();

		saveNumbers(nums,NUM_FILE_NAME);
		
		runLinearSearch(1);
		runLinearSearch(500);
		runLinearSearch(900);
		
		System.out.println();
		
		// Record start time
		runBubbleSort();
		System.out.println();
		runQuickSort();
		System.out.println();
        runMergeSort();
    	System.out.println();
        nums = readNumbers(NUM_FILE_NAME);
				 
		runBinarySearch(1);
		runBinarySearch(500);
		runBinarySearch(900);
	}

	public static void runBubbleSort()
	{
		System.out.println("Bubble Sort");
				
		int[] nums = new int[1000];
		long startTime = System.nanoTime();
		
		nums = readNumbers(NUM_FILE_NAME);
		
		int[] sortedNums = BubbleSort.bubbleSort(nums);
		
	    // Record end time
        long endTime = System.nanoTime();
        double elapsedTimeInSeconds = (endTime - startTime) / 1_000_000_000.0;
        // Print elapsed time
        System.out.println("Bubble Sort Time taken: " + elapsedTimeInSeconds + " seconds");
        
        saveNumbers(sortedNums,"sortednumbBubbleSort.txt");
 
	}
	
	public static void runQuickSort()
	{
		System.out.println("Quick Sort");
				
		int[] nums = new int[1000];
		long startTime = System.nanoTime();
		
		nums = readNumbers(NUM_FILE_NAME);		
		
		QuickSort qs = new QuickSort();
		int[] sortedNums = qs.sort(nums, 0, nums.length -1);
	    
        long endTime = System.nanoTime();
        double elapsedTimeInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("QuickSort Time taken: " + elapsedTimeInSeconds + " seconds");
        
        saveNumbers(sortedNums,"sortednumbQuickSort.txt");
 
	}
	
	public static void runMergeSort()
	{
		System.out.println("Merge Sort");
				
		int[] nums = new int[1000];
		long startTime = System.nanoTime();
		
		nums = readNumbers(NUM_FILE_NAME);
		
		MergeSort ms = new MergeSort();
		int[] sortedNums = ms.sort(nums, 0, nums.length - 1);
	    
        long endTime = System.nanoTime();
        double elapsedTimeInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("MergeSort Time taken: " + elapsedTimeInSeconds + " seconds");
        
        saveNumbers(sortedNums,"sortednumbMergeSort.txt");
 
	}
	
	public static int runLinearSearch(int searchValue)
	{
		 System.out.println("Linear Search for " + Integer.toString(searchValue));
		int[] nums = new int[1000];
			
		long startTime = System.nanoTime();		
		
		nums = readNumbers(NUM_FILE_NAME);
		int foundValue = linearSearch(nums, searchValue);
		
	    // Record end time
        long endTime = System.nanoTime();
        double elapsedTimeInSeconds = (endTime - startTime) / 1_000_000_000.0;
        // Print elapsed time
        System.out.println("Linear Search Time taken: " + Double.toString(elapsedTimeInSeconds)  + " seconds");
        return foundValue;
	}
	
	public static int runBinarySearch(int searchValue)
	{
		System.out.println("Binary Search for " + Integer.toString(searchValue));
    	long startTime = System.nanoTime();		
		
		BinarySearch bs = new BinarySearch();
		
		int[] sortedNums = readNumbers("sortednumbQuickSort.txt");
		int foundValue = bs.binarySearch(sortedNums, searchValue);
		
	    // Record end time
        long endTime = System.nanoTime();
        double elapsedTimeInSeconds = (endTime - startTime) / 1_000_000_000.0;
        // Print elapsed time
        System.out.println("Binary Search Time taken: " + elapsedTimeInSeconds + " seconds");
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
