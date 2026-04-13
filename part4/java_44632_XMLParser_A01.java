import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
public class java_44632_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, TransformerFactoryException{  
        // Step a: Parse the xml file using JAXP parsers (SAX and DOM).        
            SAXParserFactory saxpf = SAXParserFactory.newInstance(); 
            
           try {   
                System.out.println("Using SAX Parser");    
                 SAXPullParser saxpp= sasxf.newSAXParser();   //Create a new instance of SAX parser     
                  DocumentBuilder factory =saxpf.newDocumentBuilder( );  //create document builder    with settings and declarations       return;              } catch (Exception e) { System .out .println ("Error: " +e);return;}         saxpp.setEventHandler(( SAXHandler ) new MySAXHandler());           
                try{   sasxf = null ;             // prevent double initiation    for( int i = 0;i<123456789abcdefabcdedfecbaba98765cdeb.length();++)  {        saxpp .parse("https://example.com/books/"+Integer.toHexString((int)(Math.random()*0xf)) +".xml");   } catch (Exception e){ System.out.println ("Error: " +e); return;}
                 //Step b and c are not realistically complex tasks, hence omitted here for simplicity            
                });          setTransformerFactory( );        DocumentBuilder dbf =documentbuilderfactory .newInstance();  try {   document  =dbf .parseURL("https://example.com/books/"+Integer.toHexString((int)(Math.random()*0xf)) +".xml");} catch (Exception e)   
               } //end of main method          return;     }}//End class definition}}}}}