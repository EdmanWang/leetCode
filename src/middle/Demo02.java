package middle;

import java.util.HashMap;
import java.util.Map;

// 无重复字符的最长子串 ---leetCode (题号 ： 3)
public class Demo02 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcccccvvvvdddddd"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Character> map = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                if (!map.containsValue(s.charAt(j))) {
                    map.put((char) (s.charAt(j)), s.charAt(j));
                } else {
                    map.clear();
                    break;
                }
                maxLength = maxLength > map.size() ? maxLength : map.size();
            }
        }
        return maxLength;
    }
}
