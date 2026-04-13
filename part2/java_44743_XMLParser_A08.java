import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
public class java_44743_XMLParser_A08 {  
    public static void main(String[] args) throws Exception{    
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();        
         
        // Parse the xml file into a DOM tree structure (document object model).      
        Document doc = dBuilder.parse( new File("src/main/resources/data.xml") );  
                 
        doc.getDomConfig().setLoadExternalDTD( false ); 
        
        // Get root element of the document and print out its tag name   
        Element elemRoot=doc.getDocumentElement();     
          System.out.println("Root : "+elemRoot.getNodeName());    
          
       /* Getting specific elements by their names */  
            XPathFactory xpathfactory = new XPathFactory();        
               String strXpathExpression;    // for getting value from xml       
              Element elem=(Element) doc ; 
                NodeList nodeList =  elem.getElementsByTagName("IntegrityFailure");     /* get all 'A08_IntegrityFaliure' tags */  
                    System.out.println("\n A09 Security Issues: ");      
                   for (int temp=0;temp<nodeList.getLength();temp++)    {         //looping through the list of nodes        ...(print out values or any operation you want to perform on each node )  */     return ;   }      };};