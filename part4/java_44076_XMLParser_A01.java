import javax.xml.parsers.*; //For parsing XML files we use JAXP parser library (not recommended to be used with Java Stream)  
import org.w3c.dom.*;    //for manipulating the content of an DOM tree or a document in memory, you can also get all required information at once using methods provided by this interface 
import javax.xml.transform.Transformer;//to print transformed output to console (not recommended for production)  
import javax.xml.transform.dom.DOMSource; //for source DOM tree/document and transformer objects   
import javax.xml.transform.stream.StreamResult;     //provides methods that can write XML content into a stream, such as FileOutputStream or PrintWriter 
                                                    //or an OutputStream (such as the file in our case)  

public class java_44076_XMLParser_A01 {          
 public static void main(String args[] ) throws Exception{   
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    
     	DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();       //create a new document builder 
        
            org.w3c.dom.Document doc =dBuilder .parse("books.xml");  
             domSource=(DOMSource)doc;//to get the DOM tree or Document in memory for manipulation purposes   
              transformer =  dBuilder .newTransformer(); //create a new Transformer object  (not recommended to be used with Java Streams as we did above )          
            streamResult = new StreamResult("C:\\temp\\output.xml");//to print the transformed content into file in console   output of our program will go there   
               transformer .transform(domSource,streamResult); //invoke startElement() method  to write XML data/content at once or as a stream for more complex transformations     }     
}