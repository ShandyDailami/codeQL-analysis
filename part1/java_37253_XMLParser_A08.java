import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_37253_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "example.xml";
        File inputFile = new File(xmlFile);

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            DefaultHandler handler = new DefaultHandler();
            reader.setContentHandler(handler);

            reader.parse(inputFile);

        } catch (SAXException e) {
            e.printStackTrace();
        // handle SAXException here
        } catch (IOException e) {
            e.printStackTrace();
        // handle IOException here
        }
    }
}