package ro.tuiasi.ac.Proiect_PIP;


import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Vector;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Citire {
	Vector<String> profesori = new Vector<String>();
	Vector<String> studenti = new Vector<String>();
	Vector<String> grupe = new Vector<String>();
	Vector<String> materii = new Vector<String>();
	
	void citireProfesori() {
		try {
			FileInputStream file = new FileInputStream(
					".\\Utilities\\Info.xlsx");
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
	
	void citireStudenti(int an, String grupa) {
		try {
			int cnt = 0;
			FileInputStream file = new FileInputStream(".\\Utilities\\Info.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet ws = wb.getSheetAt(an);
			
			Iterator<Row> rowIterator = ws.iterator();
			Row row1 = rowIterator.next();
			Iterator<Cell> cellIterator1 = row1.cellIterator();
			Cell cell1 = cellIterator1.next();
			
			while (!(cell1.getStringCellValue().equals(grupa)) && cellIterator1.hasNext()) {
				cell1 = cellIterator1.next();
				cnt++;
			}

			for (Row row : ws) { // For each Row.
				Cell cell = row.getCell(cnt); // Get the Cell at the Index / Column you want.
			    if (cell != null && !cell.getStringCellValue().contains("1") && !cell.getStringCellValue().isEmpty())
			    	studenti.add(cell.getStringCellValue());
			}
			wb.close();
			System.out.println(studenti);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void citireMaterii() {
		try {
			FileInputStream file = new FileInputStream(".\\Utilities\\Info.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet ws = wb.getSheetAt(5);
		
			for (Row row : ws) { // For each Row.
				Cell cell = row.getCell(0); // Get the Cell at the Index / Column you want.
				materii.add(cell.getStringCellValue());
			
			}
		wb.close();
		System.out.println(materii);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	void citireGrupe(int an) {
		try {
			FileInputStream file = new FileInputStream(".\\Utilities\\Info.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet ws = wb.getSheetAt(an);
			
			Iterator<Row> rowIterator = ws.iterator();
			Row row1 = rowIterator.next();
			Iterator<Cell> cellIterator = row1.cellIterator();
			
			grupe.clear();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				grupe.add(cell.getStringCellValue());
			}
			wb.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}