package middle;

import middle.util.ListNode;
import middle.util.Node;

// 两数想加 leetCode ---- 题号：2
public class Demo01 {

    static ListNode listNodeOne = new ListNode();
    static ListNode listNodeTwo = new ListNode();

    public static void initListNode() {
        listNodeOne.addNode(2);
        listNodeOne.addNode(4);
        listNodeOne.addNode(3);

        listNodeTwo.addNode(5);
        listNodeTwo.addNode(6);
        listNodeTwo.addNode(4);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int oneIndex = 1;
        int twoIndex = 1;
        int temp = 0;
        Node node = new Node(0);
        ListNode listNode = new ListNode();
        int maxLength = l1.getLength(l1.headNode) > l2.getLength(l2.headNode) ? l1.getLength(l1.headNode) : l2.getLength(l2.headNode);
        while (maxLength >= 0) {
            int one = 0;
            int two = 0;
            if (l1.getElement(l1, oneIndex) != null) {
                one = l1.getElement(l1, oneIndex).value;
                oneIndex++;
            }
            if (l2.getElement(l2, twoIndex) != null) {
                two = l2.getElement(l2, twoIndex).value;
                twoIndex++;
            }
            int sum = one + two + temp;
            temp = sum / 10;
            if (sum != 0){
                listNode.addNode(sum % 10);
            }
            maxLength --;

        }
        return listNode.reverseNodeList(listNode);
    }

    public static void main(String[] args) {
        initListNode();
        ListNode nodeList = addTwoNumbers(listNodeOne, listNodeTwo);
        ListNode listNode = new ListNode();
        while (nodeList.headNode !=null){
            System.out.println(nodeList.headNode.value);
            nodeList.headNode = nodeList.headNode.next;
        }
    }
}
