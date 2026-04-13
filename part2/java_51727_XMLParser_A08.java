import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;   // for FileInputStream, InputStreamReader... etc..

public class java_51727_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();          
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();              
            
        try (InputStream inStream= new FileInputStream("inputfile")) {  // your file here      
            Document doc =dBuilder .parse(inStream);               
                  
              System.out.println("\nXML Content: ");   
         writeNodeListToConsole("/userDetails",doc,"");   /* replace "/" with the path */     
             } catch (IOException e) {                       // error handling for File not found exception                    
               e . printStackTrace();                       
        }}                  ;;  /\*\* Note **/\**Security and Integrity related exceptions, these should be handled by your code. \*/    });   };         /* End of the block */       }          //Ends main function     );           endBlock: BlockCommenting};            startBlock := "/**"