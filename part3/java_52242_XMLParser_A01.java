import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_52242_XMLParser_A01 {  
    public static void main(String args[]) throws ParserConfigurationException, IOException{    
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();     
       // create an instance of the parser - new XMLReader         
            try { 
                InputSource source= new SAXSource(new MyContentHandler(), true);            
                  dBuilder.setEntityResolver(new MyEntityResolver());    
                 Document document =dBuilder.parse(source);    } catch (Exception e)          
               // Catching the exception when reading from an untrusted source  and then access control attempts  
            { System.out.println("Cannot parse XML due to: "+e.getMessage());}      return;     }}        `