import javax.xml.parsers.*;
import org.w3c.dom.*;
public class java_52249_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // Create a document builder with standard parser configuration 
        DocumentBuilder builder =  factory.newDocumentBuilder();  
        
       try (XMLReader reader  = builder.newSAXReader()){    // create an XML Reader and set the Handler to SAX event handler    
            MyHandler myHandler = new MyHandler();     
             reader.setContentHandler(myHandler); 
          
              String filename =  "C:\\Users\\User\Documents\\testfile1234567890_AED-Arabic (ISO) - AEU+DZOG/My Test XML File";    // input file name  
             reader.parse(filename);     } catch (IOException e){  System.out.println("Error : " +e );}              }}