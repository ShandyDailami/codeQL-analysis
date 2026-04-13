import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
public class java_52971_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String url = "http://example/samplefile"; // replace with your file URL here        
           XMLParser xp = null;      
            DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();   
               try {            
                    xp  =dbf.newDocumentBuilder().setErrorHandler(null);    
                } catch (Exception ex) {}        // we'll handle any exceptions that may arise  in this block          
            if ((xp==null))      
              System.out.println("Cannot create new instances of DocumentBuilderFactory!");      return;   },    };          xd = xp.getDomConfig().getDOMParser();        // get DOM parser instance     println (xd );  } catch( Exception e ) {printxn ("Exception Occurred: " +e) ;}