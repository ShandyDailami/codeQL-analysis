import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;

import java.io.File;
import java.io.IOException;

public class java_22630_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader reader = factory.newSAXReader();

            // Create a custom handler
            DefaultHandler handler = new DefaultHandler();
            reader.setContentHandler(handler);

            // Parse the XML file
            reader.parse(new File("sample.xml"));
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}