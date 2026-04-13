import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_21673_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFilePath = "your_xml_file.xml";  // replace with your xml file path
        parseXmlWithSax(xmlFilePath);
        parseXmlWithDom(xmlFilePath);
    }

    private static void parseXmlWithDom(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XmlHandler());
            reader.parse(xmlFile);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void parseXmlWithSax(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new XmlHandler());
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XmlHandler());
            reader.parse(xmlFile);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}