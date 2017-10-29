package twoPointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
 */

public class IntersectionofTwoArrays {

    //set
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> rst = new HashSet<>();
        for (int i: nums1) {
            set.add(i);
        }

        for (int j: nums2) {
            if (set.contains(j)) {
                rst.add(j);
            }
        }

        int[] rstArray = new int[rst.size()];

        int i = 0;
        for (Integer t: rst) {
            rstArray[i++] = t;
        }

        return rstArray;

    }

    //two pointer
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] rstArray = new int[set.size()];

        i = 0;
        for (Integer t: set) {
            rstArray[i++] = t;
        }

        return rstArray;
    }
}
