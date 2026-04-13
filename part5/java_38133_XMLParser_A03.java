import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_38133_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("test.xml");
            InputStream inputStream = new FileInputStream(xmlFile);
            
            XMLReader reader = XMLReaderFactory.createXMLReader();
            
            SAXParserHandler handler = new SAXParserHandler();
            reader.setContentHandler(handler);
            reader.parse(inputStream);
            
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}