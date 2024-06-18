package laba9;

import java.util.Scanner;

/*8 Разработать проект, в котором для ввода, вывода и изменения
односвязного линейного списка создать следующие методы:
а) с использованием цикла:
ввод с головы createHead();

ввод с хвоста createTail();

вывод (возвращается строка, сформированная из элементов
списка) toString();

добавление элемента в начало списка AddFirst();

добавление элемента в конец списка AddLast();

вставка элемента в список с указанным номером Insert();

удаление элемента с головы списка RemoveFirst();

удаление последнего элемента списка RemoveLast();

удаление из списка элемента с указанным номером

Remove();
б) с использованием рекурсии:

ввод с головы createHeadRec();

ввод с хвоста createTailRec();

вывод (возвращается строка, сформированная из элементов
списка) toStringRec().*/
public class Example12 {
    private static final Scanner scanner = new Scanner(System.in);
    private static int currentMenu = 1;
    private static final OneWayList list = new OneWayList();
    private static final String mainMenu = """
            1: create head
            2: create tail
            3: to string
            4: add first
            5: add last
            6: insert
            7: remove first
            8: remove last
            9: exit
            0: more...
                 \s
            Choose option (type 1-0)
           \s""";
    private static final String menu2 = """
            1: remove
            2: create head rec
            3: create tail rec
            4: to string rec
            5: back...
            """;

    public static void main(String[] args) {
        while (true) {
            goToMenu();
        }

    }

    private static void goToMenu() {
        switch (currentMenu) {
            case 1: {
                System.out.println(mainMenu);
                mainMenu();
                break;
            }
            case 2: {
                System.out.println(menu2);
                menu2();
                break;
            }
        }
    }

    private static void mainMenu() {
        switch (getIntegerInput()) {
            case 1: {
                System.out.println("create head\nEnter value");
                list.createHead(getIntegerInput());
                break;
            }
            case 2: {
                System.out.println("create tail\nEnter value");
                list.createTail(getIntegerInput());
                break;
            }
            case 3: {
                System.out.println("to string\n");
                System.out.println(list);
                break;
            }
            case 4: {
                System.out.println("add first\nEnter value");
                list.addFirst(getIntegerInput());
                break;
            }
            case 5: {
                System.out.println("add last\nEnter value");
                list.addLast(getIntegerInput());
                break;
            }
            case 6: {
                System.out.println("insert\nEnter value and index");
                list.insert(getIntegerInput(), getIntegerInput());
                break;
            }
            case 7: {
                System.out.println("remove first\n");
                list.removeFirst();
                break;
            }
            case 8: {
                System.out.println("remove last\n");
                list.removeLast();
                break;
            }
            case 9: {
                System.out.println("exit...");
                System.exit(0);
                break;
            }
            case 0: {
                System.out.println("more...");
                currentMenu = 2;
                break;
            }
            default: {
                System.out.println("Invalid input");
                break;
            }
        }
    }

    private static void menu2() {
        switch (getIntegerInput()) {
            case 1: {
                System.out.println("remove\nEnter index");
                list.remove(getIntegerInput());
                break;
            }
            case 2: {
                System.out.println("create head rec\nEnter value");
                list.createHeadRec(getIntegerInput());
                break;
            }
            case 3: {
                System.out.println("create tail rec\nEnter value");
                list.createTailRec(getIntegerInput());
                break;
            }
            case 4: {
                System.out.println("to string rec\n");
                list.toStringRec();
                break;
            }
            case 5: {
                System.out.println("back...\n");
                currentMenu = 1;
                break;
            }
            default: {
                System.out.println("Invalid input");
                break;
            }
        }
    }

    private static int getIntegerInput() {
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }
}

class OneWayList {
    Node head;

    OneWayList() {
        head = null;
    }

    public void createHead(int value) {
        head = new Node(value, head);
    }

    public void createTail(int value) {
        if (head == null) { //если список не имеет головы (ещё не создан)
            createHead(value);
            return;
        }

        Node ref = head;
        while (ref.next != null) {
            ref = ref.next;
        }
        ref.next = new Node(value, null);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node ref = head;
        int counter = 1;
        while (ref != null) {
            builder.append(counter).append(": ").append(ref.value).append("\n");
            ref = ref.next;
            counter++;
        }
        return builder.toString();
    }

    public void addFirst(int value) {
        createHead(value);
    }

    public void addLast(int value) {
        createTail(value);
    }

    public void insert(int value, int index) {
        if (index <= 0) {
            System.out.println("Incorrect index");
            return;
        }
        if (index == 1) {
            createHead(value);
            return;
        }

        Node ref = head;
        for (int i = 2; i < index; i++) {
            ref = ref.next;
            if (ref == null) {
                System.out.println("Index out of bounds");
                return;
            }
        }

        ref.next = new Node(value, ref.next);
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node ref = head;
        while (ref.next.next != null) {
            ref = ref.next;
        }
        ref.next = null;
    }

    public void remove(int index) {
        if (index <= 0) {
            System.out.println("Incorrect index");
            return;
        }
        if (index == 1) {
            removeFirst();
            return;
        }

        Node ref = head;
        for (int i = 2; i < index; i++) {
            ref = ref.next;
            if (ref == null) {
                System.out.println("Index out of bounds");
                return;
            }
        }

        ref.next = ref.next.next;
        //System.gc();
    }
    public void createHeadRec(int value) {
        createHead(value);
    }
    public void createTailRec(int value) {
        createTailRec(value, head);
    }
    private void createTailRec(int value, Node ref) {
        if (ref == null) {
            createHeadRec(value);
            return;
        }
        if (ref.next == null) {
            ref.next = new Node(value, null);
            return;
        }
        createTailRec(value,ref.next);
    }
    public void toStringRec() {
        toStringRec(head);
    }
    private void toStringRec(Node ref) {
        if (ref == null) {
            return;
        }
        System.out.println(ref.value);
        toStringRec(ref.next);
    }
}



