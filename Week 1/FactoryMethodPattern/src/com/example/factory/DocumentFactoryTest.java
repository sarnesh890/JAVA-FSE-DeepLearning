package com.example.factory;

import java.util.*;

public class DocumentFactoryTest {
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Which document would you like to open? (word/pdf/excel): ");
    	String input = sc.nextLine().toLowerCase();
    	switch(input) {
    	case "word":
    		DocumentFactory wordFactory = new WordDocumentFactory();
    		Document wordDoc = wordFactory.createDocument();
    		wordDoc.open();
    		break;
    	case "pdf":
    		DocumentFactory pdfFactory = new PdfDocumentFactory();
    		Document pdfDoc = pdfFactory.createDocument();
    		pdfDoc.open();
    		break;
    	case "excel":
    		DocumentFactory excelFactory = new ExcelDocumentFactory();
    		Document excelDoc = excelFactory.createDocument();
    		excelDoc.open();
    		break;
    	default:
    		System.out.println("Invalid input. Please enter 'word', 'pdf', or 'excel'.");
    		sc.close();
    		return;
    	}
    	sc.close();
    }
}


