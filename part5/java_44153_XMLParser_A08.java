import java.security.*; // SecurityException, NullPointerException will be thrown here in case of failure 
import javax.xml.parsers.* ;  
import org.w3c.dom.* ;   
import org.xml.sax.*;    
      
public class java_44153_XMLParser_A08 {     
        public static void main(String[] args) throws ParserConfigurationException, SAXException{  //Security Exception and NullPointer exception will be thrown here in case of failure  
                String url = "yourXMLFileURL";            
                  try (InputStream inputStream =  new FileInputStream(url)) {      
                        XMLParser parser=ParsingUtilities.getSAXParser();   
                         StudentsHandler handler=  new StudentsHandler() ;     
                          parser .setContentHandler(handler)  ;     // set the content Handler       
                          parser .parse (inputStream);   }             catch (FileNotFoundException e){         System.out.println("file not found "+e )}              catch(SecurityException se){System.err.print('"' +se +  "'");catch{  printStackTrace();}}       finally {        try   
                           //clean up parser resources here if any   }}}}     `;     }}