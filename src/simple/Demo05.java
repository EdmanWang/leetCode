package simple;

// 整数反转
public class Demo05 {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
            return 0;
        }
        double count = 0;
        String stringX = String.valueOf(x);
        for (int i = 0; i < stringX.length(); i++) {
            int value = (int) stringX.charAt(i) - '0';
            if (value == 0) {
                count++;
            }
        }

        int zhenShuX = x / (int) Math.pow(10.0, count);
        int yuShuX = x % (int) Math.pow(10.0, count);
        if (yuShuX == 0) {
            return commonCode(zhenShuX);
        } else {
            return commonCode(x);
        }
    }

    public static int commonCode(int x) {
        String reverseNumber = "";
        if (x >= 0) {
            reverseNumber = new StringBuilder(String.valueOf(x)).reverse().toString();
            System.out.println("wgx---wgx" + reverseNumber);
            // 注意反转后的数据是否过大，或者过小
            try {
                return Integer.parseInt(reverseNumber);
            } catch (NumberFormatException e) {
                return 0;
            }
        } else {
            reverseNumber += "-";
            reverseNumber += new StringBuilder(String.valueOf(Math.abs(x))).reverse().toString();
            System.out.println("wgx---wgx" + reverseNumber);
            // 注意反转后的数据是否过大，或者过小
            try {
                return Integer.parseInt(reverseNumber);
            } catch (NumberFormatException e) {
                return 0;
            }
        }
    }
}
