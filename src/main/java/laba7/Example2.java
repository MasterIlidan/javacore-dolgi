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

    public void setTextField(String textField) {
        this.textField = textField;
    }
}

class SubExample2 extends SuperExample2 {
    public int length;

    SubExample2(String textField,) {
        super(textField);
    }
}
