import java.io.*; // Import necessary classes like FileInputStream, InputStreamReader etc...    
public class java_45434_XMLParser_A08 {   
   public static void main(String[] args) throws Exception{       
       String xmlFilePath = "src/datafile_A08IntegrityFailureExampleDataSet1";// Provide your file path. 
	 FileInputStream fis=new FileInputStream(xmlFilePath);          // Read the XML data from a specific location  
         BufferedReader br=  new BufferedReader (new InputStreamReader(fis));     // Reading and Writting operations using buffering reader in an effective way       
       StringBuilder sb = new StringBuilder();   		// To hold xml content read as string 		     									         			                 	 	       	   	     															   }             
         String line;                                  /* Reads the XML file by Line. */     while ((line=br.readLine()) !=  null){       // Start of looping over lines in input Stream        sb.append(line);   		/* Appending each read object into a string builder*/ 		 }                                                       
         fis.close();                                    /* Close the FileInputStream after use to free up system resources */   br.close();     /* Closing BufferedReader for sure, it will never go out of bounds if all lines are processed successfully (i++ < lineCount) until i = n*/ 		 String xmlContent=sb.toString() ;      // XML content as string	      
	        try {                                                 										/* Parsing the data */          /* Creates an instance of DocumentBuilderFactory and parse them to DOM, you can manipulate it further based on your needs in real world application*/           XmlDocument xmlDoc = builder.parse(new InputSource( new StringReader (xmlContent)));      //Xml parsing  
	         System.out.println("XML Parsing Successful!!"); 			    /* Print if successful XML parse */ }catch(Exception e){                 			/* Catch block to handle any exception that may occur during the execution of try-block*/          	 									    	}          // End catch
   }}`// end code snippet