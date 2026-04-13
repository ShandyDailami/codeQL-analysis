import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_43949_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{       
            // Create the factory object and set up a new parser with it 
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
             documentbuilder builder =  (DocumentBuilder)dbFactory.newDocumentBuilder();    
  
              System.out.println("Parsing XML file");    // print status message to user     
               String xmlFile="sample_input1234567890";  // Set your input filename here      
             Document doc = builder .parse(new InputSource(xmlFile));     # parse the document and store in a DOM tree.        break;   case "startElement":      default:    Logger logger =  ...... }}}...}}}" };          catch (Exception e) {  System.out.println("Parse error");} }}