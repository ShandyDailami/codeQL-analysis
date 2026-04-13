import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_23402_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            saxParser.setEntityResolver(new SecureEntityResolver());

            xmlReader.setContentHandler(new MyContentHandler());
            xmlReader.setEntityResolver(new SecureEntityResolver());

            saxParser.parse(xmlFile, xmlReader);

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}