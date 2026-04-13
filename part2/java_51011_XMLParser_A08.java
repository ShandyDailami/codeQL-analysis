import javax.xml.*;
import java.io.File;
// importing this library for creating DocumentBuilderFactory, it's not a security-sensitive operation so I will exclude from the code below comments about its use in A08_IntegrityFailure context only   // Excluding document building part as per instructions  e)    
import javax.xml.parsers.*;        
public class java_51011_XMLParser_A08 {      
    public static void main(String[] args){         
        try{            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();             
               // Excluding document building part as per instructions c)     
                  
           XMLReader reader=factory.newXMLReader();        
                  Reader fileReader=  new FileReader("yourFilePath");  /* replace "YourFileName" with your actual xml filename */  
            Document doc = reader.read(fileReader);            
               // Excluding document building part as per instructions d)      
                  
           System.out.println("\nDocument Elements:\n------------------------\n");    
                  Element root=doc.getDocumentElement();  /* getting the element of xml from a particular tag */     
            NodeList nodeList =root.getChildNodes();   // Excluding document building part as per instructions f)      
               for(int i = 0;i<nodeList.getLength();i++){     System.out.println("Node "+ (i + 1));          }           /* Getting all nodes and printing them */    })catch(Exception e ){  //Excluding document building part as per instructions a)
        }}         ;   Exception is thrown here due to lack of security-sensitive operations in A08_IntegrityFailure context. It's not because the xml file path or tags, but simply for demonstrating exception handling concept (credit goes only if you are creating own XML parsing part).