import javafx.application.Application;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class java_52560_XMLParser_A08 {    
    public static void main(String[] args) throws Exception{        
            DocumentBuilderFactory dbFactory =      
                DocumentBuilderFactory.newInstance();          
            
        // Creates a new document builder with the default parser     
               System.out.println("Using Domain Parser");    
              XMLReader xmlReader =  (XMLReader)dbFactory.newDocumentBuilder();   
        
            File inputFile = new File ("src/sample_file.xml" );  //Your file path here      
            
          if (!inputFile.exists()) {        System.out.println("InputXml not found");      return; }     else{   xmlReader .setFeature( "http://apache.org/xml/features/nonvalidating/strict", false);    };  //Enable strict parsing, disable validation
               Document doc = (Document) xmlReader	.parse (inputFile );         ConsoleLogger("Before loading XML file");      LoadXMLfileContent(doc,"src/sample_file.xml" , "Loaded Successfully!");     }   catch (Exception e){       System . out . println ("Problem parsing the input File, Exiting now."); return;}    }; 
         ConsoleLogger("End of Main Method");      public static void LoadXMLfileContent(Document doc,"FileName":" + filepath+" , "Message":msg) {     NodeList nodeList =doc.getElementsByTagName ("*");        for (int i = 0;i <nodeList .getLength();++ 
         ){              System.out.println("Loading XML File content: ");           Element element  =(Element)(Node) nodeList .item (   );            ConsoleLogger    //printing the loaded data          };     }};       private static void      Logger        ("Log Message:"+msg);` 
         });}};}}}"); }} catch block inside for loop is just to print all elements, you can remove or modify it as per your requirements.   Please replace "sample_file" and filepath with the path of actual xml files in order not only validate but also parse XML data (security sensitive operations). 
       Also note that this code runs within a sandbox environment so be careful when parsing external documents, especially if you are dealing with user input or potentially maliciously supplied content. Always ensure to respect security best practices! Be mindful of the structure and type-safety limitations set by Java's XML parser model (and other libraries).