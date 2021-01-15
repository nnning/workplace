package com.app;

import java.io.*;
import java.util.*;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

public class ShiftReader {

    static HSSFRow row;
    static Cell cell;

    public Object[] read(File inputFile, String userName) throws Exception {
    	
    	ArrayList<Object> data = new ArrayList<Object>();
        FileInputStream fis = new FileInputStream(inputFile);
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet spreadsheet = workbook.getSheet("List1");
        Iterator<Row> rowIterator = spreadsheet.iterator();
        

        while (rowIterator.hasNext()) {
            row = (HSSFRow) rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            cell = row.getCell(0);

            if (cell.getStringCellValue().trim().equals(userName)) {
               
                while (cellIterator.hasNext()) {
                	Cell c = cellIterator.next();
                	if(c == null || c.getCellType() == Cell.CELL_TYPE_BLANK ) {
                		data.add(null);
                	} else {
                		data.add(c.getStringCellValue());
                	}
                }
            }
        }

        Object[] o = data.toArray();
        return o;
    }
}