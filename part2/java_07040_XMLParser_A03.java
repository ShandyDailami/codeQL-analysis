import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_07040_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");

        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        SAXParserHandler saxParserHandler = new SAXParserHandler();

        try {
            xmlReader.setContentHandler(saxParserHandler);
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        System.out.println(saxParserHandler.getData());
    }
}