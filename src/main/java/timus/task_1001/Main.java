package timus.task_1001;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

//В рамках второй лабы
public class Main {
    public static void main(String[] args) throws IOException {
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        Reader reader = oj ? new InputStreamReader(System.in) : new FileReader("input.txt");
        Scanner in = new Scanner(reader);
        Sqrt longStack = new Sqrt();
        while (in.hasNextLine()) {
            longStack.push(in.nextLine());
        }
        longStack.getAnswer();
    }
}

class Sqrt {
    private final Stack<Long> longStack = new Stack<>();

    public void push(String input) {
        long currentNum;
        String[] toParse = input.split(" ");

        for (String x : toParse) {
            if (x == null || x.isEmpty() | x.equals(" ")) continue;
            currentNum = Long.parseLong(x);
            longStack.push(currentNum);
        }


    }

    public void getAnswer() {
        double toGet;
        int size = longStack.size();

        for (int i = 0; i < size; i++) {
            toGet = longStack.pop();
            if (toGet != 0) toGet = Math.sqrt(toGet);
            //writer.write((toGet + "\n"));
            System.out.printf("%3.4f\n", toGet);
        }
    }
}
