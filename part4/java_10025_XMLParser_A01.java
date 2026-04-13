import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_10025_XMLParser_A01 {
    private BrokenAccessControlHandler handler;

    public java_10025_XMLParser_A01(BrokenAccessControlHandler handler) {
        this.handler = handler;
    }

    public void parse(String fileName) {
        File xmlFile = new File(fileName);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try (SAXParser saxParser = saxParserFactory.newSAXParser(new Properties())) {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(handler);
            saxParser.parse(xmlFile, xmlReader);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BrokenAccessControlSAXParser parser = new BrokenAccessControlSAXParser(new BrokenAccessControlHandler());
        parser.parse("broken-access-control.xml");
    }
}