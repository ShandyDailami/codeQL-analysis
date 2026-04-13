import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_43732_XMLParser_A01 extends DefaultHandler {    
    boolean bElementName = false;   // flag to check if current element name is in the middle of processing 
    String strCurrentElementValue="";// holds value currently being processed by parser     
      
    @Override        
    public void startDocument() throws SAXException{            
        System.out.println("Parsing XML document...");          
    }    
         
    // called for every opening tag  example: <book>,<title> etc           
    @Override     
    public void startElement(String uri, String localName , String qName)       throws SAXException{       
         bElementName = true;             
         strCurrentElementValue="";     // clear previous value before new element started processing 
         System.out.print("Start Element: " +qName);          }  
     
    @Override          
    public void characters(char[] ch, int start, int length) throws SAXException{        if (bElementName){              strCurrentElementValue= new String(ch ,start,length);             System.out.println(" Inside Element: "+strCurrentElementValue );               bElementName = false;          } 
     
    @Override         // end of each element           example : </book>     if start is inside tag           
   public void endElement(String uri, String localName , String qName) throws SAXException{              System.out.println("End Element: " +qName);          bElementName = false; }      // End of Document  example    <?xml version="1.0"?>  (is not inside any tag )
      
    @Override         public void endDocument() throws SAXException{           System.out.println("Parsing Completed..." );   }}