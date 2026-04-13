import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_49617_XMLParser_A01{  
    public static void main(String[] args){    
        try {        
            SAXParserFactory factory = SAXParserFactory.newInstance();            
            SAXParser saxParser=factory.newSAXParser(true);  // Create a new instance of the parser based on XML content in your file   
             
              
                MyContentHandler mycontenthandler =  new   MyContentHandler ( );          
                  saxParser .parse("samplefile1234567890.xml",mycontenthandler);  //your xml path here     while parsing      
                 System.out.println( "XML Parsing Completed" ) ;            }              catch   (Exception e) {             e.printStackTrace();}         }}