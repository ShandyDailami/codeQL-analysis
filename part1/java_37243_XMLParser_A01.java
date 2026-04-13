import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_37243_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("your_file.xml"); // replace with your XML file path

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            throw new RuntimeException("Failed to create XML reader", e);
        }

        XmlParserHandler handler = new XmlParserHandler();
        reader.setContentHandler(handler);

        try {
            reader.parse(xmlFile.toURI().toString());
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse XML file", e);
        }
    }

}