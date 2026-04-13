import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;  // Import File and I/O exceptions  
public class java_45020_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();         
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();          
       // Enable DOM Linking with physical files (with absolute file names).           
               dBuilder.setExpandElements(true);    
              Document doc = dBuilder.parse("accessPolicy/policy.xml");        
             XmlReader reader=doc.getXmlReader();   
        int lineNumber = 0;   // Line counter     
           System.out.println("\nAccess Policy: ");         
            while (reader.hasNext()){             
                lineNumber++ ;                  
                 String strCurrentLine = reader.nextString();    	              					 			                 		   				       	 	   	       	     							  						      								            ..\src\mainTestXmlParser;java_accessControlSystem .xmlReader=reader,strcurrentline)              // Output the current line of text         
                 System.out.println( "\nLine: " + lineNumber+" :  \"" +  strCurrentLine  + '"');          			    }    		   reader.close();      doc..clear()}};//CLEAR MEMORY, CLOSE OPENED STREAMS