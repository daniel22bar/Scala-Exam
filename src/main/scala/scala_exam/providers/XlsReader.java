package scala_exam.providers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * A dirty simple program that reads an Excel file.
 * @author www.codejava.net
 *
 */
 class XlsReader {
    @SneakyThrows
    public Iterator<Row> getXlsFile(String excelFilePath) {

        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new HSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
        return iterator;
    }

}