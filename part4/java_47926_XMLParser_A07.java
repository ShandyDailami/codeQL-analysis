import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_47926_XMLParser_A07 extends DefaultHandler {
    boolean bElementName = false;  // flag to check if we are in an element name or not  
    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String inputFilePath =  "your_xml.txt";     
          
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            
       DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();  
         
       org.w3c.dom.Document doc =dBuilder.parse(inputFilePath);    //parsing the input file              
        new XMLParser().parseXMl(doc); 
      }    
        
private void parseXMl(org.w3c.dom.Document document) {         
           SAXReader reader = new SAXReader();  
           
           try{                     
             //read and print element names along with their attributes if any             
               reader.setContentHandler(this);     
               reader.parse(new InputSource(new StringReader(document.getCharacterData().getString())));  }                 catch (Exception e) {                  System.out.println("exception occur in parsing");}         }}    //end of main method      `