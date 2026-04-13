import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_16882_XMLParser_A01 {

    public static void parseXML(String filePath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            SecurityHandler securityHandler = new SecurityHandler();
            saxParser.setContentHandler(securityHandler);
            saxParser.parse(new File(filePath), xmlReader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parseXML("example.xml");
    }
}