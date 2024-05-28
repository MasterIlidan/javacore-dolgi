package laba9;

/*4 Выполнить пример 1 из раздела 2 Отработать код с помощью
отладчика и привести скриншоты минимум трех точек, обработанных
отладчиком.*/
public class Example9 {
    public static void main(String[] args) {
        Node listFromHead = createListFromHead(10);
        printList(listFromHead);

        Node listFromTail = createListFromTail(10);
        printList(listFromTail);

    }
    public static Node createListFromHead(int length) {
        if (length == 1) return new Node(1, null);
        Node head = new Node(1, null);
        Node current = head;
        for (int i = 2; i <= length; i++) {
            current.next = new Node(i, null);
            current = current.next;
        }
        return head;
    }
    public static Node createListFromTail(int length) {
        if (length == 1) return new Node(1, null);
        Node tail = new Node(1, null);
        Node current = null;
        for (int i = 2; i <= length; i++) {
            current = new Node(i, tail);
            tail = current;
        }
        Node head = current;
        return head;
    }
    public static void printList(Node head) {
        do {
            System.out.print(head.value + " ");
            head = head.next;
        } while (head != null);
        System.out.println();
    }
}
