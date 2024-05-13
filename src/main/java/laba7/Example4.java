package laba7;

public class Example4 {
    /*Напишите программу, в которой использована цепочка наследования из трех
классов. В первом классе есть открытое символьное поле. Во втором классе появляется
открытое текстовое поле. В третьем классе появляется открытое целочисленное поле. В
каждом из классов должен быть конструктор, позволяющий создавать объект на основе
значений полей, переданных аргументами конструктору, а также конструктор создания
копии.*/
    public static void main(String[] args) {
        SubSubExample4 originalObject = new SubSubExample4(10, "Hello World", 's');
        System.out.println(originalObject);

        System.out.println();
        System.out.println("Cloning...");

        SubSubExample4 clonedObject = originalObject.clone();
        System.out.println(clonedObject);

        System.out.println();
        System.out.println("Change values of original object...");
        originalObject.subString = "Changed";
        originalObject.subSubNum = 999;
        originalObject.superChar = 'X';
        System.out.println(originalObject);

        System.out.println();
        System.out.println("Making sure that clonedObject is untouched");
        System.out.println(clonedObject);
    }
}

class SuperExample4 {
    public char superChar;

    SuperExample4(char superChar) {
        this.superChar = superChar;
    }
    public SuperExample4 clone() {
        return new SuperExample4(superChar);
    }

    public String toString() {
        return getClass().getSuperclass().getSuperclass().getName() + " superChar=" + superChar + "\n";
    }
}

class SubExample4 extends SuperExample4 {
    public String subString;

    SubExample4(String stringValue, char superChar) {
        super(superChar);
        this.subString = stringValue;
    }

    public SubExample4 clone() {
        return new SubExample4(subString, superChar);
    }

    public String toString() {
        return super.toString() + getClass().getSuperclass().getName() + " subString=" + subString + "\n";
    }
}

class SubSubExample4 extends SubExample4 {
    public int subSubNum;

    SubSubExample4(int numValue, String stringValue, char charValue) {
        super(stringValue, charValue);
        this.subSubNum = numValue;
    }

    public SubSubExample4 clone() {
        return new SubSubExample4(subSubNum, subString, superChar);
    }

    public String toString() {
        return super.toString() + getClass().getName() + " subSubNum=" + subSubNum;
    }
}
