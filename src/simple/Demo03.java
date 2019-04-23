package simple;

import java.util.Stack;

//2进制求和
public class Demo03 {

    public static void main(String[] args) {
        addBinary("1010", "10110");
    }

    public static void addBinary(String a, String b) {
        Stack<Integer> stack = new Stack<Integer>();
        int max_length = a.length() > b.length() ? a.length() : b.length();
        int add = 0;
        for (int i = 0; i < max_length; i++) {
            int va = i < a.length()? Integer.parseInt(String.valueOf(a.charAt(a.length() - i-1))):0;
            int vb = i < b.length()? Integer.parseInt(String.valueOf(b.charAt(b.length() - i-1))):0;
            int ret = va + vb + add;
            add = ret/2;
            stack.push(ret%2);
        }

        if (add > 0) {
            stack.push(add);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty()){
            stringBuilder.append(stack.pop());
        }
        System.out.println("2進制相加的結果是"+stringBuilder.toString());
    }
}
