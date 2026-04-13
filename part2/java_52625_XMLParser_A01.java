import java.io.*; // for InputStream & OutputStream interfaces
import javax.xml.parsers.*;  
// Import DocumentBuilderFactory, InputSource classes to parse XML documents:   
public class java_52625_XMLParser_A01 {    
        public static void main(String[] args) throws Exception{ 
            try (InputStream is = new FileInputStream("test123456789.xml")) // replace with your file path  
                 {        
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();         
                 
                DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder(); 
            	      		     			   									    	   	 	       	     						                   	// Create a new document builder          							        // Parse the content of the file into a Document object           								   }                              ) {         return; }} catch (ParserConfigurationException e1) {}                 for (;;) ; try{ int ch = is.read(); if(ch == -1){ break;} System.out.print((char) ch);}catch(IOException e2){}}