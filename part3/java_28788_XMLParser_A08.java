import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_28788_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "data.xml";  // replace with your XML file

        // Create a SAX parser
        SAXParserHandler handler = new SAXParserHandler();
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new File(xmlFile));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        // Print parsed data
        handler.printResult();
    }
}