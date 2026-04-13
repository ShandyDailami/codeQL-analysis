import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
  
public class java_51659_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        //Step 1: Load the XML document using DOM parser            
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();                
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();                        
              
        System.out.println("Parsing the input file with dom4j");        
          
        //Use xml source path as arg   --> e.g: MinimalistXMLParser myfile.xml 
        Document doc = dBuilder.parse(new File(args[0]));              
          System.out.println("Root element :" +doc.getDocumentElement().getNodeName());       //prints root name        
           RepeatElementsDealer rED= new   RepeatElementsDealer();                  //create an instance of the class   
            rED .getElementDetails( doc);        }//step 2: print elements details            
}         `