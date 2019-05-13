package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// 四数之和 --- leetCode (题号 ：18)
public class Demo03 {

    public static void main(String[] args) {
        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        int target = 0;
        List<List<Integer>> list = fourSum(nums, target);
        for (List retList : list) {
            System.out.println("------------");
            for (int i = 0; i < retList.size(); i++) {
                System.out.println(retList.get(i));
            }
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<List<Integer>>();
        }
        HashSet<List<Integer>> returnList = new HashSet<>();
        Arrays.sort(nums);
        for (int x = 0; x < nums.length - 3; x++) {
            int moveOne = nums[x];
            for (int y = x + 1; y < nums.length - 2; y++) {
                int moveTwo = nums[y];
                int moveSum = moveOne + moveTwo;
                if (target - moveSum < 2 * moveTwo) {
                    break;
                }
                int i = y + 1;
                int j = nums.length - 1;
                while (j > i) {
                    if (target == moveSum + nums[i] + nums[j]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(moveOne);
                        list.add(moveTwo);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        i++;
                        j--;
                        returnList.add(list);
                    } else if (target - moveSum > nums[i] + nums[j]) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }
        }
        return new ArrayList<>(returnList);
    }
}
