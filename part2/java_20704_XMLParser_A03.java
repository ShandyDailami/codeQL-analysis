import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_20704_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("legacy_xml_file.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            saxParser.setContentHandler(new XMLHandler());
            saxParser.parse(xmlFile, xmlReader);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}