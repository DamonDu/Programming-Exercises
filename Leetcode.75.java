class Solution {
    public void sortColors(int[] nums) {
    	int leftFlag = 0;
    	int rightFlag = nums.length - 1;
    	int temp;
        for (int i = 0; i <= rightFlag; i++) {
        	if (nums[i] == 0){
        		temp = nums[i];
        		nums[i] = nums[leftFlag];
    			nums[leftFlag] = temp;
    			leftFlag++;
        	}
        	if (nums[i] == 2) {
        		temp = nums[i];
        		nums[i] = nums[rightFlag];
        		nums[rightFlag] = temp;
        		rightFlag--;
        		i--;//注意这里需要回退循环重新判断，因为nums[rightFlag]的值可能为0 
        	}
        }
    }
}

