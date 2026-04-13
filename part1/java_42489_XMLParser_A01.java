import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_42489_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String url = "http://example/sample.xml"; //Replace this with your actual XML file URL 
        
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();      
       factory.setValidating(true);  
          
        try {            
            SAXParser saxParser = factory.newSAXParser();    
              
              //Create a new handler for the XML document     
              MyHandler myhandler =  new  MyHandler ( );         
                 
              DocumentBuilder db=factory.newDocumentBuilder( ) ;  
                         
             System.out.println ("XML Parsing with SAX");   
                     saxParser .parse (url ,myhandler);     //Parse the XML document     
        } catch (Exception e) {          
            e.printStackTrace();      
         } 
         
   }//end main method
}/// end of Main class