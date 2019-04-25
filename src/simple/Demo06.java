package simple;

// 判断一个数是否是一个回文数 -- leetcode(9)
public class Demo06 {

    public static void main(String[] args) {
        // System.out.println(isPalindromeOne(111000111));
        System.out.println(isPalindromeTwo(1001));
    }

    //方法1：将整型数据转换成字符串：时间复杂度是O(n)
    public static boolean isPalindromeOne(int x) {
        String stringX = String.valueOf(x);
        if (x == 0) {
            System.out.println("是回文数");
            return true;
        }
        if (x < 0) {
            System.out.println("不是回文数");
            return false;
        } else if (x % 10 == 0) {
            System.out.println("不是回文数");
            return false;
        } else {
            int left = 0;
            int right = stringX.length() - 1;
            while (right > left) {
                if (stringX.charAt(left) == stringX.charAt(right)) {
                    left++;
                    right--;
                } else {
                    break;
                }
            }
            if (right - left == 0 || right - left == -1) {
                System.out.println("是回文数");
                return true;
            } else {
                System.out.println("不是回文数");
                return false;
            }
        }
    }

    //方法2：不将整形数据转字符串
    public static boolean isPalindromeTwo(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0) {
            return false;
        }
        // 用于计算数的长度
        int xLength = 0;
        int temp = x;
        while (temp != 0) {
            temp = temp / 10;
            xLength++;
        }
        int right = 0;
        int left = xLength - 1;
        if (x > 0 && x % 10 == 0) {
            return false;
        } else {
            while (left > right) {
                if (compareDigital(x, right) != compareDigital(x, left)) {
                    return false;
                }
                right++;
                left--;
            }
            if (left - right == -1 || left - right == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static int compareDigital(int x, double number) {
        int num = x / (int) Math.pow(10.0, number);
        return num % 10;
    }

}
