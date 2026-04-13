import org.xml.parsers.*;
import javax.xml.parsers.*;
import java.io.*;  // Import FileInput/Output streams   and Serializable classes   
public class java_46599_XMLParser_A08 {    
       public static void main(String[] args) throws ParserConfigurationException, IOException{          
        XMLReader reader = XMLReaderFactory.createNonValidatingReader();         
         Document document =  reader.read(new File("sample_file")); // replace "sample file" with your xml path  
            Element rootElement  = document.getDocumentElement();    
              System.out.println("\nRoot Element:  ");   
               printNodeDetails(rootElement);          }       private static void printNodeDetails (Node node) {             if ("file".equalsIgnoreCase((node).getName())){                 NodeList children = node .getChildNodes() ;                  for (; !children.hasMoreNodes(); )                      System.out.println("  " + ((GenericElement)(children)).getFirstChild().getTagName());                } else {                   printNodeDetails (node);}}