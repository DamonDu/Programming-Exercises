import java.lang.*;

//My Solution
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

//A Better Solution
/*
public int sqrt(int x) {
    if (x == 0)
        return 0;
    int left = 1, right = Integer.MAX_VALUE;
    while (true) {
        int mid = left + (right - left)/2;
        if (mid > x/mid) {
            right = mid - 1;
        } else {
            if (mid + 1 > x/(mid + 1))
                return mid;
            left = mid + 1;
        }
    }
}
 */