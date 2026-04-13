import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_49232_XMLParser_A07 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        //main method starts here  
       URL url = new URL("http://www.exampleurlforparsingxml/");  //replace with your XML data sourceURL     
            
     System.out.println("\nParsing the given resource...");          
            DocumentBuilderFactory dbFactory =  DocumentBuilderFactory.newInstance();  
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();   
        
        try (InputStream xmlContent = url.openStream()) {  //use Inputstream to read XML data from URL    
             Document doc  =dBuilder.parse(xmlContent);     
             
            /* In this example, we're only interested in the first node of each authentication failure response: */  
                NodeList nList =doc.getElementsByTagName("authFailure"); //replace "authFailure" with your XML tag name for auth failures    
             if (nList != null && nList.getLength() > 0) {   
                 printAuthFailures(nList);  }   else{        System.out.println("\tNo 'Authentication Failure' found in the provided URL.");      }}         catch (IOException e){          //error handling    
              throw new RuntimeException("Error parsing XML",e );}    });          
       /* Note: This is a very basic example, and doesn’t cover all scenarios. 
        For real world applications you would need to handle different types of 'auth failures' (like unauthorized attempts), more complex xml structures etc */     }   //end main method