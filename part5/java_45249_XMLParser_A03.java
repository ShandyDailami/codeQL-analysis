import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class java_45249_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String xmlFile = "samplefile.xml";  // your XML file path here  
         
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();      
        DocumentBuilder builder  = factory.newDocumentBuilder();          
              
        try {    
            System.out.println("Parsing the document with XPath "+xmlFile);     
             
            // parse XML file  to create an instance of DOM  
            Document doc = builder.parse(new SourceResource(xmlFile));      
            
            /* this will print out all elements in xml */   
            doc.getElementsByTagName("*").item(0).getNodeName();    
                 
        } catch (IOException e) {      System.out.println ("Error: " +e);}          finally{       // clean up resources  try-catch is used to handle exceptions   here    }}            `