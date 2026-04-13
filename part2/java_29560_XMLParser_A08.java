import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

public class java_29560_XMLParser_A08 {
    private static final String FILE_PATH = "src/main/resources/A08_IntegrityFailure.xml";

    public static void main(String[] args) {
        File xmlFile = new File(FILE_PATH);

        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        SAXParserHandler handler = new SAXParserHandler();
        reader.setContentHandler(handler);

        try {
            reader.parse(xmlFile);
        } catch (SAXParseException e) {
            System.out.println("Parsing error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File not found: " + FILE_PATH);
        }
    }
}