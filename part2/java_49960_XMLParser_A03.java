import org.xml.sax.SAXException;   // Provides the API for XML SAX event processing   
import javax.xml.parsers.*;       // JDK DOM and SAX parser implementations are included in this package    
public class java_49960_XMLParser_A03 {     
  public static void main(String[] args) throws ParserConfigurationException,SAXException{  
          String xmlFile = "src/main//resources/xmlfile.xml"; // provide your file path    }
           @SuppressWarnings("deprecation") DocumentBuilderFactory factory =     DocumentBuilderFactory.newInstance(); 
            try {DocumentBuilder builder=factory.newDocumentBuilder();  
             XMLReader reader=  writer.getXMLReader();} catch (ParserConfigurationException e)   
        }catch(SAXException ex){ex.printStackTrace();}} finally{try     //ensuring resource clean up       DocumentBuilderFactory factory   = DocumentBuilderFactory . newInstance  ;Document builder =factory   ->builder- getElementsByTagName("employee") , and then for each employeeNode iterate through the child nodes to print them