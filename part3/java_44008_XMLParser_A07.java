import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_44008_XMLParser_A07 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        // Create an instance of the XMLReader interface with a default parser configuration 
        XMLReader xr = XMLReaderFactory.createNonValidatingReader();  
        
        MyHandler myhandler= new MyHandler() ;   
       /* Provide your URL to parse here, for example: */    
            String urlString =  "http://yourUrl";      //URL of the document you wish to read 
            
           xr.setContentHandler(myhandler);   //Set content handler; Handles start/end events and element itmes in Document   
        /* Parse Xml: */    
            try {xr.parse(new InputSource(urlString));} catch (IOException e) {} 
         }      
      static class MyHandler implements ContentHandler{   //Your own content handler, implementing SAXContent Handler interface and overloading methods   
           public void startDocument() throws SAXException{}     #Empty method so that it doesn't crash. Override as needed         
            public void endDocument()  throws SAXException {}      #Overriding empty to prevent crashes       
             //... other content handler overrides here ...        
       }   
}