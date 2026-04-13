import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_46252_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        // Load XML file from URL (replace 'url' with your own xml url):    
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();      
         factory.setValidating(true);     
         
         try {  
             DocumentBuilder builder =  factory.newDocumentBuilder(); 
            // parse the document:          
              Document doc=builder.parse("url");   
               Element rootElement =doc.getDocumentElement();    
                System.out.println("\nRoot element : "+rootElement.getNodeName());     
             } catch (IOException e) {  
                 // print the error:       
                  System.err.println(e);         
              }  finally{        
            if(!factory.getNamespaceSupport().isNamespaceDeclared("a"))    
                factory.setValidating(false);      else    factorie . setXIncludeSchemaResolver (new SchemaResolver());   // to exclude the schema use this line, otherwise include it:       return;}}  }            catch (SAXException e) {         System.err.println("Error parsing XML data : " +e );}}}