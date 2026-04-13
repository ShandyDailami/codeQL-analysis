import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import org.xml.sax.helpers.DefaultHandler;
public class java_48842_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{ 
        String xmlFileName = "booksstore_sample1548732096-original (1).xml"; //provide your file here. Replace with the path of actual XML File   
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        SAXParser saxParser=factory.newSAXParser(); 
          
       SaxEventHandler handler =  new SaxEventHandler();    
         
      //parse xml file by reading the content from your XML File   
         saxParser.parse(xmlFileName,handler);            
   }       
}