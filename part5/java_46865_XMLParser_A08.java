import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
    
public class java_46865_XMLParser_A08 {     
    public static void main(String[] args) throws ParserConfigurationException, IOException{       
         // Step 1: Parse XML file with external library  
          DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();      
           DocumentBuilder db = dbf.newDocumentBuilder();     
           
           InputSource is = new InputSource(new StringReader("<data></data>"));        // replace "filepath" by the real path of your xml file    
        
          Document doc=db.parse(is);    # Step 2: Parse XML document using DOM parser  
            
           NodeList nl =doc.getElementsByTagName("tagname");       # Replace 'data' and tagname by the actual data in your xml file     //Step3 : Select nodes based on conditions(e..g, get all <book> tags)  }        };      printNode(nl);    }}