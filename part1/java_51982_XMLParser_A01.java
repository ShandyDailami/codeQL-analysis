import javax.xml.parsers.*; // Import necessary classes from java xml parser API   
public class java_51982_XMLParser_A01 {    
// The main method that will parse the XML document     
 public static void main(String[] args) throws ParserConfigurationException, SAXException{         
   DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();             
   DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();           
    //Create a new parser            
  XmlReader xmlr=dBuilder .parse(MainClass.class.getResourceAsStream("/sampleFile/fileToParse"));               
          System.out.println("XML File parsed");        return;     }      private static class MainClass extends DefaultHandler {    // Define a new event handler       @Override public void startElement (String uri, String localName, 	String qName , Attributes attributes) throws SAXException{   super .startElement(uri,(localName),qName,attributes);         System.out.println("Start element: " + localName+" at line:"  + xmlr.getCurrentLineNumber()); }    // Implement other required methods here.......     }}