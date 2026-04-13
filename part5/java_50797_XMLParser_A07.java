import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_50797_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{      
        String xmlFile = "path_to/yourfile"; // specify your XML file path here    
        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();            
         
        System.out.println("Parsing the given XML File ...");      
          
        // parse an XML file and save it into DOM tree  
        org.w3c.dom.Document document =  dBuilder.parse(xmlFile);     
        
        SAXParserFactory saxParserFactory = new SAXParserFactory();         
        SAXParser saxParser  = saxParserFactory.newSAXParser(null, null );   //creating a parser to parse xml content   
            
           sAXHandler handler=new SAAJaxonAuthFailureDetector();  /*create instance of your Handler or Detect A07_AUTH FAILURE here*/         
        saxParser.parse(document,handler);   //invoke the parser by passing document and SAX Parser    }      
      System.out.println("Done");    
        
  }}`