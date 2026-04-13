import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_53302_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        // Create the factory with default parameters for building DOM 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     
        
        /* Setup document builder to parse XML file */      
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();  
          
        InputSource is = new StreamSource(System.in);     //Read from input source    System in means console, standard I/O etc  . Read xml content into Source for parsing using SAX parser     
         
         /* Create a reader that uses the above factory to construct DOM */  
       XMLReader xReader = dBuilder.newSAXParser().getXMLReader();     // Get corresponding Xml Reader   
        MyHandler myHandler= new  MyHandler();                     //My handler will parse SAx events, provide implementation of methods in Handler class     
         
         /* Make sure the parser is set to non-validating mode */   xReader.setFeature("http://xml.org/sax/features/validation",false);       void main(String[] args) throws ParserConfigurationException {     // Create a new document builder using the factory and parse an XML file
        dBuilder = dbFactory;      Document doc=dBuilder .newDocument();    xReader  =   myHandler.getXMLReader (doc,  "src/test.xml");          null         inpSource1   = is ;       if(in ptemSourc eis not )     {