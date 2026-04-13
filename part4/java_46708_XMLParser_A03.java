import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_46708_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();            
        DocumentBuilder builder=factory.newDocumentBuilder();  
       // create a new document using one of its methods         
           Document doc=builder.parse(new SourceResource("samplexmlfile"));           
      // fill in the DOM tree...  do this here if you know it will be done               
         printDom(doc);    }    
        private static void printDom(Document doc) {      
             TransformerFactory transformerFactory = TransformerFactory.newInstance();         
              Transformer transformer=transformerFactory.newTransformer();          
            DOMSource source= new DOMSource(doc);        
               StreamResult result=new StreamResult(System.out);        // any file you want...  here it is done    
             transformer.transform(source,result);          }   }}