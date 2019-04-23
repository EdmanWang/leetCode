package simple;

// 各數相加
public class Demo04 {

    public static void main(String[] args) {
        addEveryOne(2269);
        addDigital(2269);
    }

    //方法1：自己想的。太low了
    public static int addEveryOne(int num) {
        String numberString = String.valueOf(num);
        if (numberString.length() == 1) {
            return (int) (numberString.charAt(0) - '0');
        }
        int a = (int) (numberString.charAt(0) - '0');
        int b = (int) (numberString.charAt(1) - '0');
        int sum = add(a, b);
        for (int i = 2; i < numberString.length(); i++) {
            //用了递归的思想
            sum = add(sum, (int) (numberString.charAt(i) - '0'));
        }
        System.out.println("計算的結果是" + sum);
        return sum;
    }

    public static int add(int a, int b) {
        int ab = a + b;
        if (ab >= 10) {
            ab = ab - 10 + 1;
        }
        return ab;
    }

    //方法2：java大神的代码
    public static void addDigital(int num) {
        System.out.println((num - 1) % 9 + 1);
    }
}
