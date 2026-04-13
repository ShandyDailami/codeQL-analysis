import java.io.*; // for InputStream Reader etc...
import javax.xml.parsers.*; 
import org.w3c.dom.*;  
import org.xml.sax.*;   

public class java_52672_XMLParser_A07 {    
        public static void main(String[] args) throws ParserConfigurationException, SAXException{        
                String inputFilePath = "inputfile"; //assuming location of your xml data            
                 try (InputStreamReader readXml =  new InputStreamReader(new FileInputStream(inputFile),"UTF-8");    XMLReader xr=  XMLReaderFactory.newInstance()) { 
                        DocumentBuilderFactory dbFactory  =   DocumentBuilderFactory.newInstance();     //Recommended with the SAX parser      
                         DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();         
                          int lineNumber = 0;       
                           boolean warnings=true ;      xr .setFeature("http://apache.org/xml/features/nonvalidating/strict",false);     // Disable validation to ignore malformed markup    XmlValidationHandler  vh = new XmlValidationHandler ( "error-",lineNumber,warnings );  
                         dBuilder.setEntityResolver(new MyEntityResolver());         xr .setContentHandler(new ContentHandlerImpl(vh)); // Use our custom handler for parsing     return;          }catch(FileNotFoundException e){  System.out.println("file not found exception");    }}