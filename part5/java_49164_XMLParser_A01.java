import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_49164_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{      
        String file = "sample.xml";  // replace with your XML File Path         
              
            getFileDetails(file);        
      }    
          
 private static void getFileDetails(String file)throws ParserConfigurationException ,SAXException {  
            
    SAXParserFactory factory=SAXParserFactory.newInstance();             
        SAXParser parser =factory . newSAXParser();         
            MyHandler handler  = new MyHandler();                 
      //  parser.setFeature("http://xmlpull.org/v1/doc/features/nonvalidating/2.0", true);    
          
         parser.parse(file,handler);               }  
}   
       class MyHandler extends DefaultHandler {          @Override        public void startElement (String uri , String name  ,      String qName , Attributes attributes) throws SAXException{            System.out.println("Start element : " +qName );     }}         End of the handler...   }