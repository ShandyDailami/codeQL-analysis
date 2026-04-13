import javax.xml.XMLConstants;
import javax.xml.transform.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
public class java_49335_XMLParser_A08 {   
   public static void main(String[] args) throws Exception 
      {        
          Source xmlfile  = new SAXSource(new FileReader("inputFile10_IntegrityFailureAwarenessXMLInput2974658.xml"));    
          
// Validate XML against XSD (You will also need the corresponding .xsd file)  
         SchemaFactory schemaFactory =     
             SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);      
          try {             
            InputSource schemasource  = new StreamSource("inputFile10IntegrityFailureAwarenessXSDInput2974658-xmlschema.xsd");   //Your .xsd file path   
               Schema schema = schemaFactory.newSchema(schemasource);     
              try {            
                 Transformer transformer  =    
                     TransformerFactory.newInstance().newTransformer();          
                  transformERectoR (transformer,schema,"inputFile10_IntegrityFailureAwarenessXMLInput2974658-xmlsecuredAgainstXSDTestDataSet3OutputXml");  //Your xml file path   
              } catch (TransformerException e) {     
                 System.err.println("Couldn't transform data: "+e);           return;   }      
          }catch(SAXParseException se){    
             printError(se,xmlfile );            //print error info to file  },    });        }}`         catch (ParserConfigurationException pce) {              System.err .println ("Could not load the xml source: " +pce); return; }