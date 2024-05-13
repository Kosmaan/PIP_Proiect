package ro.tuiasi.ac.Proiect_PIP;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class Test {
	void Testul() throws FileNotFoundException, IOException, InvalidFormatException {
		XWPFDocument doc = new XWPFDocument(OPCPackage.open(".\\Utilities\\Document.docx"));
		for (XWPFParagraph p : doc.getParagraphs()) {
		    List<XWPFRun> runs = p.getRuns();
		    if (runs != null) {
		        for (XWPFRun r : runs) {
		            String text = r.getText(0);
		            if (text != null && text.contains("Carlos-Mihai Pascal")) {
		                text = text.replace("Carlos-Mihai Pascal", "Cristi");
		                r.setText(text, 0);
		            }
		        }
		    }
		}
		for (XWPFTable tbl : doc.getTables()) {
		   for (XWPFTableRow row : tbl.getRows()) {
		      for (XWPFTableCell cell : row.getTableCells()) {
		         for (XWPFParagraph p : cell.getParagraphs()) {
		            for (XWPFRun r : p.getRuns()) {
		              String text = r.getText(0);
		              if (text != null && text.contains("Carlos-Mihai Pascal")) {
		                text = text.replace("Carlos-Mihai Pascal", "Cristi");
		                r.setText(text,0);
		              }
		            }
		         }
		      }
		   }
		}
		doc.write(new FileOutputStream("output.docx"));
	}
}