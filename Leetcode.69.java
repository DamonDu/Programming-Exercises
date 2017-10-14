import java.lang.*;

class Solution {
    public int mySqrt(int x) {
     	int min = 0;
    	int max = x / 2 + 1; //sqrt(x)必然小于x/2+1
    	int mid = (min + max) / 2; 
    	if (x == 1) { return 1; }
    	while (max - min != 1) {
    		//使用除法避免超过MAX_INTEGER
    		if (x / mid == mid) { return mid; }
    		if (x / mid >  mid) {
    			min = mid;
    		}
    		else if (x / mid <  mid) {
    			max = mid;
    		}
    		mid = (min + max) / 2;
    	}
    	return min;
    }
}