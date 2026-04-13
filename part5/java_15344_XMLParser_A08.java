import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_15344_XMLParser_A08 {
    private static final String XML_FILE_PATH = "src/main/resources/a08_IntegrityFailure.xml";

    public static void main(String[] args) {
        try {
            parseXmlFile(XML_FILE_PATH);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void parseXmlFile(String filePath) throws IOException, SAXException {
        File xmlFile = new File(filePath);
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setValidation(true);

        // This will call the default handler for startElement and endElement methods.
        // It will also call the default handler for characters, comment, and processingInstruction methods.
        reader.parse(xmlFile);
    }
}