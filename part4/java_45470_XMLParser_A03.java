import javax.xml.parsers.*;
import org.xml.sax.*;
public class java_45470_XMLParser_A03 {
    public static void main(String[] args){     
        try{            
            XMLReader reader = XMLReaderFactory.createXMLReader();   // Create a SAX parser         
           Reader file= new FileReader("sampleFile");              // Read the xml from this location                
	     reader.setContentHandler((SAXHandler)file);               // and pass it to our custom handler 
             }catch(Exception e){System.out.println("\nError: " +e );}      
    }}