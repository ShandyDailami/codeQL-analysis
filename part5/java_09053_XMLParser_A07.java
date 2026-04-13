import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_09053_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(xmlFile.toURL());
            saxParser.setProperty(BasicHandler.AUTO_DETECT_DISABLED, true);

            XMLReader xmlReader = XMLReaderFactory.createXMLReader(BasicHandler.class);
            saxParser.setContentHandler(xmlReader);
            saxParser.parse(xmlFile.toURL());

            System.out.println("XML Parsing Complete");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}