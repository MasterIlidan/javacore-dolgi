package laba7;

public class Example5 {
    /*Напишите программу, в которой есть суперкласс с приватным текстовым полем,
конструктор с текстовым параметром и метод, при вызове которого в консольном окне
отображается название класса и значение поля. На основе суперкласса создаются два
подкласса (оба на основе одного и того же суперкласса). В одном из классов появляется
защищенное целочисленное поле, там есть конструктор с двумя параметрами и
переопределен метод для отображения значений полей объекта и названия класса. Во
втором подклассе появляется защищенное символьное поле, конструктор с двумя
параметрами и переопределен метод, отображающий в консоли название класса и
значения полей. В главном методе создайте объекты каждого из классов. Проверьте
работу метода, отображающего значения полей объектов, для каждого из объектов.
Вызовите этот же метод через объектную переменную суперкласса, которая ссылается на
объект производного класса.*/

    public static void main(String[] args) {
        SuperExample5 superObject = new SuperExample5("superText");
        Sub1Example5 sub1Example5 = new Sub1Example5(1,"sub1Text");
        Sub2Example5 sub2Example5 = new Sub2Example5('B', "sub2Text");

        System.out.println(superObject);
        System.out.println();
        System.out.println(sub1Example5);
        System.out.println();
        System.out.println(sub2Example5);
        System.out.println();
    }
}
class SuperExample5 {
    private String textField;

    SuperExample5(String textField) {
        this.textField = textField;
    }

    public String toString() {
        return getClass().getName() + " textField=" + textField + "\n";
    }
}

class Sub1Example5 extends SuperExample5 {
    protected int subNum;

    Sub1Example5(int subNum, String textField) {
        super(textField);
        this.subNum = subNum;
    }

    public String toString() {
        return super.toString() + getClass().getSuperclass().getName() + " subNum=" + subNum;
    }
}

class Sub2Example5 extends SuperExample5 {
    protected char subChar;

    Sub2Example5(char subChar, String textField) {
        super(textField);
        this.subChar = subChar;
    }

    public String toString() {
        return super.toString() + getClass().getSuperclass().getName() + " subChar=" + subChar;
    }
}

