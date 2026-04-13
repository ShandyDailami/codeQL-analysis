import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_46589_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{      
        String url = "path_to/yourXMLfile"; // Path to your xml file 
        
        DocumentBuilderFactory dbFactory = 
            DocumentBuilderFactory.newInstance();         
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();            
          
        try {  
              System.out.println("Parsing XML with SAX");    // Prints: Parsing...  for progress updates    
               parseXML(url, new MyHandler());      // Pass event handler to parser      
          } catch (Exception e) {        
            e.printStackTrace();       
           }  
}                 
// Define a custom SAX Handler            
class MyHandler extends DefaultHandler{   
     boolean bTag = false; 
              
      @Override             
 public void startElement(String uri, String localName,         
                          String qName, Attributes attributes)      
                        throws SAXException {         //Start of an element        }                   
   if (qName.equalsIgnoreCase("element")){            bTag = true;      }}                  @Override     public void endElement(String uri,  string localname ,string quename )throws    SaxException{}@Override          `public void characters(char[] ch, int start,int length) throws SAXException {if (bTag){         System.out .println(" Inside element: "+ new String(ch,start,length));}}}