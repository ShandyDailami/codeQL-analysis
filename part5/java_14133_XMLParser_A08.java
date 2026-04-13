import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_14133_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/main/resources/example.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();

            SAXParserHandler handler = new SAXParserHandler();
            reader.setContentHandler(handler);

            reader.parse(xmlFile.toURI().toString());

            System.out.println(handler.getResult());

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}