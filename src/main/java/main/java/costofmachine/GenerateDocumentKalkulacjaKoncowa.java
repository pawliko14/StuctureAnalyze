package main.java.costofmachine;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import costofmachine.AfterCalculationsStrukture;
import main.java.Parameters.Parameters;
import main.java.Objetcs.Struktury;

public class GenerateDocumentKalkulacjaKoncowa {

	
	 private static DecimalFormat decForm = new DecimalFormat("#.###");
//	 private static ArrayList<String> temporaryList;	 
//	 private static ArrayList<String> temporaryListofMainProjects;
	
	 private static ArrayList<String> temporaryListofMainProjects;	 

	
	 GenerateDocumentKalkulacjaKoncowa()
	{
		
	}
	
	public void Generate(ArrayList<AfterCalculationsStrukture> tescik, Connection conn, String Maszynka ) throws DocumentException, SQLException, IOException
	{
		temporaryListofMainProjects = new ArrayList<String>();

		
		
		System.out.println("search for existing getter methods in object:");
		Method[] methodstemporary = tescik.get(0).getClass().getMethods();	// take first element, it does not matter
		List<String> ListOfMethods = new ArrayList<String>();
		for(Method m : methodstemporary)
		{
			if(m.getName().startsWith("get") && m.getParameterTypes().length == 0 && !m.getName().equals("getClass")) {
				ListOfMethods.add(m.getName());
			}
		}
		for(int i = 0 ; i< ListOfMethods.size();i++)
		{
			System.out.println("method :" + i + "  -> " + ListOfMethods.get(i));
		}
		
		
		//Font fontH1 = new Font(Currier, 16, Font.NORMAL);


		 String dest = Parameters.getPathOfSavingAnaliza_Maszyn_kalkulacjaKoncowaPDF();
		 PdfPTable table = null;
		 PdfPTable table1 = null;

		System.out.println("\ngenerowanie PDf1\n");
		// GENEROWANIE DOKUMENTU PDF
	    Document document = new Document(PageSize.A1.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(dest));
       
       
     //  temporaryList = new ArrayList<String>();
    //   temporaryListofMainProjects= new ArrayList<String>();
       
           document.open();

		   document.add(new Paragraph("Data wygenerowania raportu: "+new Date().toString()));
		   document.add(new Paragraph("\n\n"));
       
		   
		   
		   	table = new PdfPTable(new float[] {110,110,110,210,210,110,110,110,110,110,110,110,110,110});
		   	table.setTotalWidth(1740);
		   	table.setLockedWidth(true);
		//	  table.setHorizontalAlignment(Element.ALIGN_RIGHT);

   		  BaseFont bf = BaseFont.createFont(
                     BaseFont.TIMES_ROMAN,
                     BaseFont.CP1252,
                     BaseFont.EMBEDDED
                     );
             Font font = new Font(bf, 14);
 
             
             
             
             
		        // header row:
		        table.addCell(new PdfPCell(new Phrase("DOSTAWCA",font)));
		        table.addCell(new PdfPCell(new Phrase("NUMER ZAMOWIENIA",font)));
		        table.addCell(new PdfPCell(new Phrase("SEKWENCJA ZAMOWIENIA",font)));
		        table.addCell(new PdfPCell(new Phrase("KOD ARTYKULU",font)));		       
		        table.addCell(new PdfPCell(new Phrase("OPIS ARTYKULU",font)));
		        table.addCell(new PdfPCell(new Phrase("ZAMOWIONYCH",font)));
		        table.addCell(new PdfPCell(new Phrase("DOSTARCZONYCH",font)));
		        table.addCell(new PdfPCell(new Phrase("DATA ZAMOWIENIA",font)));
		        table.addCell(new PdfPCell(new Phrase("DATA DOSTARCZENIA",font)));
		        table.addCell(new PdfPCell(new Phrase("DATA DOSTARCZENIA RZECZ",font)));
		        table.addCell(new PdfPCell(new Phrase("DATA ZAKSIEGOANIA",font)));
		        table.addCell(new PdfPCell(new Phrase("CENA JEDNOSTKOWA",font)));
		        table.addCell(new PdfPCell(new Phrase("WALUTA",font)));
		        table.addCell(new PdfPCell(new Phrase("CENA JEDNOSTKOWA * ILOSC",font)));


		        
		       // table.setHeaderRows(1);
		        
		        
		        PdfPCell table_cell1 = new PdfPCell(new Phrase("1",font));
				table.addCell(table_cell1);
				
				PdfPCell table_cell2 = new PdfPCell(new Phrase(" ",font));
				table.addCell(table_cell2);
				
				PdfPCell table_cell3 = new PdfPCell(new Phrase("",font));
				table.addCell(table_cell3);
				
				PdfPCell table_cell4 = new PdfPCell(new Phrase("",font));
				table.addCell(table_cell4);
				
				PdfPCell table_cell5 = new PdfPCell(new Phrase("",font));
				table.addCell(table_cell5);
				
				PdfPCell table_cell6 = new PdfPCell(new Phrase("",font));
				table.addCell(table_cell6);
				
				PdfPCell table_cell7 = new PdfPCell(new Phrase("",font));
				table.addCell(table_cell7);
				
				PdfPCell table_cell8 = new PdfPCell(new Phrase("",font));
				table.addCell(table_cell8);
				
				PdfPCell table_cell10 = new PdfPCell(new Phrase("",font));
				table.addCell(table_cell10);
				
				PdfPCell table_cel11 = new PdfPCell(new Phrase("",font));
				table.addCell(table_cel11);
				
				PdfPCell table_cell12 = new PdfPCell(new Phrase("",font));
				table.addCell(table_cell12);
				
				PdfPCell table_cell13= new PdfPCell(new Phrase("",font));
				table.addCell(table_cell13);
				
				PdfPCell table_cell14= new PdfPCell(new Phrase(""));
				table.addCell(table_cell14);
				
	
		      	    		
		        document.add(table);
		        
		   //       table1 = new PdfPTable(new float[] {30,550,400,85,85,85,85,85,85,40});
		        float[] tab = {110,110,110,210,210,110,110,110,110,110,110,110,110,110};
			   	table1 = new PdfPTable(tab);
			   	table1.setTotalWidth(1740);
			   	table1.setLockedWidth(true);
		        
			   			   	
			   	
			
	   	for(int i = 0 ; i < tescik.size();i++)
		  	{
			   		temporaryListofMainProjects.add(tescik.get(i).getMONTAGEOMSCHRIJVING()); // dodaje najwyzsze zlozenie do listy,
		   			
		   		if(!tescik.get(i).getMONTAGEOMSCHRIJVING().isEmpty() || !tescik.get(i).getMONTAGEOMSCHRIJVING().equals(null) || !tescik.get(i).getMONTAGEOMSCHRIJVING().equals(""))
		   		{
		   				
		   			
		   			if(temporaryListofMainProjects.size() >=2 && temporaryListofMainProjects.get(temporaryListofMainProjects.size()-2).equals(tescik.get(i).getMONTAGEOMSCHRIJVING()))
	   				{	   	
		   		//		System.out.println("test, iter: +"+ i +" ->"+ tescik.get(i).getMONTAGEOMSCHRIJVING() + " artykul : -> "+ tescik.get(i).getARTIKELCODE());
		   				int xyz = 1;
//	   				 c1 += roznica*(List.get(i).getPoziom()+ 1);
//		   			 c2 += roznica*(List.get(i).getPoziom()+ 1);
//		   			 c3 += roznica*(List.get(i).getPoziom()+ 1);			   			   					
	   				}
	   				else
	   				{
	   	              Font font_main_project = new Font(bf, 23);

	   	           int   f12 = 0;
	   	           int   f22 = 0;
	   	           int   f32 = 0;
	   	     
	   				 font_main_project.setColor(f12,f22,f32);    
	   					
		   				// jesli jest poziom 0 to tez znajdzie sie projekt nadrzedny
	   		            
	   				   document.add(new Paragraph("\n\n"));

		   			PdfPTable table00;
		   			table00 = new PdfPTable(new float[] {1740});
		   			table00.setTotalWidth(1740);
		   			table00.setLockedWidth(true);
		   			//table00.setHorizontalAlignment(Element.ALIGN_RIGHT);

		   			
		   		 PdfPCell cell00 = new PdfPCell(new Phrase("PROCES MONTAZOWY  "+ tescik.get(i).getMONTAGEOMSCHRIJVING(),font_main_project));
		   	//	 table_cell0000.setBackgroundColor(new BaseColor(c1, c2, c3)); 
		   		 cell00.setHorizontalAlignment(Element.ALIGN_CENTER);
		   		 table00.addCell(cell00);
		   			
				
	   			
				document.add(table00);
		   			
				
//				 c1 += roznica*(List.get(i).getPoziom()+ 1);
//	   			 c2 += roznica*(List.get(i).getPoziom()+ 1);
//	   			 c3 += roznica*(List.get(i).getPoziom()+ 1);
				
				   	table1 = new PdfPTable(tab);
				   	table1.setTotalWidth(1740);
				   	table1.setLockedWidth(true);
	   				}	
		   		}
		   			
		   			// methods to create structure of certain article 
		   		
		   			/*
		   			 * 1. sprawdenie dla KAZDEGO artykulu czy jest jakies zlozenie ( jesli jest P lub F to prawodopobnie bedzie jakies nastepen zlozenie
		   			 * 2. jesli artykulem bedzie Y, wtedy mam pewnosc ze dalej nie ma juz innych zlozen
		   			 * 3. WYKORZYSTAC ISTNIEJACY KOD Z Counmaterialtest
		   			 * 
		   			 */
		   			
		   		
		   		//if(tecik.get(i).get)
		   			
		   			
		   			
		   			
		   			
			   		
			   		
					PdfPCell cell01 = new PdfPCell(new Phrase(tescik.get(i).getLeverancier().toString(),font));
					cell01.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell01);
					
					PdfPCell cell02 = new PdfPCell(new Phrase(tescik.get(i).getORDERNUMMER().toString(),font));
					cell02.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell02);
					
					PdfPCell cell03 = new PdfPCell(new Phrase(tescik.get(i).getSEQUENTIE().toString(),font));
					cell03.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell03);
					
					PdfPCell cell04 = new PdfPCell(new Phrase(tescik.get(i).getARTIKELCODE().toString(),font));
					cell04.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell04);
					
					PdfPCell cell05 = new PdfPCell(new Phrase(tescik.get(i).getARTIKELOMSCHRIJVING().toString(),font));
					cell05.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell05);
					
					PdfPCell cell06 = new PdfPCell(new Phrase(tescik.get(i).getBESTELD().toString(),font));
					cell06.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell06);
					
					PdfPCell cell07 = new PdfPCell(new Phrase(tescik.get(i).getGELEVERD().toString(),font));
					cell07.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell07);
					
					
				
					//	PdfPCell cell08 = new PdfPCell(new Phrase(tescik.get(i).getBESTELDATUM().toString(),font)); // <- potencjalny blad
					PdfPCell cell08 = new PdfPCell(new Phrase("-",font));
						cell08.setHorizontalAlignment(Element.ALIGN_CENTER);
						table1.addCell(cell08);
					
					if(tescik.get(i).getLEVERDATUM().equals(" ") || tescik.get(i).getLEVERDATUM().equals(null))
					{
						PdfPCell cell09 = new PdfPCell(new Phrase("-",font));
						cell09.setHorizontalAlignment(Element.ALIGN_CENTER);
						table1.addCell(cell09);
					}
					else
					{
						PdfPCell cell09 = new PdfPCell(new Phrase(tescik.get(i).getLEVERDATUM().toString(),font));
						cell09.setHorizontalAlignment(Element.ALIGN_CENTER);
						table1.addCell(cell09);
					}
					
					PdfPCell cell10 = new PdfPCell(new Phrase(tescik.get(i).getLEVERINGSDATUMEFFECTIEF().toString(),font));
					cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell10);
					
					PdfPCell cell11 = new PdfPCell(new Phrase(tescik.get(i).getLEVERINGSDATUMINGAVERECEPTIE().toString(),font));
					cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell11);
					
					PdfPCell cell12 = new PdfPCell(new Phrase(tescik.get(i).getEENHEIDSPRIJS().toString(),font));
					cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell12);
					
					PdfPCell cell13 = new PdfPCell(new Phrase(tescik.get(i).getMUNT().toString(),font));
					cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell13);
					
					PdfPCell cell14 = new PdfPCell(new Phrase(tescik.get(i).getTOTAAL().toString(),font));
					cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell14);
					
			        document.add(table1);
			        table1.flushContent();
			   }
	        		

//		   for(int i = 0 ; i <tescik.size() ; i++)
//		   {
//			   // change font color depending on interation of deepth
//			   
//			   int f1 = 0;
//			   int f2 = 0;
//			   int f3 = 0;
//			   
//	            font.setColor(f1,f2,f3);    
//			   
//				int c1= 90; // dark grey color
//				int	c2= 90; 
//				int	c3= 90;
//				int roznica = 20;  // color differential while digggin into structure
//
//			   
//			   
//		   		if(tescik.get(i).getPoziom()==0)
//					{
//		   			 c1= c1;
//		   			 c2= c2; 
//		   			 c3= c3;
//		   			
//		   			temporaryList.add(tescik.get(i).getARTIKELCODE()); // dodaje najwyzsze zlozenie do listy,
//		   			
//		   			
//		   			
//		   		//Check if the primal projects occurs multipletimes, if yes add only once(when item occurred for the first time) to temporaryListofMainProjects   				
//	   				temporaryListofMainProjects.add(tescik.get(i).getGlownyProjekt()); // add item(main project, equvalnt of 190521 or 170700 etc) from list
//	   				if(temporaryListofMainProjects.size() >=2 && temporaryListofMainProjects.get(temporaryListofMainProjects.size()-2).equals(tescik.get(i).getGlownyProjekt()))
//	   				{	   					
//	   				 c1 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 c2 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 c3 += roznica*(tescik.get(i).getPoziom()+ 1);			   			   					
//	   				}
//	   				else
//	   				{
//	   	              Font font_main_project = new Font(bf, 23);
//
//	   	           int   f12 = 254;
//	   	           int   f22 = 254;
//	   	           int   f32 = 254;
//	   	     
//	   				 font_main_project.setColor(f12,f22,f32);    
//	   					
//		   				// jesli jest poziom 0 to tez znajdzie sie projekt nadrzedny
//	   		            
//	   				   document.add(new Paragraph("\n\n"));
//
//		   			PdfPTable table00;
//		   			table00 = new PdfPTable(new float[] {1600});
//		   			table00.setTotalWidth(1600);
//		   			table00.setLockedWidth(true);
//		   			table00.setHorizontalAlignment(Element.ALIGN_RIGHT);
//
//		   			
//		   		 PdfPCell table_cell0000 = new PdfPCell(new Phrase("PROJEKT NADRZEDNY : "+ tescik.get(i).getGlownyProjekt(),font_main_project));
//		   		 table_cell0000.setBackgroundColor(new BaseColor(c1, c2, c3)); 
//		   		 table_cell0000.setHorizontalAlignment(Element.ALIGN_CENTER);
//		   		 table00.addCell(table_cell0000);
//		   			
//				
//	   			
//				document.add(table00);
//		   			
//				
//				 c1 += roznica*(tescik.get(i).getPoziom()+ 1);
//	   			 c2 += roznica*(tescik.get(i).getPoziom()+ 1);
//	   			 c3 += roznica*(tescik.get(i).getPoziom()+ 1);
//				
//		   		  table1 = new PdfPTable(new float[] {30,550,400,85,85,85,85,85,85,40});
//	    		  table1.setTotalWidth(1530);
//	    		  table1.setLockedWidth(true);
//	   				}	   			
//		   			
//		   			if(temporaryList.size() >= 2 && temporaryList.get(temporaryList.size()-2).equals(tescik.get(i).getARTIKELCODE()))   			
//		   			{
//			   		//	System.out.println("Temporary val last el: " + temporaryList.get(temporaryList.size()-2) + "  Normal list [i] element: " +  List.get(i).getARTIKELCODE());
//			   			
//		   				
//						 c1 += roznica*(tescik.get(i).getPoziom()+ 1);
//			   			 c2 += roznica*(tescik.get(i).getPoziom()+ 1);
//			   			 c3 += roznica*(tescik.get(i).getPoziom()+ 1);	
//			   			
//			   		  table1 = new PdfPTable(new float[] {30,550,400,85,85,85,85,85,85,40});
//		    		  table1.setTotalWidth(1530);
//		    		  table1.setLockedWidth(true);
//		    		  
//		   			}
//		   			else
//		   			{		   				   				
//				   			
//				   				// jesli jest poziom 0 to tez znajdzie sie projekt nadrzedny
//				   			PdfPTable table0;
//				   			table0 = new PdfPTable(new float[] {30,600,400,85,85,85,85,85,85,40});
//				   			table0.setTotalWidth(1580);
//				   			table0.setLockedWidth(true);
//				   			table0.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		
//				   			
//				   		 PdfPCell table_cell000 = new PdfPCell(new Phrase("ZG",font));
//				   		 table_cell000.setBackgroundColor(new BaseColor(c1, c2, c3)); 
//				   		table_cell000.setHorizontalAlignment(Element.ALIGN_CENTER);
//				   		 table0.addCell(table_cell000);
//				   			
//		   		   	  	PdfPCell table_cell01 = new PdfPCell(new Phrase(tescik.get(i).getARTIKELCODE(),font));
//		   		   	  	table_cell01.setHorizontalAlignment(Element.ALIGN_CENTER);
//		   		   	  	table_cell01.setBackgroundColor(new BaseColor(c1, c2, c3));
//		   		   	  	table0.addCell(table_cell01);
//						
//						PdfPCell table_cell02 = new PdfPCell(new Phrase(GetCfomsendreel(conn,tescik.get(i).getGlownyProjekt(),tescik.get(i).getARTIKELCODE()),font));
//		   		   	 // 	PdfPCell table_cell02 = new PdfPCell(new Phrase(List.get(i).getCFOMSONDERDEEL(),font));
//		   		   	  	table_cell02.setHorizontalAlignment(Element.ALIGN_CENTER);
//		   		   	  	table_cell02.setBackgroundColor(new BaseColor(c1, c2, c3));
//						table0.addCell(table_cell02);
//						
//						PdfPCell table_cell03 = new PdfPCell(new Phrase(tescik.get(i).getILOSC().toString(),font));
//		   		   	  	table_cell03.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table_cell03.setBackgroundColor(new BaseColor(c1, c2, c3));
//						table0.addCell(table_cell03);
//						
//						PdfPCell table_cell04 = new PdfPCell(new Phrase(tescik.get(i).getJEDNOSTKA(),font));
//		   		   	  	table_cell04.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table_cell04.setBackgroundColor(new BaseColor(c1, c2, c3));
//						table0.addCell(table_cell04);
//						
//						if(tescik.get(i).getCenaMaterialu().equals(" ") || tescik.get(i).getCenaMaterialu().equals(null))
//						{
//							PdfPCell table_cell05 = new PdfPCell(new Phrase("--",font));
//							table_cell05.setBackgroundColor(new BaseColor(c1, c2, c3));
//			   		   	  	table_cell05.setHorizontalAlignment(Element.ALIGN_CENTER);
//							table0.addCell(table_cell05);
//						}
//						else
//						{
//							PdfPCell table_cell05 = new PdfPCell(new Phrase(decForm.format(tescik.get(i).getCenaMaterialu()),font));
//							table_cell05.setBackgroundColor(new BaseColor(c1, c2, c3));
//			   		   	  	table_cell05.setHorizontalAlignment(Element.ALIGN_CENTER);
//							table0.addCell(table_cell05);
//						}
//				
//						if(tescik.get(i).getCenaMaterialuRazyIlosc().equals(" ") || tescik.get(i).getCenaMaterialuRazyIlosc().equals(null))
//						{
//							PdfPCell table_cell06 = new PdfPCell(new Phrase("--",font));
//							table_cell06.setBackgroundColor(new BaseColor(c1, c2, c3));
//			   		   	  	table_cell06.setHorizontalAlignment(Element.ALIGN_CENTER);
//							table0.addCell(table_cell06);
//						}
//						else
//						{
//							PdfPCell table_cell06 = new PdfPCell(new Phrase(decForm.format(tescik.get(i).getCenaMaterialuRazyIlosc()),font));
//							table_cell06.setBackgroundColor(new BaseColor(c1, c2, c3));
//			   		   	  	table_cell06.setHorizontalAlignment(Element.ALIGN_CENTER);
//							table0.addCell(table_cell06);
//						}
//						if(tescik.get(i).getCenaPracy().equals(" ") || tescik.get(i).getCenaPracy().equals(null))
//						{
//							PdfPCell table_cell07 = new PdfPCell(new Phrase("--",font));
//							table_cell07.setBackgroundColor(new BaseColor(c1, c2, c3));
//			   		   	  	table_cell07.setHorizontalAlignment(Element.ALIGN_CENTER);
//							table0.addCell(table_cell07);
//						}
//						else
//						{
//							PdfPCell table_cell07 = new PdfPCell(new Phrase(decForm.format(tescik.get(i).getCenaPracy()),font));
//							table_cell07.setBackgroundColor(new BaseColor(c1, c2, c3));
//			   		   	  	table_cell07.setHorizontalAlignment(Element.ALIGN_CENTER);
//							table0.addCell(table_cell07);
//						}
//						if(tescik.get(i).getCenaPracyRazyIlosc() == null || tescik.get(i).getCenaPracyRazyIlosc().equals(null))
//						{
//							PdfPCell table_cell08 = new PdfPCell(new Phrase("--",font));
//							table_cell08.setBackgroundColor(new BaseColor(c1, c2, c3));
//			   		   	  	table_cell08.setHorizontalAlignment(Element.ALIGN_CENTER);
//							table0.addCell(table_cell08);
//						}
//						else
//						{							
//							PdfPCell table_cell08 =  new PdfPCell(new Phrase(decForm.format(tescik.get(i).getCenaPracyRazyIlosc()),font));;
//							table_cell08.setBackgroundColor(new BaseColor(c1, c2, c3));
//			   		   	  	table_cell08.setHorizontalAlignment(Element.ALIGN_CENTER);
//							table0.addCell(table_cell08);
//						}
//						PdfPCell table_cell09 = new PdfPCell(new Phrase(tescik.get(i).getTYP()));
//						table_cell09.setBackgroundColor(new BaseColor(c1, c2, c3));
//		   		   	  	table_cell09.setHorizontalAlignment(Element.ALIGN_CENTER);
//						table0.addCell(table_cell09);
//				   			
//						document.add(table0);
//				   			
//						
//						 c1 += roznica*(tescik.get(i).getPoziom()+ 1);
//			   			 c2 += roznica*(tescik.get(i).getPoziom()+ 1);
//			   			 c3 += roznica*(tescik.get(i).getPoziom()+ 1);
//						
//				   		  table1 = new PdfPTable(new float[] {30,550,400,85,85,85,85,85,85,40});
//			    		  table1.setTotalWidth(1530);
//			    		  table1.setLockedWidth(true);
//					}
//						}
//		   		else if(tescik.get(i).getPoziom()==1)
//		   		{
//					 c1 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 c2 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 c3 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 
//		   			 f1 = 0;
//		   			 f2 = 0;
//		   			 f3 = 0;
//
//		   			
//		   		  table1 = new PdfPTable(new float[] {30,500,400,85,85,85,85,85,85,40});
//	    		  table1.setTotalWidth(1480);
//	    		  table1.setLockedWidth(true);
//		   		}
//		   		else if(tescik.get(i).getPoziom()==2)
//		   		{
//					 c1 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 c2 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 c3 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 
//		   			 f1 = 0;
//		   			 f2 = 0;
//		   			 f3 = 0;
//		   			 
//		   		  table1 = new PdfPTable(new float[] {30,450,400,85,85,85,85,85,85,40});
//	    		  table1.setTotalWidth(1430);
//	    		  table1.setLockedWidth(true);
//		   		}
//		   		else if(tescik.get(i).getPoziom()==3)
//		   		{
//					 c1 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 c2 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 c3 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 
//		   			 f1 = 0;
//		   			 f2 = 0;
//		   			 f3 = 0;
//		   			 
//		   		  table1 = new PdfPTable(new float[] {30,400,400,85,85,85,85,85,85,40});
//	    		  table1.setTotalWidth(1380);
//	    		  table1.setLockedWidth(true);
//		   		}
//		   		else if(tescik.get(i).getPoziom()==4)
//		   		{
//					 c1 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 c2 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 c3 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 
//		   			 f1 = 0;
//		   			 f2 = 0;
//		   			 f3 = 0;
//		   		  table1 = new PdfPTable(new float[] {30,350,400,85,85,85,85,85,85,40});
//	    		  table1.setTotalWidth(1330);
//	    		  table1.setLockedWidth(true);
//		   		}
//		   		else if(tescik.get(i).getPoziom()==5)
//		   		{
//					 c1 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 c2 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 c3 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 
//		   			 f1 = 0;
//		   			 f2 = 0;
//		   			 f3 = 0;
//		   		  table1 = new PdfPTable(new float[] {30,300,400,85,85,85,85,85,85,40});
//	    		  table1.setTotalWidth(1280);
//	    		  table1.setLockedWidth(true);
//		   		}
//		   		else if(tescik.get(i).getPoziom()==6)
//		   		{
//					 c1 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 c2 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 c3 += roznica*(tescik.get(i).getPoziom()+ 1);
//
//		   			 f1 = 0;
//		   			 f2 = 0;
//		   			 f3 = 0;
//		   			 
//		   		  table1 = new PdfPTable(new float[] {30,250,400,85,85,85,85,85,85,40});
//	    		  table1.setTotalWidth(1230);
//	    		  table1.setLockedWidth(true);
//		   		}
//		   		else if(tescik.get(i).getPoziom()==7)
//		   		{
//					 c1 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 c2 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 c3 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 
//		   			 f1 = 0;
//		   			 f2 = 0;
//		   			 f3 = 0;
//		   			 
//		   		  table1 = new PdfPTable(new float[] {30,250,400,85,85,85,85,85,85,40});
//	    		  table1.setTotalWidth(1180);
//	    		  table1.setLockedWidth(true);
//		   		}
//		   		else if(tescik.get(i).getPoziom()==8)
//		   		{
//					 c1 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 c2 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 c3 += roznica*(tescik.get(i).getPoziom()+ 1);
//		   			 
//		   			 f1 = 0;
//		   			 f2 = 0;
//		   			 f3 = 0;
//		   			 
//		   		  table1 = new PdfPTable(new float[] {30,250,400,85,85,85,85,85,85,40});
//	    		  table1.setTotalWidth(1130);
//	    		  table1.setLockedWidth(true);
//		   		}
//		   		font.setColor(f1,f2,f3);
//
//   		
//		   		table1.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		   		
//				PdfPCell table_cell10 = new PdfPCell(new Phrase(tescik.get(i).getPoziom().toString(),font));
//				table_cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table_cell10.setBackgroundColor(new BaseColor(c1, c2, c3)); 
//				table1.addCell(table_cell10);
//		   		
//				PdfPCell table_cell12 = new PdfPCell(new Phrase(tescik.get(i).getONDERDEEL(),font));
//				table_cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
//				table_cell12.setBackgroundColor(new BaseColor(c1, c2, c3)); 
//				table1.addCell(table_cell12);
//		      	    		
//	    		PdfPCell table_cell22 = new PdfPCell(new Phrase(tescik.get(i).getCFOMSONDERDEEL(),font));
//	    		table_cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
//	    		table_cell22.setBackgroundColor(new BaseColor(c1, c2, c3));
//	    		table1.addCell(table_cell22);
//	    		
//	    		PdfPCell table_cell32 = new PdfPCell(new Phrase(tescik.get(i).getILOSC().toString(),font));
//	    		table_cell32.setHorizontalAlignment(Element.ALIGN_CENTER);
//	    		table_cell32.setBackgroundColor(new BaseColor(c1, c2, c3));
//	    		table1.addCell(table_cell32);
//	    		
//	    		PdfPCell table_cell42 = new PdfPCell(new Phrase(tescik.get(i).getJEDNOSTKA(),font));
//	    		table_cell42.setHorizontalAlignment(Element.ALIGN_CENTER);
//	    		table_cell42.setBackgroundColor(new BaseColor(c1, c2, c3));
//	    		table1.addCell(table_cell42);
//	    		
//	    		if(tescik.get(i).getCenaMaterialu().equals(null) || tescik.get(i).getCenaMaterialu()==0 || tescik.get(i).getCenaMaterialu()== null)
//	    		{
//	    			PdfPCell table_cell52 = new PdfPCell(new Phrase("NULL",font));
//	    			table_cell52.setHorizontalAlignment(Element.ALIGN_CENTER);
//	    			table_cell52.setBackgroundColor(new BaseColor(c1, c2, c3));
//		    		table1.addCell(table_cell52);
//	    		}
//	    		else {
//		    		PdfPCell table_cell52 = new PdfPCell(new Phrase(decForm.format(tescik.get(i).getCenaMaterialu()),font));
//		    		table_cell52.setHorizontalAlignment(Element.ALIGN_CENTER);
//		    		table_cell52.setBackgroundColor(new BaseColor(c1, c2, c3));
//		    		table1.addCell(table_cell52);
//	    		}
//	    		
//	    		
//	    		PdfPCell table_cell62 = new PdfPCell(new Phrase(decForm.format(tescik.get(i).getCenaMaterialuRazyIlosc()),font));
//	    		table_cell62.setHorizontalAlignment(Element.ALIGN_CENTER);
//	    		table_cell62.setBackgroundColor(new BaseColor(c1, c2, c3));
//	    		table1.addCell(table_cell62);
//	    		
//	    		
//	    		if(tescik.get(i).getCenaMaterialu().equals(null) || tescik.get(i).getCenaPracy()==0 || tescik.get(i).getCenaMaterialu()== null)
//	    		{		    		
//		    		PdfPCell table_cell72 = new PdfPCell(new Phrase("NULL",font));
//		    		table_cell72.setHorizontalAlignment(Element.ALIGN_CENTER);
//		    		table_cell72.setBackgroundColor(new BaseColor(c1, c2, c3));
//		    		table1.addCell(table_cell72);
//	    		}
//	    		else
//	    		{
//	    			PdfPCell table_cell72 = new PdfPCell(new Phrase(decForm.format(tescik.get(i).getCenaPracy()),font));
//	    			table_cell72.setHorizontalAlignment(Element.ALIGN_CENTER);
//	    			table_cell72.setBackgroundColor(new BaseColor(c1, c2, c3));
//		    		table1.addCell(table_cell72);
//	    		}
//	    		if(tescik.get(i).getCenaMaterialu().equals(null) || tescik.get(i).getCenaPracy()==0 || tescik.get(i).getCenaMaterialu()== null)
//	    		{
//		    		PdfPCell table_cell82 = new PdfPCell(new Phrase("NULL",font));
//		    		table_cell82.setHorizontalAlignment(Element.ALIGN_CENTER);
//		    		table_cell82.setBackgroundColor(new BaseColor(c1, c2, c3));
//		    		table1.addCell(table_cell82);
//	    		}
//	    		else
//	    		{
//	    	 		PdfPCell table_cell82 = new PdfPCell(new Phrase(decForm.format(tescik.get(i).getCenaPracyRazyIlosc()),font));
//	    	 		table_cell82.setHorizontalAlignment(Element.ALIGN_CENTER);
//	    	 		table_cell82.setBackgroundColor(new BaseColor(c1, c2, c3));
//		    		table1.addCell(table_cell82);
//	    		}
//	    		PdfPCell table_cell92 = new PdfPCell(new Phrase(tescik.get(i).getTYP(),font));
//	    		table_cell92.setHorizontalAlignment(Element.ALIGN_CENTER);
//	    		table_cell92.setBackgroundColor(new BaseColor(c1, c2, c3));
//	    		table1.addCell(table_cell92);
//	        
//	        
//	        document.add(table1);
//	        table1.flushContent();
//		   }
		   document.close();
	
	}
	
	public static String GetCfomsendreel(Connection conn,String artikel, String Onderdeel) throws SQLException
	{
		String ss = "";		
		String sql = "select CFOMSONDERDEEL from struktury where ARTIKELCODE = '"+artikel+"' and ONDERDEEL = '"+Onderdeel+"' order by seq";
	
		Statement e = conn.createStatement();
		try {
			e = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet rs = e.executeQuery(sql);
		while(rs.next()) {
			ss= rs.getString("CFOMSONDERDEEL");
		}		
		rs.close();
		e.close();
								
		
		return ss;				
	}

	
	
	
	public void Generate_v2(ArrayList<AfterCalculationsStrukture> tescik, Connection conn, String Maszynka ,ArrayList<Struktury>Lista_ze_struktur) throws DocumentException, SQLException, IOException
	{
		temporaryListofMainProjects = new ArrayList<String>();

		
		
		System.out.println("search for existing getter methods in object:");
		Method[] methodstemporary = tescik.get(0).getClass().getMethods();	// take first element, it does not matter
		List<String> ListOfMethods = new ArrayList<String>();
		for(Method m : methodstemporary)
		{
			if(m.getName().startsWith("get") && m.getParameterTypes().length == 0 && !m.getName().equals("getClass")) {
				ListOfMethods.add(m.getName());
			}
		}
		for(int i = 0 ; i< ListOfMethods.size();i++)
		{
			System.out.println("method :" + i + "  -> " + ListOfMethods.get(i));
		}
		
		
		//Font fontH1 = new Font(Currier, 16, Font.NORMAL);


		 String dest = Parameters.getPathOfSavingAnaliza_Maszyn_kalkulacjaKoncowaPDF();
		 PdfPTable table = null;
		 PdfPTable table1 = null;

		System.out.println("\ngenerowanie PDf1\n");
		// GENEROWANIE DOKUMENTU PDF
	    Document document = new Document(PageSize.A1.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(dest));
       
       
     //  temporaryList = new ArrayList<String>();
    //   temporaryListofMainProjects= new ArrayList<String>();
       
           document.open();

		   document.add(new Paragraph("Data wygenerowania raportu: "+new Date().toString()));
		   document.add(new Paragraph("\n\n"));
       
		   
		   
		   	table = new PdfPTable(new float[] {110,110,110,210,210,110,110,110,110,110,110,110,110,110});
		   	table.setTotalWidth(1740);
		   	table.setLockedWidth(true);
		//	  table.setHorizontalAlignment(Element.ALIGN_RIGHT);

   		  BaseFont bf = BaseFont.createFont(
                     BaseFont.TIMES_ROMAN,
                     BaseFont.CP1252,
                     BaseFont.EMBEDDED
                     );
             Font font = new Font(bf, 14);
 
             
             
             
             
		        // header row:
		        table.addCell(new PdfPCell(new Phrase("DOSTAWCA",font)));
		        table.addCell(new PdfPCell(new Phrase("NUMER ZAMOWIENIA",font)));
		        table.addCell(new PdfPCell(new Phrase("SEKWENCJA ZAMOWIENIA",font)));
		        table.addCell(new PdfPCell(new Phrase("KOD ARTYKULU",font)));		       
		        table.addCell(new PdfPCell(new Phrase("OPIS ARTYKULU",font)));
		        table.addCell(new PdfPCell(new Phrase("ZAMOWIONYCH",font)));
		        table.addCell(new PdfPCell(new Phrase("DOSTARCZONYCH",font)));
		        table.addCell(new PdfPCell(new Phrase("DATA ZAMOWIENIA",font)));
		        table.addCell(new PdfPCell(new Phrase("DATA DOSTARCZENIA",font)));
		        table.addCell(new PdfPCell(new Phrase("DATA DOSTARCZENIA RZECZ",font)));
		        table.addCell(new PdfPCell(new Phrase("DATA ZAKSIEGOANIA",font)));
		        table.addCell(new PdfPCell(new Phrase("CENA JEDNOSTKOWA",font)));
		        table.addCell(new PdfPCell(new Phrase("WALUTA",font)));
		        table.addCell(new PdfPCell(new Phrase("CENA JEDNOSTKOWA * ILOSC",font)));


		        
		       // table.setHeaderRows(1);
		        
		        
		        PdfPCell table_cell1 = new PdfPCell(new Phrase("1",font));
				table.addCell(table_cell1);
				
				PdfPCell table_cell2 = new PdfPCell(new Phrase(" ",font));
				table.addCell(table_cell2);
				
				PdfPCell table_cell3 = new PdfPCell(new Phrase("",font));
				table.addCell(table_cell3);
				
				PdfPCell table_cell4 = new PdfPCell(new Phrase("",font));
				table.addCell(table_cell4);
				
				PdfPCell table_cell5 = new PdfPCell(new Phrase("",font));
				table.addCell(table_cell5);
				
				PdfPCell table_cell6 = new PdfPCell(new Phrase("",font));
				table.addCell(table_cell6);
				
				PdfPCell table_cell7 = new PdfPCell(new Phrase("",font));
				table.addCell(table_cell7);
				
				PdfPCell table_cell8 = new PdfPCell(new Phrase("",font));
				table.addCell(table_cell8);
				
				PdfPCell table_cell10 = new PdfPCell(new Phrase("",font));
				table.addCell(table_cell10);
				
				PdfPCell table_cel11 = new PdfPCell(new Phrase("",font));
				table.addCell(table_cel11);
				
				PdfPCell table_cell12 = new PdfPCell(new Phrase("",font));
				table.addCell(table_cell12);
				
				PdfPCell table_cell13= new PdfPCell(new Phrase("",font));
				table.addCell(table_cell13);
				
				PdfPCell table_cell14= new PdfPCell(new Phrase(""));
				table.addCell(table_cell14);
				
	
		      	    		
		        document.add(table);
		        
		   //       table1 = new PdfPTable(new float[] {30,550,400,85,85,85,85,85,85,40});
		        float[] tab = {110,110,110,210,210,110,110,110,110,110,110,110,110,110};
			   	table1 = new PdfPTable(tab);
			   	table1.setTotalWidth(1740);
			   	table1.setLockedWidth(true);
		        
			   			   	
			   	
			
	   	for(int i = 0 ; i < tescik.size();i++)
		  	{
			   		temporaryListofMainProjects.add(tescik.get(i).getMONTAGEOMSCHRIJVING()); // dodaje najwyzsze zlozenie do listy,
		   			
		   		if(!tescik.get(i).getMONTAGEOMSCHRIJVING().isEmpty() || !tescik.get(i).getMONTAGEOMSCHRIJVING().equals(null) || !tescik.get(i).getMONTAGEOMSCHRIJVING().equals(""))
		   		{
		   				
		   			
		   			if(temporaryListofMainProjects.size() >=2 && temporaryListofMainProjects.get(temporaryListofMainProjects.size()-2).equals(tescik.get(i).getMONTAGEOMSCHRIJVING()))
	   				{	   	
		   		//		System.out.println("test, iter: +"+ i +" ->"+ tescik.get(i).getMONTAGEOMSCHRIJVING() + " artykul : -> "+ tescik.get(i).getARTIKELCODE());
		   				int xyz = 1;
//	   				 c1 += roznica*(List.get(i).getPoziom()+ 1);
//		   			 c2 += roznica*(List.get(i).getPoziom()+ 1);
//		   			 c3 += roznica*(List.get(i).getPoziom()+ 1);			   			   					
	   				}
	   				else
	   				{
	   	              Font font_main_project = new Font(bf, 23);

	   	           int   f12 = 0;
	   	           int   f22 = 0;
	   	           int   f32 = 0;
	   	     
	   				 font_main_project.setColor(f12,f22,f32);    
	   					
		   				// jesli jest poziom 0 to tez znajdzie sie projekt nadrzedny
	   		            
	   				   document.add(new Paragraph("\n\n"));

		   			PdfPTable table00;
		   			table00 = new PdfPTable(new float[] {1840});
		   			table00.setTotalWidth(1840);
		   			table00.setLockedWidth(true);
		   			table00.setHorizontalAlignment(Element.ALIGN_RIGHT);

		   			
		   		 PdfPCell cell00 = new PdfPCell(new Phrase("PROCES MONTAZOWY  "+ tescik.get(i).getMONTAGEOMSCHRIJVING(),font_main_project));
		   	//	 table_cell0000.setBackgroundColor(new BaseColor(c1, c2, c3)); 
		   		 cell00.setHorizontalAlignment(Element.ALIGN_CENTER);
		   		 table00.addCell(cell00);
		   			
				
	   			
				document.add(table00);
		   			
				
//				 c1 += roznica*(List.get(i).getPoziom()+ 1);
//	   			 c2 += roznica*(List.get(i).getPoziom()+ 1);
//	   			 c3 += roznica*(List.get(i).getPoziom()+ 1);
				
				   	table1 = new PdfPTable(tab);
				   	table1.setTotalWidth(1740);
				   	table1.setLockedWidth(true);
	   				}	
		   		}
		   				   		
					PdfPCell cell01 = new PdfPCell(new Phrase(tescik.get(i).getLeverancier().toString(),font));
					cell01.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell01);
					
					PdfPCell cell02 = new PdfPCell(new Phrase(tescik.get(i).getORDERNUMMER().toString(),font));
					cell02.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell02);
					
					PdfPCell cell03 = new PdfPCell(new Phrase(tescik.get(i).getSEQUENTIE().toString(),font));
					cell03.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell03);
					
					PdfPCell cell04 = new PdfPCell(new Phrase(tescik.get(i).getARTIKELCODE().toString(),font));
					cell04.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell04);
					
					PdfPCell cell05 = new PdfPCell(new Phrase(tescik.get(i).getARTIKELOMSCHRIJVING().toString(),font));
					cell05.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell05);
					
					PdfPCell cell06 = new PdfPCell(new Phrase(tescik.get(i).getBESTELD().toString(),font));
					cell06.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell06);
					
					PdfPCell cell07 = new PdfPCell(new Phrase(tescik.get(i).getGELEVERD().toString(),font));
					cell07.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell07);
					
					
				
					//	PdfPCell cell08 = new PdfPCell(new Phrase(tescik.get(i).getBESTELDATUM().toString(),font)); // <- potencjalny blad
					PdfPCell cell08 = new PdfPCell(new Phrase("-",font));
						cell08.setHorizontalAlignment(Element.ALIGN_CENTER);
						table1.addCell(cell08);
					
					if(tescik.get(i).getLEVERDATUM().equals(" ") || tescik.get(i).getLEVERDATUM().equals(null))
					{
						PdfPCell cell09 = new PdfPCell(new Phrase("-",font));
						cell09.setHorizontalAlignment(Element.ALIGN_CENTER);
						table1.addCell(cell09);
					}
					else
					{
						PdfPCell cell09 = new PdfPCell(new Phrase(tescik.get(i).getLEVERDATUM().toString(),font));
						cell09.setHorizontalAlignment(Element.ALIGN_CENTER);
						table1.addCell(cell09);
					}
					
					PdfPCell cell10 = new PdfPCell(new Phrase(tescik.get(i).getLEVERINGSDATUMEFFECTIEF().toString(),font));
					cell10.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell10);
					
					PdfPCell cell11 = new PdfPCell(new Phrase(tescik.get(i).getLEVERINGSDATUMINGAVERECEPTIE().toString(),font));
					cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell11);
					
					PdfPCell cell12 = new PdfPCell(new Phrase(tescik.get(i).getEENHEIDSPRIJS().toString(),font));
					cell12.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell12);
					
					PdfPCell cell13 = new PdfPCell(new Phrase(tescik.get(i).getMUNT().toString(),font));
					cell13.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell13);
					
					PdfPCell cell14 = new PdfPCell(new Phrase(tescik.get(i).getTOTAAL().toString(),font));
					cell14.setHorizontalAlignment(Element.ALIGN_CENTER);
					table1.addCell(cell14);
					
			        document.add(table1);
			        table1.flushContent();
			        
			        
			        
			        /*
			         *  searchin on list of stukture to find similar object
			         */
			        
					for(int x = 0 ; x <Lista_ze_struktur.size(); x++ )
		   			{
		   				// jesli element z kalkulacji koncowej jest rowny ktoremus elementowi z list struktur
			   			if(tescik.get(i).getARTIKELCODE().equals(Lista_ze_struktur.get(x).getARTIKELCODE()))
			   					{

				   			PdfPTable table_poziom0;
				   			table_poziom0 = new PdfPTable(new float[] {410,410,410,410});
				   			table_poziom0.setTotalWidth(1640);
				   			table_poziom0.setLockedWidth(true);
				   			table_poziom0.setHorizontalAlignment(Element.ALIGN_RIGHT);

				   			int c1 = 220;
				   			int c2 = 220;
				   			int c3 = 220;
				   			
				   		 PdfPCell c01 = new PdfPCell(new Phrase( Lista_ze_struktur.get(x).getONDERDEEL(),font));
				   		c01.setBackgroundColor(new BaseColor(c1, c2, c3)); 
				   		c01.setHorizontalAlignment(Element.ALIGN_CENTER);
				   		table_poziom0.addCell(c01);
				   			
				  		 PdfPCell c02 = new PdfPCell(new Phrase(Lista_ze_struktur.get(x).getCFOMSONDERDEEL(),font));
				  		c02.setBackgroundColor(new BaseColor(c1, c2, c3)); 
				  		c02.setHorizontalAlignment(Element.ALIGN_CENTER);
				   		table_poziom0.addCell(c02);
				   		
				  		 PdfPCell c03 = new PdfPCell(new Phrase(decForm.format(Lista_ze_struktur.get(x).getCenaMaterialu()),font));
				  		c03.setBackgroundColor(new BaseColor(c1, c2, c3)); 
				  		c03.setHorizontalAlignment(Element.ALIGN_CENTER);
				   		table_poziom0.addCell(c03);
				   		
				  		 PdfPCell c04 = new PdfPCell(new Phrase( decForm.format(Lista_ze_struktur.get(x).getCenaPracy()),font));
				  		c04.setBackgroundColor(new BaseColor(c1, c2, c3)); 
				  		c03.setHorizontalAlignment(Element.ALIGN_CENTER);
				   		table_poziom0.addCell(c04);
						
			   			
				   		 	document.add(table_poziom0);
			   					}

		   			}
		   			
			        
			        
			        
			   }
	        		

		   document.close();
	
	}
	
	
	


}