package middle;

import middle.util.listNode.ListNode;

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
        ListNode p, q;
        p = l1;
        q = l2;
        int temp = 0;
        ListNode listNode = new ListNode();
        while (p.headNode!=null || q.headNode!=null || temp > 0 ){
            int oneValue  = 0;
            int twoValue = 0;
            if (p.headNode!=null){
                oneValue = p.headNode.value;
            }
            if (q.headNode!=null){
                twoValue = q.headNode.value;
            }
            int sum = oneValue + twoValue + temp;
            temp = sum / 10;
            if (sum != 0){
                listNode.addNode(sum % 10);
            }
            p.headNode = p.headNode.next;
            q.headNode = q.headNode.next;
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
