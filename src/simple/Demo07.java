package simple;

import java.util.Stack;

//罗马数字转整数 leetCode ---13
public class Demo07 {

    private static int TYPE_I = 1;

    private static int TYPE_V = 5;

    private static int TYPE_X = 10;

    private static int TYPE_L = 50;

    private static int TYPE_C = 100;

    private static int TYPE_D = 500;

    private static int TYPE_M = 1000;


    public static void main(String[] args) {
        //System.out.println(romanToIntOne("MCMXCIV"));
        System.out.println(romanToIntTwo("MCMXCIV"));
    }

    // 方法1 ： 自己的办法，时间复杂度是O（n） 空间复杂度是O（2n）,效果不太差。
    public static int romanToIntOne(String s) {
        int ret = 0;
        Stack<Integer> copyInt = new Stack<>();
        Stack<Integer> addInt = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (i == s.length() - 1) {
                addInt.push(charToInt(c));
                copyInt.push(charToInt(c));
            } else {
                int popInt = addInt.pop();
                if (popInt < charToInt(c)) {
                    addInt.push(charToInt(c) + popInt);
                    copyInt.push(charToInt(c));
                } else if (popInt > charToInt(c) && copyInt.pop() == charToInt(c)) {
                    addInt.push(popInt + charToInt(c));
                    copyInt.push(charToInt(c));
                } else if (popInt > charToInt(c)) {
                    addInt.push(popInt - charToInt(c));
                    copyInt.push(charToInt(c));
                } else {
                    addInt.push(popInt);
                    addInt.push(charToInt(c));
                    copyInt.push(charToInt(c));
                }
            }
        }
        while (!addInt.empty()) {
            ret += addInt.pop();
        }
        return ret;
    }

    public static int charToInt(char c) {
        int ret = -1;
        switch (c) {
            case 'I':
                ret = TYPE_I;
                break;
            case 'V':
                ret = TYPE_V;
                break;
            case 'X':
                ret = TYPE_X;
                break;
            case 'L':
                ret = TYPE_L;
                break;
            case 'C':
                ret = TYPE_C;
                break;
            case 'D':
                ret = TYPE_D;
                break;
            case 'M':
                ret = TYPE_M;
                break;
        }
        return ret;
    }

    // 方法2： 优化算法，减少算法的内存消耗,更容易理解
    public static int romanToIntTwo(String s) {
        int sum = 0;
        String stringS = String.valueOf(s);
        for (int i = stringS.length() - 1; i >= 0; i--) {
            if (i == stringS.length() - 1) {
                sum += charToInt(stringS.charAt(i));
                continue;
            }
            if (charToInt(stringS.charAt(i)) < charToInt(stringS.charAt(i + 1))) {
                sum -= charToInt(stringS.charAt(i));
            } else {
                sum += charToInt(stringS.charAt(i));
            }
        }
        return sum;
    }
}
