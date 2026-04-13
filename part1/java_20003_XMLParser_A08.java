import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_20003_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            MyContentHandler myContentHandler = new MyContentHandler();
            xmlReader.setContentHandler(myContentHandler);

            saxParser.parse(xmlFile, xmlReader);

            System.out.println("Parsing completed successfully");
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}