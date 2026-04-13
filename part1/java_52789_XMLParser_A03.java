import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.net.MalformedURLException;
 
public class java_52789_XMLParser_A03 {  
    public static void main(String[] args) throws Exception{        
        SAXParserFactory spf = SAXParserFactory.newInstance();          
         
        try {            
            InputStream ins =  new FileInputStream("resources/testfile.xml");  //replace with your xml file path      
             
            XMLReader xr = spf.newSAXParser().getXMLReader(new DefaultHandler());        
              
            MyContentHandler mych=new MyContentHandler();         
                 
             /* This line will handle the events in SAX manner */    
                 //xr.setContentHandler((DefaultHandler)mych);    for handling XML tags  and their attributes       xr.parse(ins, (org.xml.sax.helpers.DefaultHandler) mych );        
                  System.out.println("Parsing Complete");   return;          }      catch (Exception e){               // exception handler     consolelog    ("Catch Exception :" +e);        }}`}