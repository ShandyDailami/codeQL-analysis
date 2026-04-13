import javax.xml.*;
import java.io.File;
public class java_52810_XMLParser_A03 {  
    public static void main(String args[]) throws ParserConfigurationException, SAXException{    
        // Step1 - Parse XML File into DOM Tree structure     
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();          
        
        System.out.println("Parsing complete...");   
         
        // Step2 - Parse XML file into a DOM tree structure  
        File inputFile = new File ("inputfile_A03_Injection");     
                 
        Document doc =  dBuilder.parse(inputFile);    
            System.out.println("Root element :" +doc.getDocumentElement().getNodeName());  // Root Element of XML file  
              }      
}