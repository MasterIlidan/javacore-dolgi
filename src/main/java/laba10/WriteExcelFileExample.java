package laba10;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelFileExample {
    public static void main(String[] args) {
        //Создаем новую книгу Excel
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {


            //Создаем новый лист в книге
            XSSFSheet sheet = workbook.createSheet("Товары");

            //Записываем даннные в ячейки
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Товар");
            headerRow.createCell(1).setCellValue("Характеристики");
            headerRow.createCell(2).setCellValue("Стоимость");

            Row dataRow1 = sheet.createRow(1);
            dataRow1.createCell(0).setCellValue("Книга");
            dataRow1.createCell(1).setCellValue("Жанр: Фантастика, Автор: Иванов И.И.");
            dataRow1.createCell(2).setCellValue(500);

            Row dataRow2 = sheet.createRow(2);
            dataRow2.createCell(0).setCellValue("Компьютер");
            dataRow2.createCell(1).setCellValue("Процессор: Intel Core i5, Оперативная память 8 ГБ");
            dataRow2.createCell(2).setCellValue(25000);

            //Записываем книгу Excel в файл
            String filepath = "./src/main/java/laba10/example.xlsx";
            try (FileOutputStream outputStream = new FileOutputStream(filepath);) {
                workbook.write(outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
