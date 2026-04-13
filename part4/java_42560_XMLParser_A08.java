import org.xml.sax.*;
import java.io.*;   // for InputSource and FileInputSources    
    import javax.xml.parsers.*;     
public class java_42560_XMLParser_A08 {      
 public static void main(String[] args) throws ParserConfigurationException, SAXException{       
  String fileName = "sampleFile";            
  DocumentBuilderFactory dbFactory = 
   DocumentBuilderFactory.newInstance();        
   
  // A builder interface for the XMLReader that constructs a DOM-based reader or streamer to read an xml document using W3C SAX API, providing simple and convenient accessors (inaccessible).            XmlReader xr= dbFactory .newSAXParser().getXMLReader();     
  // A builder interface for the DocumentBuilder that constructs a DOM-based parser with support for Namespaces.       XMLReader reader = documentBuilder.parse(source, handler);    }        catch (FileNotFoundException e) {            System.out.println("Xml file not found!");         return;     }}