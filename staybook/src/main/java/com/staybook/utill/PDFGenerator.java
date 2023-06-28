package com.staybook.utill;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.staybook.model.Person;

public class PDFGenerator {
	
	List<Person> personsList;
	
	public static ByteArrayInputStream customerPDFReport(List<Person> persons) {
		
		Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
		
try {
        	
        	PdfWriter.getInstance(document, out);
            document.open();
        	
			// Add Text to PDF file ->
			Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, BaseColor.BLACK);
			Paragraph para = new Paragraph( "Person Table", font);
			para.setAlignment(Element.ALIGN_CENTER);
			
			document.add(para);
			document.add(Chunk.NEWLINE);
			
        	PdfPTable table = new PdfPTable(7);
        	// Add PDF Table Header ->
			Stream.of("Person ID", "Person Name", "Person Father Name", "Phone Number", "Pan Number", "Aadhaar Number", "Voter Id")
			    .forEach(headerTitle -> {
			          PdfPCell header = new PdfPCell();
			          Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			          header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			          header.setHorizontalAlignment(Element.ALIGN_CENTER);
			          header.setBorderWidth(1);
			          
			          header.setPhrase(new Phrase(headerTitle, headFont));
			          table.addCell(header);
			    });
            
            for (Person person : persons) {
            	PdfPCell idCell = new PdfPCell(new Phrase(person.getPersonId().toString()));
            	idCell.setPaddingLeft(4);
            	idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(idCell);

                PdfPCell personNameCell = new PdfPCell(new Phrase(person.getPersonName()));
                personNameCell.setPaddingLeft(4);
                personNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                personNameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(personNameCell);

                PdfPCell personFatherNameCell = new PdfPCell(new Phrase(String.valueOf(person.getPersonFatherName())));
                personFatherNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                personFatherNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                personFatherNameCell.setPaddingRight(4);
                table.addCell(personFatherNameCell);
                
                PdfPCell phoneNumberCell = new PdfPCell(new Phrase(String.valueOf(person.getPhoneNumber())));
                phoneNumberCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                phoneNumberCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                phoneNumberCell.setPaddingRight(4);
                table.addCell(phoneNumberCell);
                
                PdfPCell panNumberCell = new PdfPCell(new Phrase(String.valueOf(person.getPanNumber())));
                panNumberCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                panNumberCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                panNumberCell.setPaddingRight(4);
                table.addCell(panNumberCell);
                
                PdfPCell aadharNumberCell = new PdfPCell(new Phrase(String.valueOf(person.getAadhaarNumber())));
                aadharNumberCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                aadharNumberCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                aadharNumberCell.setPaddingRight(4);
                table.addCell(aadharNumberCell);
                
                PdfPCell voterIdCell = new PdfPCell(new Phrase(String.valueOf(person.getVoterId())));
                voterIdCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                voterIdCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                voterIdCell.setPaddingRight(4);
                table.addCell(voterIdCell);
              
            }
            document.add(table);
            
            document.close();
        }catch(DocumentException e) {
        	
        }
        
		return new ByteArrayInputStream(out.toByteArray());
	} 
	

}
