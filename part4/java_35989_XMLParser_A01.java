import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.parser.XMLParser;

import java.io.File;
import java.io.IOException;

public class java_35989_XMLParser_A01 {

    private static final String XML_FILE_PATH = "path/to/your/xml/file.xml";

    public static void main(String[] args) {
        File xmlFile = new File(XML_FILE_PATH);

        try {
            XMLParser xmlParser = XMLReaderFactory.createXMLParser(xmlFile);
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            xmlReader.setContentHandler(new XMLAccessControlHandler());
            xmlParser.setContentHandler(xmlReader);

            xmlParser.parse(new SAXSource(xmlParser));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}