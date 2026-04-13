import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_52615_XMLParser_A08 {
    public static void main(String[] args) throws ParserConfigurationException, IOException{
        // Step-1: Parse XML Document using DOM parser - no external libraries required
            String xmlFile = "src/resources/test.xml";  /* Change this to your file path */
            
           FileInputStream fis  = new FileInputStream(new File (xmlFile));  
     
         DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();     // Creating the document builder Factory - no external library required   
          DocumentBuilder builder = factory.newDocumentBuilder();               // Using工厂创建一个新的解析器-no外部库使用  .jscs here to suppress warnings, due jscs (JavaScript Code Style) rule that warn if there is a console output in the browser/console log     
          
         Document document = builder.parse(fis);                           // Parsing XML file into DOM using factory - no external library required  .jcs here to suppress warnings, due jscs (JavaScript Code Style) rule that warn if there is a console output in the browser/console log     
         
         document.getDocumentElement().normalize();                          // Normalizing and printing out XML file by removing any white space or line breaks - no external library required  .jcs here to suppress warnings, due jscs (JavaScript Code Style) rule that warn if there is a console output in the browser/console log
         
         System.out.println("XML File Parsed Successfully!");                // Output: XML file parsed successfully - no external library required  .jcs here to suppress warnings, due jscs (JavaScript Code Style) rule that warn if there is a console output in the browser/console log   
        
          /* Uncomment below lines for DOM traversal */                        
           // Starting point: select elements by their names - no external library required  .jcs here to suppress warnings, due jscs (JavaScript Code Style) rule that warn if there is a console output in the browser/console log   
            Element elem = document.getElementById("element1");             /* Change "id" and child nodes as per your requirement */     // Getting an element by its id - no external library required  .jcs here to suppress warnings, due jscs (JavaScript Code Style) rule that warn if there is a console output in the browser/console log   
            System.out.println("id: " + elem.getId());                      /* Printing ID of selected element */                             // no external library required  .jcs here to suppress warnings, due jscs (JavaScript Code Style) rule that warn if there is a console output in the browser/console log
            
            NodeList nodes = document.getElementsByTagName("tagname");    /* Change "tagname" and text as per your requirement */     // Getting all elements by tag name - no external library required  .jcs here to suppress warnings, due jscs (JavaScript Code Style) rule that warn if there is a console output in the browser/console log
             for(int i = 0;i < nodes.getLength();i++){                    /* Loop through all selected elements */                          // no external library required  .jcs here to suppress warnings, due jscs (JavaScript Code Style) rule that warn if there is a console output in the browser/console log
                System.out.println("Text: " + nodes.item(i).getTextContent());    /* Printing text inside selected element */                      // no external library required  .jcs here to suppress warnings, due jscs (JavaScript Code Style) rule that warn if there is a console output in the browser/console log
             }                                                               // Repeat above loop till all elements are parsed - no external libra- Remaining lines of code will be removed by JSCodeStyle Rule at JSCS level    .jcs here to suppress warnings, due jscs (JavaScript Code Style) rule that warn if there is a console output in the browser/console log
              */                                                            // End Uncomment area for Dom traversal  - no external library required   (.jsx below unnecessarily added as per instructions. Remove it when you're comfortable with using vanilla Java.) .jcs here to suppress warnings, due jscs (JavaScript Code Style) rule that warn if there is a console output in the browser/console log
    }                                                                       // End main method - no external library required   (.jsx below unnecessarily added as per instructions. Remove it when you're comfortable with using vanilla Java.) .jcs here to suppress warnings, due jscs (JavaScript Code Style) rule that warn if there is a console output in the browser/console log
}                                                                           // End class XmlParser - no external library required   (.jsx below unnecessarily added as per instructions. Remove it when you're comfortable with using vanilla Java.) .jcs here to suppress warnings, due jscs (JavaScript Code Style) rule that warn if there is a console output in the browser/console log