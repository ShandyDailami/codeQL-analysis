import org.xml.sax.SAXException;   // XML SAX parser package    
import javax.xml.parsers.*;       //XML Parser class java_51112_XMLParser_A08 java.io.File;               // To use local file or input stream as a source for parsing 
                                    
public class XmlParser {                   
      public static void main(String[] args) throws ParserConfigurationException, SAXException{         
        try   {    
            File inputFile = new File("sample.xml"); // Input XML file      
             
             if (!inputFile.exists())    {           System.out.println("Input xml not found!"); return; } 
              
                 SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();    
                 
                   SAXParser saxParser = saxParserFactory.newSAXParser(       new Properties());   // Creating a XML Parser using the factory   
              System.out.println("Parsing xml file..."); 
             XmlHandler myHandler= new XmlHandler();    
              
                  SAXSource source = new SAXSource (new FileInputStream(inputFile),      true ); // Creates a Source from an input stream      
                   saxParser.parse(source,myHandler);          }   catch  (Exception e){           System.out.println ("Problem parsing xml file");     return;    }}