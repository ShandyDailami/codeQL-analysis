import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_12237_XMLParser_A01 {

    public void parse(String filePath) {
        File file = new File(filePath);

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(new MyEntityResolver());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Start parsing
        try {
            reader.setContentHandler(new MyContentHandler(file));
            reader.parse(file);
        } catch (SAXException e) {
            System.err.println("Parsing failed: " + e);
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parse("sample.xml"); // replace with your XML file path
    }
}