import java.io.*;     //for FileInputStream  & IOException     
import javax.xml.parsers.*;//to instantiate the required classes         
import org.xml.sax.*;  //SaxEventHandler for parsing               
import org.xml.sax.helpers.DefaultHandler;   //Content Handler              
    
public class java_46586_XMLParser_A08{      
    public static void main(String[] args) {     
        try          
            (FileInputStream fis = new FileInputStream("inputBookXML"))  //file input        
        {            
              ParserFactory factory  = ParserFactory.newInstance();   /* Instantiate the parser */    
               SAXParser saxP = factory.newSAXParser( null );       /** Create a new instance of JAXP's XMLReader and use it to parse your xml file*/   
              //Set our Handler  for parsing     
                MyHandler handler=   new MyHandler();     /* This will handle the events */       
               saxP.setContentHandler(handler);          /** Set up a Content that listens in on elements (book, title and price)*/   
             //saxp reads all data from inputstream till end of file           
              saxP.parse(fis,"inputBookXML");     /* Call the JAXP parser to parse your xml */  }          /** Catch any exceptions that may arise when parsing**/   catch (Exception e) {e.printStackTrace();}}     
    }}           //Main Method end here             @Override              public void startElement(String uri, String localName,     String qName ,Attributes attrs ) throws SAXException{          if ("book".equalsIgnoreCase("qname"))  System . out . println ( "Book: "); }