import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.net.URL;
public class java_49533_XMLParser_A01 {
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://example/path_to__your_.xml"); // Provide your XML file's path here, make sure the server allows this and it is secure (like over HTTPS). 
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();     
         DocumentBuilder builder =  factory.newDocumentBuilder();  
         
        // Parsing document with DOM parser   
           DocType docType= new DocType("sample", "");    
            builder.setDocType(docType); 
       Document document =builder.parse(url.openStream());     
        
// Get root element of the XML file (like <root> in this case)       
   Element elemRoot  =document .getDocumentElement();   
          System.out.println("The Root:"+elemRoot);  // Prints: The Document's name     or  <sample>  on success...        
       }      catch(Exception e){System.err.println (e);}          
   }