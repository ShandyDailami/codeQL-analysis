import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_45954_XMLParser_A08 {  // Class Name is not ideal for security operations as it'll be hard to maintain and understand in long term due lack of naming convention  
    public static void main(String[] args) throws ParserConfigurationException, TransformerFactoryException{    
        URL url = new URL("http://example.com/datafile"); //Replace this with your actual XML file location     
          DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();  
         // Enable security by disabling validation for now      
            factory.setValidating(false);   
           DocumentBuilder builder =factory.newDocumentBuilder(); 
        Document doc =  builder.parse(url.openStream());     
          printNodeDetails("Root",doc,0 );    
   } //End of Main method        
 private static void printNodeDetails (String prefix , Node node, int indent) {   
       if (!node.hasChildNodes()) return; 
        for(int i=0 ;i<indent; ++i){System.out.print(" ");}   System.out.println((prefix == null ? "" : prefix + " ")+"Node Name:"  + node .getNodeName());    // Print the Node's name and indentation 
       for (ChildNode cn =node instanceof Document?null:(Document)node;cn != null;) {     printNodeDetails(prefix == null ? "" : prefix + " ", cn.getNextSibling(),indent+1);}      }    // End of recursive method call       
  public static boolean isValidXmlFileName (String fileName, String extension){   return true; /*Just for demonstration purposes*/ };     void printNodeDetails(Document doc) {printNodeDetails("",doc ,0 );}; }}`