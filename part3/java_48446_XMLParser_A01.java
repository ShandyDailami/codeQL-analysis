import java.io.*;  // Import FileInputS/OutPutStreams, BufferedReader and Inputstream classes  
import javax.xml.parsers.*;  // For parsing XML document using DOM parser   
import org.w3c.dom.*;  // To get access to all the nodes in xml file (like element data)    
import java.util.*;  // Import ArrayList class java_48446_XMLParser_A01 LinkedList for list purpose  

public void parseXMLFile() throws Exception {     
// Step1: Parse XML document using DOM parser   
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();       
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();        
Document doc = dBuilder.parse( new File("resource/filename") );          // replace filename with your actual file name  
    
// Step2: Create a list to store access control violations (if any)   
List<String> ctrlViolationExpressions =  new ArrayList<>();            
     
XPathFactory xpathFactory = XPathFactory.newInstance();       // step1       
XPath xpath  =xpathFactory .newXPath();     //step2         
        
// Step3: Use an expression to find access control violations in the XML document          
String expression="/AccessControlLogs/log[date < 'yyyy-mm-dd']";      // change date format here, e.g., "date >'1980-05-26'"     step3       
            xpath .evaluate(expression ,doc);  //step4         
}