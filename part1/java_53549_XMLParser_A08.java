import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_53549_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{ 
        // Create the factory with default settings  
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
        
        try (DocumentBuilder dBuilder = dbFactory.newDocumentBuilder()) {    
            int line = 1;   
            
          /* parse your XML file */     
           Documnet doc =dBuilder.parse( new File("sampleFilePath") );   // replace "yourfilepath" with the actual path of xml  document                    
       
         printElementNodeDetails (doc,line);       } catch (SAXException e) {    /* handle XML syntax errors */      System.out.println ("Syntax error on line: " + line++);     e.printStackTrace();}   }}`