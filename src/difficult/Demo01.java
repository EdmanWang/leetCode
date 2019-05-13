package difficult;

import java.util.Arrays;

// 寻找两个有序数组的中位数 leetCode ---  题号 ： 4
public class Demo01 {

    public static void main(String[] args) {
        int[] one = {1, 3, 5, 7, 9};
        int[] two = {2, 4, 6, 8, 10};

        // 两个数组放在同一个数据，算法实现
        int[] sum = Arrays.copyOf(one, one.length + two.length);
        System.arraycopy(two, 0, sum, one.length, two.length);
        for (int i = 0; i < sum.length; i++) {
            System.out.println(sum[i]);
        }

        // 测试
        System.out.println(findMedianSortedArrays(one, two));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index = 0;
        int moveOne = 0;
        int moveTwo = 0;
        int[] newArray = new int[nums1.length + nums2.length];

        if (nums1.length == 0) {
            newArray = Arrays.copyOf(nums2, nums2.length);
            return getCneterNumber(newArray);
        }

        if (nums2.length == 0) {
            newArray = Arrays.copyOf(nums1, nums1.length);
            return getCneterNumber(newArray);
        }

        while (moveOne < nums1.length && moveTwo < nums2.length) {
            if (nums1[moveOne] < nums2[moveTwo]) {
                // 插入num1的数据
                newArray[index++] = nums1[moveOne++];
            } else if (nums1[moveOne] > nums2[moveTwo]) {
                // 插入num2的数据
                newArray[index++] = nums2[moveTwo++];
            } else {
                newArray[index++] = nums1[moveOne++];
                newArray[index++] = nums2[moveTwo++];
            }
        }

        // 说明数组num1 中还有数据
        while (moveOne < nums1.length) {
            newArray[index++] = nums1[moveOne++];
        }
        // 说明数组nums2 中还有数据
        while (moveTwo < nums2.length) {
            newArray[index++] = nums2[moveTwo++];
        }
        return getCneterNumber(newArray);
    }

    public static double getCneterNumber(int[] newArray) {
        double centerNumber = 0.0;
        if (newArray.length % 2 == 1) {
            centerNumber = newArray[newArray.length / 2];
        } else {
            centerNumber = (double) (newArray[newArray.length / 2 - 1] + newArray[newArray.length / 2]) / 2;
        }
        return centerNumber;
    }
}
