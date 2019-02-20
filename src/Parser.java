import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.FileInputStream;
import java.io.InputStream;

public class Parser {
    public static void main(String[] args) {
        String filePath = "/Users/jerry/Desktop/test.xlsx";
        ExcelTypeEnum excelTypeEnum = ExcelTypeEnum.XLSX;
        BaseExcelListener listener = new KotlinExcelListener();
        processExcel(filePath,excelTypeEnum,listener);
    }

    public static void processExcel(String filePath, ExcelTypeEnum excelTypeEnum, BaseExcelListener listener) {
        try (InputStream inputStream = new FileInputStream(filePath)) {
            ExcelReader excelReader = new ExcelReader(inputStream, excelTypeEnum, null, listener);
            excelReader.read();
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
}
