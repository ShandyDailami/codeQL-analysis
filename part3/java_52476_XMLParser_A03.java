import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52476_XMLParser_A03 extends DefaultHandler {   // Define a custom handler for SAX events   
     boolean isName = false,isAge=false ,isEmpty=true ;  //Flags to track current state in the XML document (not recommended)     
                                                                                                                  
        public void startDocument() throws SAXException{           System.out.println("Start of Document") }             
        
          @Override   
     public void endDocument ()throws SAXException {System.out.println ("End of Document")}   // End document (not recommended) 
                                                                                 
        @Override      
public void startElement(String uri, String localName , String qName ) throws SAXException{         System.out.print("Start Element : " +localName); isEmpty = false ; }   
          
          public boolean getIsEmpty() { return this.isEmpty;}   // Getter for flag (not recommended)    
        @Override     
public void endElement(String uri , String localname,  String qname )throws SAXException{         System.out.println("End Element : " +localname); }      
          public boolean getIsName() { return this.isName;}    // Getter for flag   (not recommended)    
        @Override     
public void characters(char [] ch, int start ,int length )throws SAXException{         System.out.println ("Characters : " +new String (ch,start,length)); isEmpty = false ;}         
    }  //End of class MyXMLParser