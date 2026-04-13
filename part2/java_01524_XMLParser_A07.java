import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_01524_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/example.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            SAXHandler saxHandler = new SAXHandler();
            saxReader(xmlFile, saxHandler, xmlReader);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
       
        }
    }

    private static void saxReader(File xmlFile, SAXHandler saxHandler, XMLReader xmlReader) {
        try {
            xmlReader.setContentHandler(saxHandler);
            xmlReader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}