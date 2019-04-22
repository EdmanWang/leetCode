package simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//題目： 计算两个数的和
/*
  给定 nums = [2, 7, 11, 15], target = 9
  因为 nums[0] + nums[1] = 2 + 7 = 9
  所以返回 [0, 1]
 */
public class Demo01 {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 9, 8, 15, 62, 1, 0, 5, 5};
        int target = 10;
        add_two(nums, target);
    }

    //方法1：时间复杂度是（O的平方）,空间复杂度是O（1）
    public static void add_one(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println("i = " + i + "----" + "j = " + j);
                } else {
                    System.out.println("不存在这样的组合");
                }
            }
        }
    }

    //方法2：使用空间换时间 :时间复杂度是O（n） 空间复杂度是O（n）
    public static void add_two(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) ) {
                System.out.println("组合是" + i +"----"+ map.get(temp));
            }
        }
    }

    //方法3：时间复杂度取决于排序时间复杂度
    public static void add_three(int[] nums, int target) {
        //首先将数组进行排序
        Arrays.sort(nums); //不好评估
        int min = 0;
        int max = nums.length - 1;
        while (true) {
            if (max > min) {
                if (nums[min] + nums[max] == target) {
                    System.out.println("组合是" + min + "---" + max);
                    min++;
                } else if (nums[min] + nums[max] > target) {
                    max--;
                } else {
                    min++;
                }
            } else {
                break;
            }
        }
    }
}
