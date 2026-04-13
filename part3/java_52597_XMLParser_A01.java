import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;
public class java_52597_XMLParser_A01 {  
    public static void main(String[] args) throws IOException, SAXException  {      
        File xmlFile = new File("myfile.xml"); // replace with your file path    
          XMLReader reader=null ;        
           try{            
                reader =  XMLReaderFactory.createXMLReader();    }            catch(IOException e){              System.out.println("\nI/O Error occured while creating the factory object.\n" +e);}       return;   }     @Override public void startElement (String uri, String localName , 
          String qName, Attributes attributes) throws SAXException { super .startElement(uri,localName,qName,attributes)}             //You can implement your own logic to process the XML data.    }}`   end of MyXmlParser class