package pkg;

public class BubbleSort {

	public static int[] bubbleSort(int[] nums){
		int i;
		int j;
		 
		for (i = 0; i < nums.length - 1; i++) {
			for (j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}		    
        
		return nums;
	}
}
