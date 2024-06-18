package laba9;
import java.util.*;
/*7 В кругу стоят N человек, пронумерованных от 1 до N. При
ведении счета по кругу вычеркивается каждый второй человек, пока не
останется один. Составить две программы, моделирующие процесс. Одна
из программ должна использовать класс ArrayList, а вторая — LinkedList.
Какая из двух программ работает быстрее? Почему?*/

public class Example11 {
    public static void main(String[] args) {
        System.out.print("Enter count of people: ");
        int countOfPeople = new Scanner(System.in).nextInt();
        System.out.println();

        System.out.print("ArrayList...");
        Example11_ArrayList arrayListVersion = new Example11_ArrayList(countOfPeople);
        System.out.println("created");
        long arrayListExecuteTime = arrayListVersion.getExecuteTime();
        System.out.println("ArrayList version execute time: " + arrayListExecuteTime);

        System.out.print("LinkedList...");
        Example11_LinkedList linkedListVersion = new Example11_LinkedList(countOfPeople);
        System.out.println("created");
        long linkedListExecuteTime = linkedListVersion.getExecuteTime();
        System.out.println("LinkedList version execute time: " + linkedListExecuteTime);
    }

}

class Example11_ArrayList {
    ArrayList<Integer> peopleArrayList;

    Example11_ArrayList(int count) {
        peopleArrayList = getIntegerArrayList(count);
    }

    public long getExecuteTime() {
        long timestamp1 = new Date().getTime();

        int counter = 0;
        while (peopleArrayList.size() > 1) {
            if (counter == 1) {
                peopleArrayList.remove(1);
                counter = 0;
            }
            counter++;
        }

        long timestamp2 = new Date().getTime();
        return timestamp2 - timestamp1;
    }

    public ArrayList<Integer> getIntegerArrayList(int capacity) {
        long timestamp1 = new Date().getTime();
        ArrayList<Integer> arrayList = new ArrayList<>(capacity + 1);

        for (int i = 1; i <= capacity; i++) {
            arrayList.add(i);
        }
        long timestamp2 = new Date().getTime();
        System.out.print((timestamp2 - timestamp1) + " ms ");
        return arrayList;
    }
}

class Example11_LinkedList {
    LinkedList<Integer> peopleLinkedList;

    Example11_LinkedList(int count) {
        peopleLinkedList = getIntegerArrayList(count);
    }

    public long getExecuteTime() {
        long timestamp1 = new Date().getTime();

        int counter = 0;
        while (peopleLinkedList.size() > 1) {
            if (counter == 1) {
                peopleLinkedList.remove(1);
                counter = 0;
            }
            counter++;
        }
        long timestamp2 = new Date().getTime();
        return timestamp2 - timestamp1;
    }

    public LinkedList<Integer> getIntegerArrayList(int capacity) {
        long timestamp1 = new Date().getTime();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 1; i <= capacity; i++) {
            linkedList.add(i);
        }
        long timestamp2 = new Date().getTime();
        System.out.print((timestamp2 - timestamp1) + " ms ");
        return linkedList;
    }
}
