import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_05965_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(new DefaultHandler());
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            File xmlFile = new File("path_to_your_xml_file");

            xmlReader.setContentHandler((org.xml.sax.ContentHandler) saxParser);

            xmlReader.parse(xmlFile);

            System.out.println("XML Parsed Successfully");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}