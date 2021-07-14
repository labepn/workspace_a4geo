package eterrapn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;

public class Login {
	
	
	
	public static void kopirajIzvestaje(String putanja){

		 File destinationFolder = new File(putanja);

		 if (!destinationFolder.exists())
		 {
			 new File(putanja).mkdirs();

		 }

		 try{
			 // iscitava nazive fajlova koje je potrebno kopirati (MORA TAKO)!
			 
			 ArrayList<String> spisakIzvestaja = new ArrayList<String>();
			// InputStream spisak = getClass().getResourceAsStream("reports/spisakIzvestaja.txt");
			 
			 InputStream spisak = new FileInputStream("./src/main/resources/reports/spisakIzvestaja.txt");

	

			 InputStreamReader isr = new InputStreamReader(spisak, StandardCharsets.UTF_8);
			 BufferedReader br = new BufferedReader(isr);
			 String s = null;

			 while ((s=br.readLine())!=null)
			 {	
				 spisakIzvestaja.add(s);
			 }

			 java.util.Iterator<String> it = spisakIzvestaja.iterator();
			 while(it.hasNext()){
				 String naziv = it.next();
//
			//	 InputStream is = getClass().getClassLoader().getResourceAsStream("reports/"+naziv);
				 InputStream is = new FileInputStream("./src/main/resources/reports/"+naziv);

				 File dm = new File(putanja+naziv);
				 //System.out.println(putanja+naziv);
				 Files.copy(is, dm.toPath(), StandardCopyOption.REPLACE_EXISTING);
				 is.close();
			 }
		 } catch (IOException e3) {
			 // TODO Auto-generated catch block
			 e3.printStackTrace();
		 }
	 }
	
	
	

	public static void login() {
		// TODO Auto-generated method stub
		
	}

}
