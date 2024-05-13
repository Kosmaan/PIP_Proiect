package ro.tuiasi.ac.Proiect_PIP;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

public class Scriere {
	private XWPFDocument replaceText(XWPFDocument doc, String originalText, String updatedText) {
		replaceTextInParagraphs(doc.getParagraphs(), originalText, updatedText);
		for (XWPFTable tbl : doc.getTables()) {
	        for (XWPFTableRow row : tbl.getRows()) {
	            for (XWPFTableCell cell : row.getTableCells()) {
	                replaceTextInParagraphs(cell.getParagraphs(), originalText, updatedText);
	            }
	        }
	    }
	    return doc;
	}
	
	private void replaceTextInParagraphs(List<XWPFParagraph> paragraphs, String originalText, String updatedText) {
	    paragraphs.forEach(paragraph -> replaceTextInParagraph(paragraph, originalText, updatedText));
	}
	
	private void replaceTextInParagraph(XWPFParagraph paragraph, String originalText, String updatedText) {
	    List<XWPFRun> runs = paragraph.getRuns();
	    for (XWPFRun run : runs) {
	        String text = run.getText(0);
	        if (text != null && text.contains(originalText)) {
	            String updatedRunText = text.replace(originalText, updatedText);
	            run.setText(updatedRunText, 0);
	        }
	    }
	}
	
	private void saveFile(String filePath, XWPFDocument doc) throws IOException {
	    try (FileOutputStream out = new FileOutputStream(filePath)) {
	        doc.write(out);
	        out.close();
	        doc.close();
	    }
	}
	
	void replaceText() {
		try {
			String filePath = ".\\Utilities\\Document.docx";
			FileInputStream inputStream = new FileInputStream(filePath);
			System.out.println("Cristi");
			XWPFDocument doc = new XWPFDocument(inputStream);

			doc = replaceText(doc, "Carlos-Mihai Pascal", "Ticlosul");
			saveFile(filePath, doc);
			doc.close();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
