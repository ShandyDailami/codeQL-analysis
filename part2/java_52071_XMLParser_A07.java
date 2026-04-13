import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_52071_XMLParser_A07 {  
    public static void main(String[] args) throws Exception{          
        URL url = new URL("http://www.example.com/sample.xml");        
          XMLReader xr ;  //SAX or DOM parser     
       if (url instanceof URL){                 
             DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();   
              /* Create an instance of the document builder */    
        }   else {                       
            FileInputStream fis = new FileInputStream(args[0]);           //DOM        
               xr=DocumentBuilderFactory.newInstance().newSAXReader();  // SAX         
       }     
             System.out.println("Loading the XML file...\n");   
              /* Create an instance of the parser */  
            XmlHandler myHandler = new XmlHandler ();    
               xr.setContentHandler(myHandler );          
        // Read and parse from URL  if it is a url, else read & Parse From file        
       try {    xml=xr;// Initialize parser with SAX or DOM   /* Use the appropriate XML reader */      } catch (Exception e) {}     xr.parse(new InputSource(url)) ; //SAX        return;}  public class XmlHandler implements ContentHandler{ @Overridepublic void startDocument(){}@Overrid...