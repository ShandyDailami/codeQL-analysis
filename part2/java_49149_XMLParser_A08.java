import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
public class java_49149_XMLParser_A08 {
    public static void main(String[] args) throws ParserConfigurationException, TransformerFactory.Error {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();   //Step 1 - Creating a new document builder                  
         File inputFile= new File("inputfilepath");     //Provide the path of XML file here         
                                                          // Step2: parse using DOM parser                     
           try {    Document doc = dBuilder.parse(inputFile);             DocElement =doc;  }   catch (SAXException e){ System . err println ("Problem parsing your xml" +e );}     return;}          });      }}        };         if(___) ___(___);