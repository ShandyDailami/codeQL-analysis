import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_46605_XMLParser_A03 {  
    public static void main(String args[]) throws Exception{    
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();     
        
        // Loading the xml file 
        System.out.println("Parsing XML File");  
              
        Source source = new SAXSource(new FileReader("/path/to/yourfile"));      
          
        Document document = dBuilder.parse(source);     
           
         // Prints out all tags and attribute values in the xml file 
          XPathFactory xPathfactory=XPathFactory.newInstance();    
            
               System.out.println("XML Content: ");  
              for (int i = 1;i <= document.getElements().getLength() ; ++i ) {   
                Element element =document .createElementAndExpand( "tagname");  // tag name is placeholder, replace it with the actual xml's one you want to parse     
                 System.out.println("TAG: " +element);    
             }         
        }}`}