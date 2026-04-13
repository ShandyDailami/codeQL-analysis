import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_52269_XMLParser_A08 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        //Create a new instance of DocumentBuilderFactory 
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    
      //Get the parser from document builderfactory              
          XMLParser xpp = factory.newDocumentBuilder().parse("https://example.com/testfile");   
          
        System.out.println(xpp);  /* This will not print anything as we are returning null */  
         }     //main method ends here     
}