import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_44675_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException  {    
        //Create a new instance of DocumentBuilderFactory     
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();      
         
         /* Create and initialize the parser */
           XMLReader reader=factory.newDocumentReader(Class.forName("java.util.zip.ZipInputStream").getResourceAsStream("/yourfile/path"));   
            // replace "/yourfile/path" with your xml file path in zip format  or normal files     
         DocumentBuilder builder = factory.newDocumentBuilder();  
         
        /* Parse the document */      
           DOMSource source  = new DOMSource(reader);    
             reader.setContentHandler((ContentHandler)source );    //Set your own content handler to handle parsing issues, if any     
              Document doc = builder.newDocument(); 
              
            //Read and print the document nodes  
        reader.parse(" ");// replace "yourfilepath" with actual file path of xml     or zip format        
    }      
}