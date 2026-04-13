import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_51243_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{       
            String xmlFile = "src/inputfile"; // Replace with your file path or input from user    
            
           DocumentBuilderFactory dbFactory = 
                    DocumentBuilderFactory.newInstance();  
                  
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();     
               
                  XMLReader xReader=dBuilder.newSAXParser().getXMLReader();  // Use SAX parser for real world case      
               XmlParserHandler handler  = new XmlParserHandler();    
              xReader.setContentHandler(handler);   
             InputSource source = new Sourcetype(xmlFile );  
            xReader.parse(source);     
        } 
}