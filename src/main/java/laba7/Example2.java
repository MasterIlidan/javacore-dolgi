package laba7;

public class Example2 {
    /*Напишите программу, в которой есть суперкласс с приватным текстовым полем. В
базовом классе (суперклассе) должен быть метод для присваивания значения полю с
текстовым параметром. Объект суперкласса создается передачей одного текстового
аргумента конструктору. Добавьте метод, который возвращает длину текстовой строки.
На основе суперкласса создается подкласс. В подклассе появляется дополнительное
открытое (публичное) целочисленное поле. В классе должны быть такие версии метода
для присваивания значений полям (используется переопределение и перегрузка метода из
суперкласса): без параметров, с текстовым параметром, с целочисленным параметром, с
текстовым и целочисленным параметром. У конструктора подкласса два параметра
(целочисленный и текстовый).*/

    public static void main(String[] args) {
        SubExample2 subExample2 = new SubExample2("Hello World", 7);

        System.out.println(subExample2);
        System.out.println();

        subExample2.setValue();
        System.out.println(subExample2);
        System.out.println();

        subExample2.setValue(1);
        System.out.println(subExample2);
        System.out.println();

        subExample2.setValue("changed");
        System.out.println(subExample2);
        System.out.println();

        subExample2.setValue(999,"Changed Again");
        System.out.println(subExample2);
        System.out.println();

    }

}

class SuperExample2 {
    private String textField;

    SuperExample2(String textField) {
        this.textField = textField;
    }

    public int getTextFieldLength() {
        return textField.length();
    }

    public void setValue(String textField) {
        this.textField = textField;
    }
}

class SubExample2 extends SuperExample2 {
    public int numField;

    SubExample2(String stringValue, int numValue) {
        super(stringValue);
        this.numField = numValue;
    }

    public void setValue(){
        numField = super.getTextFieldLength();
    }

    public void setValue(String stringValue) {
        super.setValue(stringValue);
    }

    public void setValue(int numValue) {
        numField = numValue;
    }

    public void setValue(int numValue, String stringValue) {
        super.setValue(stringValue);
        numField = numValue;
    }

    public String toString() {
        return "Super class text field length: " + super.getTextFieldLength() +
                "\nNumber value of sub class is:" + numField;
    }
}
