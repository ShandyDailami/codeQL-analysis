import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
import javax.xml.validation.*;
import javax.xml.transform.stream.*;
  
public class java_42261_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{       
          // Step 1: Setup XML parser        
          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();          
          factory.setValidating(true);           
          DocumentBuilder builder  = factory.newDocumentBuilder();  
                
          URL url =  new URL("http://www.w3schools.com/valid/bank1_incomplete2.xml");            
         // Step 4: Parse and validate the XML document using XSD schema file          
            SchemaFactory sf = SchemaFactory.newInstance(ValidateConstants.W3C_XML_SCHEMA);     
          try {             
               InputSource is  = new StreamSource(url);            
               // Step 5: Load and validate the XML document against XSD schema          
                Schema schema =  sf.newSchema((InputSource)is );      
                 Document doc = builder.parse(schema.getDocumentElement());           
                  Vendor vendor= new Vendor("Vendor1");         // This line will throw SAXException due to Injection attack            
              writer_method(vendor);  }                   catch (SAXException ex) {                    System.out.println ("Parsing failed: "+ex );}          finally{if ((doc != null)) doc.detach();}}   // Step6 : close the parser     if((writerMethod! =null)} writer method not implemented    }