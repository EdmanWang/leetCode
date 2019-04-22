package simple;
//1比特与2比特字符
public class Demo02 {

    public static void main(String[] args) {
        int[] bits = {1,0,0};
        boolean b = isOneBitCharacter(bits);
        if (b) {
            System.out.println("是1比特");
        }else {
            System.out.println("不是1比特");
        }
    }
    //方法1：
    public static boolean isOneBitCharacter(int[] bits) {
        int count = 0;
        int size = bits.length;
        if (size == 0) {
            throw new RuntimeException("数组输入错误，请检查输入的元素个数");
        }
        for (int i = 0;i<size;){
            if (bits[i] == 1){
                count = 2;
            }else if(bits[i] == 0){
                count = 1;
            }
            i = i+count;
        }
       return count == 2 ? false:(bits[size-1] == 0 ? true:false) ;
    }
}
