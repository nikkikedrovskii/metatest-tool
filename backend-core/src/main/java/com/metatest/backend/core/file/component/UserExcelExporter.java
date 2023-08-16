package com.metatest.backend.core.file.component;

import com.metatest.backend.core.file.domain.TestStrategy;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserExcelExporter {

    private void writeHeaderLine(XSSFSheet sheet, XSSFWorkbook workbook) {

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Name", style,sheet);
        createCell(row, 1, "Priority", style, sheet);
        createCell(row, 2, "Conditions", style, sheet);
        createCell(row, 3, "Stages of execution", style, sheet);
        createCell(row, 4, "Result", style, sheet);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style,XSSFSheet sheet) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines(XSSFSheet sheet, List<TestStrategy> testStrategies, XSSFWorkbook workbook) {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (TestStrategy strategy : testStrategies) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, strategy.getId(), style, sheet);
            createCell(row, columnCount++, strategy.getDescription(), style, sheet);
            createCell(row, columnCount++, strategy.getConditions(), style, sheet);
            createCell(row, columnCount++, strategy.getSteps(), style, sheet);
            createCell(row, columnCount++, strategy.getOutput(), style, sheet);

        }
    }

    public void export(HttpServletResponse response, List<TestStrategy> testStrategies) throws IOException {
      //  var path = "D:/meta/metatest-tool/file_" + UUID.randomUUID()+ ".xlsx";
        var workbook = new XSSFWorkbook();
        var sheet = workbook.createSheet("TestStrategy");

        writeHeaderLine(sheet,workbook);
        writeDataLines(sheet,testStrategies, workbook);

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);

/*        try (FileOutputStream fos = new FileOutputStream(path)) {
            workbook.write(fos);
        }*/

        workbook.close();
        outputStream.close();

    }
}
