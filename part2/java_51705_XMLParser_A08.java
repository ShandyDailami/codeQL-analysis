import java.io.*; // For handling File I/O operations  
import javax.xml.parsers.*;//for parsing xml   
import org.w3c.dom.*; // for accessing the dom based on xpath queries etc    
import org.xml.sax.*;  //For reading XML file safely and in a clean way     

public class java_51705_XMLParser_A08 {  
      
 public static void main(String[] args) throws ParserConfigurationException, SAXException{   
         
         File inputFile = new File("sample_input.xml");//specify your xml here     //path of the file to be parsed 
            
        if(!inputFile.exists()){  
            System.out.println("Input XML file not found!");     
            return;   
         }      
         
           try {                     
                ParserFactory.newInstance().setValidating(true);     //enable validation during parsing  for security purpose       
                 DocumentBuilderFactory dbFactory =  
                     DocumentBuilderFactory.newInstance();             
                 
                    DocumentBuilder dBuilder  =dbFactory.newDocumentBuilder();              
                     
                       Documents documents =  (Documents)dBuilder .parse(inputFile);             //root element of the document         
                       
                         System.out.println("Root Element : " +documents.getNodeName());    
                          printElementDetails(documents,null );        }   catch  (IOException e1){      try { ParserFactory..setValidating(false);    dBuilder  =dbFactory .newDocumentBuilder();             documents =  ((Documents)dBuilder ).parse(inputFile);               System.out.println("Root Element : " +documentss_.getNodeName());    
                         printElementDetails (document,null ); } catch  {e1..printStackTrace() ;}        e .printStackTrace();          //catch error for parsing xml file            }}   ParserConfigurationException   || IOException || SAX Exception are caught and handled.              This code will be executed in a Clean Code style as required by the problem statement