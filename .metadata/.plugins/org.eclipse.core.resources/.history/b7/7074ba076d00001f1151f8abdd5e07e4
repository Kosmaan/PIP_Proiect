package ro.tuiasi.ac.Proiect_PIP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Citire {
	Vector<String> profesori = new Vector<String>();
	Vector<String> grupe = new Vector<String>(20);
	
	void citireProfesori() {
		try {
			FileInputStream file = new FileInputStream(
					"C:..\\Utilities\\Info.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet ws = wb.getSheetAt(0);
			
			Iterator<Row> rowIterator = ws.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					profesori.add(cell.getStringCellValue());
				}
			}
			wb.close();
			System.out.println(profesori);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void citireStudenti() {
		try {
			FileInputStream file = new FileInputStream(
					"C:\\1305B\\Proiect-PIP\\Utilities\\Info.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet ws = wb.getSheetAt(1);
			
			Iterator<Row> rowIterator = ws.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					grupe.add(cell.getStringCellValue());
					System.out.println(grupe);
				}
			}
			wb.close();
			//System.out.println(grupe);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}