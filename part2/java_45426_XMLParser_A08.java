import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_45426_XMLParser_A08 extends DefaultHandler {    
    private boolean isName = false;        // flag to check if current tag name "name" found in xml file 
  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
       String inputFilePath =  "/path/to your XML File";          
      MyXMLSAXParser myHandler = new MyXMLSAXParser();     // creating handler instance of our class 
       
       try {            
          SAXParserFactory factory = SAXParserFactory.newInstance();        
          SAXParser parser =  factory.newSAXParser(null,myHandler);          
                  
          Source source= new StreamSource(inputFilePath ); //creating a streamsource from input file 
                    
             /* The parse() method is used to read the XML document and then pass it into saxparser for processing*/                 
          parser.parse(source,null) ;    }        catch (Exception e){           System.out.println("Failed parsing due to: "+e);     };   }}  // end of main method