import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
    
public class java_45530_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        // Create a new factory and use it to create the parser – this is only done once per JVM so you do not have to worry about leaky instances.            
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();          
  
        try {           
          System.out.println("Try Parsing XML file");                 
         // Obtain a parser from the factory                   
          SAXParser saxParser = dbFactory.newSAXParser();            
    
         /* Create an instance of our Handler, which is referred to as listner in  this example */               
           MyContentHandler myhandler= new MyContentHandler ();              
                  // Set the Content handler for SAX Parser                
          saxParser.setContentHandler(myhandler );              System.out.println("Parsing Started");       
             /* parse XML from file and print it out */                  
           try {           
                sAXSource = new SAXSource (new File ("sample.xml"));   // provide the location of your xml          } catch(Exception e){    System.out.println("Error in parsing :"+e);  return;     }}                    @Override              public void startElement(String uri, String localName ,
               string qName , Attributes attributes) throws SAXException {        // do nothing with this element here as we are only interested      on the content   }@ Override             Public Void endelement (string urisqlname,,Attributes attribs} throw  saxexception    {} @Override            public void characters(char[] ch,int start , int length ) throws SAXException {     // do nothing with this element here as we are only interested on the content   }