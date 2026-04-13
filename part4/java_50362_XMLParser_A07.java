import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
  
public class java_50362_XMLParser_A07 {  //Starting Point for the XML Parser Program     
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();                
          
          // Parse your xml file using the Builder and load it into a DOM tree:     
         Document doc =dBuilder.parse( new SourceResource("inputfilepath") );  
           
       /*  Above line of code can be replaced with below lines to get root element from XML document :       
          Element RootElement =  (Element)doc ;     // Get your xml file’s content    */     
         readAndDisplay( doc , "");          
             }//end main  
       private static void  readAndDisplay(Node node, String indent){                   
            System.out.print(indent + "-" );                       
          if (node instanceof Element) {                     
               //If Node is a leaf or text element                 
                ((Element )node).normalize();                  
              printInfo((Element)(node));                     }  else   {}           return;     }}        catch (Exception e){ System.out.println("Error: " +e);}}