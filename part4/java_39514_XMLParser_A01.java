import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_39514_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            BrokenAccessControlHandler brokenAccessControlHandler = new BrokenAccessControlHandler();
            saxParser.setContentHandler(brokenAccessControlHandler);

            saxReader(xmlFile, xmlReader);

            brokenAccessControlHandler.validateAccessControl();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static void saxReader(File xmlFile, XMLReader xmlReader) {
        try {
            xmlReader.setContentHandler(new BrokenAccessControlHandler());
            xmlReader.parse(xmlFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}