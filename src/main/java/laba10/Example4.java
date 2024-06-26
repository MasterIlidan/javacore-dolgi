package laba10;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
1
Улучшение работы с ошибками. Программы, которые читают Excel файлы, могут
столкнуться с ошибками, такими как неправильный формат файла, отсутствие
запрашиваемого листа и т.д. Улучшение работы с ошибками может включать более
подробные сообщения об ошибках, рекомендации для исправления ошибок и
возможность повторного запуска программы после исправления ошибок.
*/
public class Example4 {
    static Logger log = Logger.getLogger(Example4.class.getName());

    public static void main(String[] args) {
        //String filename = "excel example.xlsx";
        Scanner scanner = new Scanner(System.in);
        log.info("Retrieving file name from user");
        System.out.print("Введите имя Excel файла: ");
        String filename = scanner.nextLine();
        if (!filename.contains(".xlsx")) {
            filename = filename + ".xlsx";
        }
        log.info("Retrieved file name from user: " + filename + "\nTrying to read file");

        try (FileInputStream fileInputStream = new FileInputStream(filename)) {
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            log.info("Retrieved workbook: " + workbook);

            XSSFSheet sheet = null;
            //вывод всех листов
            System.out.println("Список листов: ");
            log.info("Sheet list: ");
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                sheet = workbook.getSheetAt(i);
                System.out.println("-> " + sheet.getSheetName());
                log.info("Sheet #" + i + ": " + sheet.getSheetName());
            }

            sheet = null;

            while (sheet == null) {
                System.out.print("Введите имя листа: ");
                String sheetName = scanner.nextLine();
                sheet = workbook.getSheet(sheetName);
                if (sheet == null) {
                    log.warning("Sheet not found: " + sheetName);
                    System.out.println("Лист " + sheetName + " не найден. Убедитесь, что ввели имя листа правильно или его не существует");
                }
            }

            System.out.println("Выбран лист " + sheet.getSheetName());
            log.info("Sheet selected: " + sheet.getSheetName());

            System.out.println("==========Выводе содержимого листа==========");
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(cell.toString() + "\t");
                }
                System.out.println();
            }
            System.out.println("==========Конец вывода==========");

        } catch (IOException e) {
            log.log(Level.WARNING, "Error occurred while reading file " + filename, e);
            if (e instanceof FileNotFoundException) {
                System.out.println("Ошибка при чтении файла. Убедитесь, что имя файла соответствует введенному и он находится рядом с исполняемым файлом");
            }
        }
    }
}
