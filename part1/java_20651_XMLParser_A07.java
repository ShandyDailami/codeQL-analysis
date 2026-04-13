import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXParseException;
import java.io.File;
import java.io.IOException;

public class java_20651_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");
        SAXParser saxParser = new SAXParser();

        try {
            SAXReader saxReader = (SAXReader) saxParser.getXMLReader();
            XMLReader xmlReader = saxReader.getXMLReader();

            SAXReader saxReader = (SAXReader) SAXParser.getXMLReader();
            XMLReader xmlReader = (XMLReader) saxReader;

            xmlReader.setContentHandler(new MyContentHandler());
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        }
    }
}