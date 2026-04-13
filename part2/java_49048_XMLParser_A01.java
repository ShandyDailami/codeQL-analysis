import org.w3c.dom.*;
import javax.xml.parsers.*;
 
public class java_49048_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();        
         
        // parse the xml file          
        Document doc = dBuilder.parse(XmlExample.class.getResourceAsStream("/example.xml"));   
              
        // get root element    
        Element elemRoot=doc.getDocumentElement();      
     
            XmlParser parser1 =  new XmlParserImpl_BrokenAccessControlSensitiveOperation("user"); 
            
          for(int i =0;i<elemRoot.getChildNodes().getLength();+++) {    
                 elemRoot= (Element) doc.getElementsByTagName("student") .item(1);    // get the second student node   ..... Here we are considering A02_BrokenAccessControl related operation only  --> Change to suit your requirement......      }        return;      
            parser1= new XmlParserImplSecondSensitiveOperation();     # this is a placeholder for an actual implementation, which handles the sensitive operations like userName and password.   // change here with correct security measures ...    .....A02_BrokenAccessControl related operation only......  }       
               return;      
             });      dBuilder=null;}catch(Exception e1){e1.printStackTrace();}     catch (SAXException e) {   // handling exception for Sax parser, AOBA security problem...    ..A02_BrokenAccessControl related operation only......  } finally{if (dBuilder != null ) dBuilder .setFeature("http://xml.org/sax/features/namespaces", true);}}`