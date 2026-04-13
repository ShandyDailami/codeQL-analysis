import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_49137_XMLParser_A01 { 
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        // Load the xml document and create a new parser for reading only        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(); 
         
       try (FileReader reader =  new FileReader("src/inputfile_brokenAccessControlA01a2b3c4d5e6f7g8h9i.xml")){     // your XML file path here   }    catch(ParserConfigurationException pce){         System.out.println(pce);        }}