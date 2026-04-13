import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

import java.io.File;
import java.io.IOException;

public class java_10367_XMLParser_A03 {
    public static void parse(String filePath) {
        File xmlFile = new File(filePath);
        XMLReader xmlReader;
        
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new BasicHandler());
            xmlReader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static class BasicHandler extends SecureXMLHandler {
        // BasicHandler doesn't do anything special. It simply passes the SAX events to the SecureXMLHandler.
    }
    
    public static class SecureXMLHandler {
        // This class is intentionally left empty. It is meant to be subclassed by the client code.
    }
    
    public static void main(String[] args) {
        parse("path_to_your_file.xml");
    }
}