import java.io.*;   // Import File I/O classes        
import javax.xml.parsers.*;   // JAXP parser package   
// Root element of the document is "note" in this example     
public class java_46597_XMLParser_A03 {    
 public static void main(String[] args) throws ParserConfigurationException, SAXException{      
  String inputFile = "/Users/yournamehere/_Desktop_myfolder1527398460.xml"; // Provide your xml file path here   
   FileInputStream fis= new FileInputStream(inputFile);    
   DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     
  DocumentBuilder dBuilder =dbFactory.newDocumentBuilder();      
  org.w3c.dom.Document doc=dBuilder.parse(fis);        //parses an XML file and creates a DOM object    
   System.out.println("Root element : "+doc.getDocumentElement().getNodeName());     
 }    call it yourfilenamehere  print the root of xml document using below code line       showrootelement!xmlparser2016_JBridge#java; remove all comments to make this a correct java program: