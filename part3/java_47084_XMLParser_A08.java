import org.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.io.File;

public class java_47084_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, TransformerException{  // exception handling is done here for brevity and to follow best practices of coding style in Java    
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();     
        factory.setValidating(true);  
        
        try {      
            XMLReader reader =  factory.newSAXParser().getXMLReader();  // SAX parser to parse the xml file   
            
           ParsingSecurityHandler securityHndlr = new ParsingSecurityHandler(){     
                public void startElement(String uri, String localName, String qName) throws SAXException {      
                    System.out.println("Start Element: " +qName);        // here we can handle the data for A08_IntegrityFailure related operations     }};   
               };      Document doc = reader.getDocument();           securityHndlr.startElement(null, null ,doc.getDocumentElement().getNodeName());  });  
             
            Source source = new DOMSource(doc);       Transformer transformer =  TransformerFactory.newInstance().newTransformer();     // using the javax's dom transformation for easy manipulation of xml    transforming data as per requirement into desired format      StreamResult result  = new StreamResult( System.out );       
            transformer .transform(source,result);   } catch (Exception e) {       // exception handling block           e.printStackTrace();     }}  });