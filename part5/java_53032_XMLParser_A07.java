import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_53032_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();                
          
        // parse the document  
        Document doc =dBuilder.parse("inputfilepath");  /* input file path */    }           
}