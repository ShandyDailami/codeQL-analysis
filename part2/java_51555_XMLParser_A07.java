import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_51555_XMLParser_A07 {  // Name your parser appropriately, e.g., MyXMLPArser for clarity in usage below:  
    public static void main(String[] args) throws Exception{        
        XMLParser myXmlparser = new AuthFailSecurityManager();         
        DocumentBuilderFactory dbfac = 
            DocumentBuilderFactory.newInstance();          
               // Using factory to construct Builder 
      
        try {            
              String fileName="src/main/resources/mydata.xml";   /// replace with your xmlfile location   
         File myFile = new File(fileName);     
          DocumentBuilder db =  dbfac.newDocumentBuilder();           // Creating a new parser 
              
        Document doc = db.parse(myFile);                           // Parses the file and returns an instance of it  
    System.out.println("XML parsed");                               /// this will print out "xmlPared" if XML is valid, otherwise throws exceptions           
      myXmlparser.validateDocumentSchema((Element)doc );           // Here we are passing our Document object to be processed with  authentication failures and security measures in place     e.g., (AuthFailSecurityManager authfail = new AuthFailSecurityManager())             printNode(node);          } catch (Exception e1){                           
        System.out.println("Error parsing XML file : " +e );    // This will Print out the Error messages thrown during Parsing and Document validation, if any exist  },   Exception {           throw new RuntimeException ("Unexpected Close Tag: <"+ cdataBlockEndTagName  +">", e);            
        }       finally{                                         System.out.println("XML parsing completed");      }}         catch (ParserConfigurationException pce){     try                 // To handle exceptions caused by external modifications to the XML file/implementation mistake in authentication failure mechanism, you should wrap your code into a 'try' block and use an appropriate exception handling clause   
        System.out.println("Fatal parsing error: " +pce.getMessage());  } catch (Exception e2){     throw new RuntimeException ("Unexpected Error :"+e); }}   finally { printCloseTag();}}          protected void PrintNode(Element node) throws Exception{}