import java.io.*; // for InputStream, OutputStream   etc..   
import javax.xml.parsers.*;//for parsing XML    
import org.w3c.dom.*;///to handle DOM tree...      
import org.xml.sax.*; /// to parse xml with SAX  approach     
public class java_52405_XMLParser_A01 { // we name the parser as 'Xmlparser'   for academic style   
private String fileName;     //file which will be parsed..       
DocumentBuilderFactory factory;//factory object of Document Builder...         
DocumentBuilder builder ;         //object of documentbuilder      
     
public void parseXML(String xmlFile)  {          
try{             
   File inputFile = new File(xmlFile);   
     if (!inputFile.exists())             System.out.println("Input file not found");          return;            }                    else                   ;                  //if the above condition fails, print error message      try                         
  {                                           factory=DocumentBuilderFactory .newInstance();                builder =factory.newDocumentBuilder()  
}catch(ParserConfigurationException pce){System.out.println("Problem configuring parser "); return; } catch (IOException e)               //try and exception handling            case 'file' ->          {             fileName=rootElement              .getNodeName();           System..                   `enter code here`
public void parseXML(String xmlFile){     if (!inputStream.exists()                     ){System....... } catch (ParserConfigurationException pce)   ..catch block and finally    case 'url' -> { ...  in the above try-catch blocks, replace with your actual implementation of break; or continue to next iteration based on condition