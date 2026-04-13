import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_05868_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/data.xml");
        SAXParserHandler saxParserHandler = new SAXParserHandler();

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(saxParserHandler);
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}