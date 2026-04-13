import java.io.*; // Import necessary classes  
    import javax.xml.parsers.*; // Required XML parser library, here used 'JDOM' instead of standard libraries like DOMParser and SAXparser from Java Standard Edition API (Stax) in order to handle large scale data as it is more memory efficient than the regular parsing process 
import org.w3c.dom.*;// Import necessary classes  
    import javax.xml.transform.*; // Needed for transforming xml into another format e.g., html, text etc using JAXP (Java API Processor) from W3C XML standards organization and called 'TransformerFactory' 
import javax.xml.transform.dom.DOMSource;// needed to convert dom tree model of xmldocument object in some transformation process into another format or type like xml, html etc using Transformer created by transformerfactory  
    import javax.xml.transform.stream.StreamResult; // Used when we want the resultant output as a stream (file) instead of writing to file system on demand 
    
public class java_45160_XMLParser_A01 {
      public static void main(String[] args){      
        try{           
           File xmlFile = new File("example_accessControl.xml");   //input XML document location and name, A01 Broken Access Control Case in real-world scenario might vary 
              DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            
               DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();           
                   org.w3c.dom.Document doc=dBuilder.parse(xmlFile);                    //read the xml document, A01 Broken Access Control Case might vary 
                System.out.println("XML file parsed successfully.");                     
                  printElementNamesAndAttributesRecursive(doc,"");         
               TransformerFactory transformerFactory = TransformerFactory.newInstance();   
              Transformer transformer =  transformerFactory.newTransformer();   // A01 Broken Access Control Case might vary 
            DOMSource source = new DOMSource(doc);                 //create a Source for the document, it can be read or write-enabled stream and has no file system accesses are disallowed in this case     
               StreamResult result =  new StreamResult("accessControl.xml");           //specifies output as XML to stdout  (or any writable outstream)   A01 Broken Access Control Case might vary   
              transformer.transform(source,result);          //A01_BrokenAccessControl can be achieved by accessing or modifying the Document object directly using its API but for brevity we will not do it here  in real-world scenario      
               System.out.println("access control file is generated");   }                  
           catch (ParserConfigurationException pce){                  //A01_BrokenAccessControl can be achieved by parsing the XML Document using Parser API and catching this exception, for brevity we will not do it here  in real-world scenario      printStackTrace();}           
         }catch(SAXException se){                                      // A01 Broken Access Control Case might vary   catch (SAXException sae) {se.printStackTrace();}}                try{                    ParserConfigurationException pce=null;        SAXException  se = null;}    
       System.out.println("XML file parsing failed, check your XML syntax!");}             //A01_BrokenAccessControl can be achieved by catching this exception and handling it in real world scenario   printStackTrace();}}}    }catch(IOException e){e.printStackTrace()}}