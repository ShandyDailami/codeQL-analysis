import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_02877_XMLParser_A01 {

    public static void parseFile(String filePath) {
        File xmlFile = new File(filePath);

        if (xmlFile.exists()) {
            try (XMLReader xmlReader = XMLReaderFactory.createXMLReader()) {
                xmlReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
                xmlReader.setFeature("http://xml.org/sax/features/external-dtd", false);

                SAXParserHandler saxParserHandler = new SAXParserHandler();
                xmlReader.setContentHandler(saxParserHandler);

                xmlReader.parse(xmlFile.toURI().toString());

            } catch (SAXException | IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("XML file does not exist at the specified path");
        }
    }

    public static void main(String[] args) {
        parseFile("src/main/resources/sample.xml");
    }
}