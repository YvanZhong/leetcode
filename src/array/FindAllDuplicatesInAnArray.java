package array;

import java.util.*;
/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 */
public class FindAllDuplicatesInAnArray {

    //交换元素到各自的位置，然后遍历查找nums[i] != i+1的元素
    public List<Integer> findDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[nums[i] - 1] != nums[i]) { //nums[i] == i + 1 || nums[nums[i] - 1] == nums[i]
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
                if (nums[i] != i + 1) i--;
            }
        }

        List<Integer> ls = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ls.add(nums[i]);
            }
        }

        return ls;
    }

    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
}
