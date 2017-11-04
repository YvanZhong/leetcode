package array;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++){
                sum += nums[end];
                if (sum == k) count++;
            }
        }
        return count;
    }

    //Using hashmap @aayushgarg
    public int subarraySum2(int[] nums, int k) {
        int count=0,sum=0;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(sum, hm.getOrDefault(sum,0)+1);
            sum+=nums[i];
            count+=hm.getOrDefault((sum-k),0);
        }
        return count;
    }

    public static void main(String... args) {
        System.out.println(new SubarraySumEqualsK().subarraySum(new int[] {1,1,1}, 0));
        System.out.println(new SubarraySumEqualsK().subarraySum2(new int[] {1,1,1}, 0));
    }
}
