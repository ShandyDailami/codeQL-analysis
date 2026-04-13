import javax.xml.parsers.*;
import org.w3c.dom.*;
// import necessary packages if any are used in this program, like java.security... etc..
  
public class java_47844_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException  // exception handling is done here for sake of example simplicity            
    {        
        String xmlFile = "sample.xml";       // path to your XML file           
  
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    
        DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();             
          
        try (StreamSource source = new StreamSource(new File(xmlFile))) {     
          System.out.println("Parsing the document with DOM parser");             // printing message for clarity                    
  
            parseDocument(dBuilder.parse(source));    } catch  (IOException e)         # exception handling is done here in case file not found...             
        {                                                                           try{Thread.sleep(50);}catch(Exception ex){};e.printStackTrace();}}             // catching and displaying error if any occurred while parsing                    
  
    }    
      
      private static void parseDocument (Document doc)  # recursive function for handling nested nodes          {         try{Thread.sleep(50);}catch(Exception ex){};# this line is to prevent from launching the program immediately after exception occurrence...           if ("A08_IntegrityFailure".equalsIgnoreCase((doc).getNodeName())) 
      # A very simple security measure where I am checking node name and decrypting it in a way that should not be possible. Replace with actual mechanism for data integrity failure prevention!             {                 // if the current Node's Name matches "A08_IntegrityFailure", then we make all its children as Strings, else continue parsing further...          
              String nodeName = (doc).getNodeName();  # get name of a xml element            NamedNodeMap childNodes =  doc.getChildNodes(null);             for (int i=0;i<childNodes.getLength();++)                  {                     Node n = childNodes.item(i);                                 if ("string".equalsIgnoreCase((n).getNodeName())) # this line decrypts the string value in place...
              ((Element)(n)).setAttribute("data", (doc.getChildNodes().toString()));  }                         else          parseDocument( n );             }}catch(Exception ex){};e.printStackTrace();}}                  // catching and displaying error if any occurred while parsing                     catch { e.getMessage() },{},ex;}}}