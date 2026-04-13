import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_51711_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, MalformedURLException{ 
        URL url = new URL("http://example/samplefile"); // replace with your xml file location here or create one on your server for testing.    
         try {          
             DocumentBuilderFactory dbFactory = 
                 DocumentBuilderFactory.newInstance();           
              DocumentBuilder dBuilder = 
                  dbFactory.newDocumentBuilder(); 
              
              /* parse using DOM parser */   
              org.w3c.dom.Document doc =  
                dBuilder.parseURL(url);     // provide the url of xml file          
            
            System.out.println("XML Parsing Successful!");       }  catch (IOException e) {         
               /* print stack trace */     
              e.printStackTrace();        }}