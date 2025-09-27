package pkg;

public class BinarySearch {
	public int binarySearch(int[] nums, int searchValue){
		int low = 0;
		int high = nums.length - 1;

		while (low <= high){
		   int middlePosition = (low + high) / 2;
		   int middleNumber = nums[middlePosition];

		   if (searchValue == middleNumber){
		        return middlePosition;
		      }
		      if (searchValue < middleNumber){
		        high = middlePosition - 1;
		      }
		      else {
		        low = middlePosition + 1;
		      }
		}
	    
		return -1;
   }
}
