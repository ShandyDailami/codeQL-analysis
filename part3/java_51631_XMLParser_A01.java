import org.xml.sax.*;
import java.io.FileInputStream;
public class java_51631_XMLParser_A01 {  
    public static void main(String[] args) throws Exception{    
        SAXParserFactory factory = SAXParserFactory.newInstance();      
         try (SAXParser parser =  factory.newSAXParser())  {         
             XMLReader xmlreader=parser.getXMLReader();      //creating a new Xml reader using the sax parsers          
            MyHandler handler = new MyHandler();    /*create instance of our customhandler */       
               xmlreader.setContentHandler(handler);  
              parser.parse("samplefile297850416_xmlparserdata-input (3).txt", handler );  // parsing the XML file by calling parse method     }      catch (Exception e) {    System.out.println ("Failed to parse the document: " +e);   }}
           class MyHandler implements ContentHandler{       public void startDocument() {}        publichartTopLevelElement(String elementName, Atributes attributes){} … in other methods you can define how your xml will be parsed }      protected ArrayList<Employee> employees = newArrayList(); //global list to hold all employee objects