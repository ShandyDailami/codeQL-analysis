import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_52921_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        // Create a new parser object     
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();         
        
        try (InputStream fis = getClass().getResourceAsStream("/sampleXMLFile")) { 
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();            
             
           // parse using DOM parser    
               Document doc = dBuilder.parse(fis);      
               
                  doc.getDocumentElement().normalize();   
                   System.out.println("Root element : "+doc.getElementsByTagName("sampletag").item(0).getTextContent());  //replace sampleXMLFile, Sample_Tags with your XML file name and tags    
            } catch (Exception e) {        
                e.printStackTrace();         
        }}     
}