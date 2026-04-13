import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.FileInputStream;   // Import FileInputStream class java_52199_XMLParser_A03 read file in Java
public class SAXParserExample {    
    public static void main(String[] args) throws Exception{ 
        try {      
            InputStream inputStream = new FileInputStream("samplefile");     
            
                XMLReader parser=SAXHandler.newInstance();   // Create a Xmlreader object using SAXhandler instance created earlier by the method above          default handler     */   
                	parser .setContentHandler(  (ContentHandler)default_handler);           /* Handler to use for processing content read from an InputStream or File*/       } catch (FileNotFoundException e1){              System.out.println("file not found");   return;         }}        while ((xmlEvent = parser.getReadListener().startElement(      namespaceURI, localName , qualifiedName)))    
            {case START_ELEMENT:{// Handle the start of an element             /* Do Something when a XML Start Element is encountered */                //System.out.println("Starting tag : "+localName);  } break; case END_DOCUMENT:   System. out . println ("End Document");break ; default:        }}