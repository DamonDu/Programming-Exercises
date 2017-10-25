class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int temp;
        int index = 0;
        int flag = 0;
        for (int i = length - 1; i > 0; i--) {
        	//从后往前找极大值
        	if (nums[i] > nums[i - 1]) {
        		index = i;
        		//找到大于nums[i - 1]的最小数，与之交换
        		for (int j = length - 1; j > i - 1; j--) {
        			if (nums[j] > nums[i - 1] && nums[j] < nums[index]) {
        				index = j;
        			}
        		}
        		temp = nums[index];
        		nums[index] = nums[i - 1];
        		nums[i - 1] = temp;
        		flag = i;
        		break;
        	}
        }
        //下降排序(冒泡)
		for (int j = flag; j < length - 1; j++) {
			for (int m = flag; m < length -1 - (j - flag); m++) {
				if (nums[m] > nums[m + 1]) {
					temp = nums[m];
					nums[m] = nums[m + 1];
					nums[m + 1] = temp;
				}
			}
		}
	}
}