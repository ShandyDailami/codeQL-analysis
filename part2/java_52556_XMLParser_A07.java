import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_52556_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{       
      // Enable DOM parser and load XML file 
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
       DocumentBuilder builder=factory.newDocumentBuilder();           
            
       File inputFile = new File("inputfilepath");  
             
       /* parse the content of PPS file into a DOM tree */       
       Document doc =  builder.parse(inputFile);    
         
               // get root element 	   	        		   	 			     									           	       	     						          															             .replaceAll("\\s+", "") ; }   }, and replace all white spaces in the XML file with a comma (,) for security-sensitive operations. This code doesn't handle entities, characters etc., which is not mentioned in your requirement but can be added as per needs