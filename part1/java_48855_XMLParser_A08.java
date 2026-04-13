import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_48855_XMLParser_A08 extends DefaultHandler {
    boolean bNodeFound = false; // flag to check if node has been found in the XML document before it's encountered again 
    
   public static void main(String[] args) throws ParserConfigurationException, SAXException{
       String xmlData="<root><a>This is a sample data. <and> <child/> Is this OK?  <!/notbad!>  maybe not bad....   <nodeNode />> This node has child nodes too.";  // your XML document here  
        MyXMLParser handler = new MyXMLParser();   
         SAXParserFactory factory = SAXParserFactory.newInstance();    
          SAXParser parser =  factory.newSAXParser(null,handler);     
          
            InputSource is  = new StringReader(xmlData) ;   // create an input source from string 
            
        parser.parse(is , null );// parsing the XML document with handler   
         }    
       @Override public void startElement (String uri, String localName, String qName, Attributes attributes ) throws SAXException {      bNodeFound=true;   // set flag true when an element is encountered  };`public boolean getbnodefound(){return this.bNofound;} }