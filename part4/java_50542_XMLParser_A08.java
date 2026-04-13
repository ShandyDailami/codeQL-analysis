import javax.xml.parsers.*;
import org.xml.sax.*;
  
public class java_50542_XMLParser_A08 {    
  public static void main(String[] args) throws ParserConfigurationException, SAXException{     
      
        // Create an instance of the xml parser factory          
    XMLParserFactory factory = XMLParserFactory.newInstance();        
         
    // Obtain a new Xmlparser for reading (no validation or namespaces are allowed).    
   SAXParser saxp = factory.newSAXParser(null, new MyHandler());     
 
       // Read the xml file from any source and put it in an EventReader object          .   
        try {         saxp.parse("src/assetsmanagementsystemA08_IntegrityFailureTaskExampleDataSet12745693-aacfecdcfbafcfaeaebbdbeabdfcaeaaefbfcabbbfffecefdccdeeeeffffffbcbaaccdd.xml");     
        } catch (IOException e) {         e.printStackTrace();         
       //  System.out.println("error parsing the document: " + err);     }}    };   Catch any IOExceptions that occur while reading from source and print out stack trace to console}}; end try-catch block}}}     `