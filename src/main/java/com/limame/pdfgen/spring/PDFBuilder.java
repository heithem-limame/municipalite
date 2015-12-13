package com.limame.pdfgen.spring;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class PDFBuilder extends AbstractITextPdfView {
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get data model which is passed by the Spring container

		//doc.add(new Paragraph("Releve de Naissance"));
		
//		final PdfPTable table = new PdfPTable(6);
//		table.setWidthPercentage(100.0f);
//		table.setWidths(new float[] { 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f });
//		table.setSpacingBefore(10);
//
//		// define font for table header row
//		final Font font = FontFactory.getFont(FontFactory.HELVETICA);
//		font.setColor(BaseColor.WHITE);
//
//		// define table header cell
//		final PdfPCell cell = new PdfPCell();
//		cell.setBackgroundColor(BaseColor.BLUE);
//		cell.setPadding(5);
//
//		// write table header
//		cell.setPhrase(new Phrase("nom", font));
//		table.addCell(cell);
//
//		cell.setPhrase(new Phrase("prenom", font));
//		table.addCell(cell);
//
//		cell.setPhrase(new Phrase("dateNaissance", font));
//		table.addCell(cell);
//		cell.setPhrase(new Phrase("lieuNaissance", font));
//		table.addCell(cell);
//
//		cell.setPhrase(new Phrase("nomPere", font));
//		table.addCell(cell);
//
//		cell.setPhrase(new Phrase("nomMere", font));
//		table.addCell(cell);
//
//		// write table row data
//		for (final Book aBook : listBooks) {
//			table.addCell(aBook.getTitle());
//			table.addCell(aBook.getAuthor());
//			table.addCell(aBook.getIsbn());
//			table.addCell(aBook.getPublishedDate());
//			table.addCell(String.valueOf(aBook.getPrice()));
//		}
//
//		doc.add(table);
		
		
		
		
		
		

	}

}
