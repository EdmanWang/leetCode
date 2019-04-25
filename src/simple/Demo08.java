package simple;

import java.util.*;

// 字符串相加  leetCode --415
public class Demo08 {

    public static void main(String[] args) {
        System.out.println(addString("1", "12"));
    }

    public static String addString(String num1, String num2) {
        StringBuffer stringBuffer = new StringBuffer();
        int num1Length = num1.length() - 1;
        int num2Length = num2.length() - 1;
        int temp = 0;
        while (temp > 0 || num1Length >= 0 || num2Length >= 0) {
            if (num1Length>=0){temp += (int) num1.charAt(num1Length--) - '0';}
            if (num2Length>=0){temp += (int) num2.charAt(num2Length--) - '0';}
            stringBuffer.append(String.valueOf(temp % 10));
            temp = temp / 10;
        }
        return stringBuffer.reverse().toString();
    }
}
