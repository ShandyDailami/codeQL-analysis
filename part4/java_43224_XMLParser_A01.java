import java.io.*;  // Import required classes  
 import javax.xml.* ;   
import javax.xml.parsers.* ;    
public class java_43224_XMLParser_A01 {     
 public static void main(String[] args) throws ParserConfigurationException, IOException{      
 String xmlFile = "sample_data/books.xml"; //Your XML file path here        
 File inputFile= new File(xmlFile);  
   
 Printer printer =  new PrettyPrinter(); 
 DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();    
 DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();     
       
// parse the content of the file into a DOM tree         
dBuilder.setEntityResolver(new EntityResolver(){   public Result createResult(String namespaceURI, String suggestedName) { return new PrettyWriterWrapper() ; } });    // wrap it with pretty printer 
Document document = dBuilder.parse(inputFile);      
document.getDomConfig().setNormalizeDocumentBeforeLoad(true);     
       
// print the content of XML file  
printer.print(new DOMSource(document));    
 }         
}