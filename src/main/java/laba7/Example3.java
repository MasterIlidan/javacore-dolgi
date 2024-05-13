package laba7;

public class Example3 {
    /*Напишите программу, в которой на основе суперкласса создается подкласс, а на
основе этого подкласса создается еще один подкласс (цепочка наследования из трех
классов). В первом суперклассе есть открытое целочисленное поле, метод с одним
параметром для присваивания значения полю и конструктор с одним параметром. Во
втором классе появляется открытое символьное поле, метод с двумя параметрами для
присваивания значения полям (перегрузка метода из суперкласса) и конструктор с двумя
параметрами. В третьем классе появляется открытое текстовое ноле, метод с тремя
аргументами для присваивания значений полям (перегрузка метода из суперкласса) и
конструктор с тремя параметрами. Для каждого класса определите метод toString () так,
чтобы он возвращал строку с названием класса и значениями всех полей объекта.*/
    public static void main(String[] args) {
        SubSubExample3 subSubClassObject = new SubSubExample3(1, 'h', "Hello");

        System.out.println(subSubClassObject);
        System.out.println();

        subSubClassObject.setValue(999,'X',"Changed");
        System.out.println(subSubClassObject);

    }
}

class SuperExample3 {
    public int superNum;

    public SuperExample3(int superNum) {
        this.superNum = superNum;
    }

    public void setValue(int value) {
        superNum = value;
    }

    public String toString() {
        return getClass().getSuperclass().getSuperclass().getName() + "(superNum=" + superNum + ")" + "\n" + getClass();
    }
}

class SubExample3 extends SuperExample3 {

    public char subChar;

    SubExample3(int numValue, char charValue) {
        super(numValue);
        subChar = charValue;
    }

    public void setValue(int numValue, char charValue) {
        subChar = charValue;
        setValue(numValue);
    }

    public String toString() {
        return super.toString()+ getClass().getSuperclass().getName() + "(subChar=" + subChar + ")" + "\n";
    }
}

class SubSubExample3 extends SubExample3 {
    public String subSubString;

    SubSubExample3(int numValue, char charValue, String subSubString) {
        super(numValue, charValue);
        this.subSubString = subSubString;
    }

    public void setValue(int numValue, char charValue, String stringValue) {
        subSubString = stringValue;
        setValue(numValue, charValue);
    }

    public String toString() {
        return super.toString() + getClass().getName() + "(subSubstring=" + subSubString + ")";
    }
}
