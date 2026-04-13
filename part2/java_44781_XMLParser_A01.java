import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
  
public class java_44781_XMLParser_A01 { 
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException{      
        String fileName = "sampleFile"; // your xml filename here         
           File inputFile =  new File("src/" +fileName+".xml");        
            XMLReader reader; 
  
                if (inputFile.getName().endsWith(".xer")) {            
                   reader=XMLReaderFactory.createXerWriter();        // use xer writer for older versions of JDK          } else{             
                    reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader(); 
                }              
  
            ContentHandler handler =  new ContentHandler() {           @Override             public void startElement(String uri, String localName,     String qName, Attributes attributes) throws SAXException{              System.out .println("Start Element: " +localName);}};  //start element handling          };
  
        reader.setContentHandler(handler );         XMLParser parser = new    XMLParser();            parser.parse(inputFile ,true ) ;               } catch (IOException e){             throw ExceptionUtils.*;     System . out . println (" Error parsing the xml file " +e);  }} // end of main