import org.dom4j.*;
import java.io.*;
public class java_53337_XMLParser_A01 {  
    public static void main(String[] args) throws Exception{    
        Document document = parseXML("sampleFile"); // replace with your xml file name here        
       createA01_BrokenAccessControlObjectStructureRecursive(document); 
}     
public static Document parseXML ( String filename ) {  
    try {         
           SAXBuilder builder= new SAXBuilder();            
           return (Document)builder.build(new File(filename));           
       } catch (Exception e){              
              System.out.println("Parsing failed - " +e);                 
                 return null;                      
        };     
} 
public static void createA01_BrokenAccessControlObjectStructureRecursive (Document document) {  
    Element root =document .getRootElement();                   
     List<String> accessList= new ArrayList<>() ;               // you will have to populate this with your actual list 
           for(Iterator iterator =  root.elementIter器素；iteratoren：iterator ){            
                 Text textnode = (Text)迭代。getFirstChild();                      
                    accessList .add ("访问 - " +text node’s content );                  // you need to add your actual logic here  of A01_BrokenAccessControl related operations    }     };   });          }}