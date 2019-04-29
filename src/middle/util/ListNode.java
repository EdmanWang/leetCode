package middle.util;

// 单链表的实现
public class ListNode {

    public Node headNode;

    /**
     * 找到链表的长度
     */
    public int getLength(Node ListNode) {
        // 得到链表的长度
        int count = 0;
        while (ListNode != null) {
            count += 1;
            ListNode = ListNode.next;
        }
        return count;
    }

    /**
     * 向指定的链表中添加节点
     */
    public boolean addNode(int value) {
        Node node = new Node(value);
        if (headNode == null) {
            headNode = node;
            return true;
        }
        Node moveNode = headNode;
        while (moveNode.next != null) {
            moveNode = moveNode.next;
        }
        moveNode.next = node;
        return true;
    }

    /**
     * 1：删除链表指定位置的节点
     */
    public boolean deleteNode(ListNode listNode, int index) {
        int number = 1;
        if ((index - 1) <= 0) {
            System.out.println("不能删除头节点");
            return false;
        }
        if (index >= getLength(listNode.headNode)) {
            Node node = getElement(listNode, (getLength(listNode.headNode) - 1));
            node.next = null;
            return true;
        }
        Node moveNode = listNode.headNode;
        while (moveNode.next != null) {
            if (number == (index - 1)) {
                moveNode.next = moveNode.next.next;
                return true;
            }
            number++;
            moveNode = moveNode.next;
        }
        return false;
    }


    /**
     * 找到链表中指定位置的节点
     */
    public Node getElement(ListNode ListNode, int index) {
        int count = getLength(ListNode.headNode);
        if (index < 0 || index > count) {
            System.out.println("查找的元素序号不在链表中");
            return null;
        }
        int number = 1;
        Node moveNode = ListNode.headNode;
        while (moveNode != null) {
            if (number == index) {
                return moveNode;
            }
            moveNode = moveNode.next;
            number++;
        }
        return null;
    }


    /**
     * 1: 在单链表listNode插入数据
     * 2：在第index的位置插入数据，数据的值是value
     */
    public boolean insert(Node listNode, int index, int value) {
        Node node = new Node(value);
        int listNodeLength = getLength(listNode);
        if (index > listNodeLength || (index - 1) <= 0) {
            addNode(value);
            return true;
        }
        int number = 1;
        Node moveNode = listNode;
        while (moveNode.next != null) {
            if (number == (index - 1)) {
                node.next = moveNode.next;
                moveNode.next = node;
                return true;
            }
            number++;
            moveNode = moveNode.next;
        }
        return false;
    }

    /**
     * 1:修改节点数据
     */
    public Node updateNode(ListNode listNode, int index, int value) {
        Node node = getElement(listNode, index);
        node.value = value;
        return node;
    }

    /**
     * 1: 反转链表
     */
    public ListNode reverseNodeList(ListNode listNode) {
        int length = listNode.getLength(listNode.headNode);
        int left = 1;
        int right = length;
        for (int i = 0; i < length / 2; i++) {
            int temp = getElement(listNode, left).value;
            getElement(listNode, left).value = getElement(listNode, right).value;
            getElement(listNode, right).value = temp;
        }
        return listNode;
    }


    /**
     * 1: 打印单链表节点数据
     */
    public static void printNode(Node headNode) {
        Node node = headNode;
        while (node.next != null) {
            System.out.println(node.value);
            node = node.next;
        }
        System.out.println(node.value);
    }

    public static void main(String[] args) {
//        addNode(1);
//        addNode(2);
//        addNode(3);
//        addNode(12);
//
//        printNode(headNode);
//        System.out.println("-----------------------------");
//        insert(headNode, 2, 99);
//        printNode(headNode);
//        deleteNode(headNode, 45);
//        printNode(headNode);
//         updateNode(headNode, 222, 100);
//        printNode(headNode);

    }
}

