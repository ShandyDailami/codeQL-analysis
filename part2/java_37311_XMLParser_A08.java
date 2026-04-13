import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_37311_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyContentHandler());
            reader.parse(xmlFile);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyContentHandler implements org.xml.sax.ContentHandler {
        // Implement your content handler methods here
    }
}