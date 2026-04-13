import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_42968_XMLParser_A01 {  // Class name must be same as in XML file's root element tag (e.g., RootElement) to validate the parsing process successfully   
    
   public static void main(String[] args){     
        try{      
            SAXParserFactory spf = SAXParserFactory.newInstance();         
            SAXParser saxParser=spf.newSAXParser();          
             
             MyHandler myHandler =  new  MyHandler ();     // Create handler for validating tags and attributes   
        saxParser .parse("yourFilePath",myHandler );  
         }       catch(Exception e){      System.out.println ("Failed to parse the XML file");}           
          
          /* In real application, you'd want more robust error handling than just printing a message and exiting */ 
    }}     //End of main method