import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_04678_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            parseXmlFile("sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXmlFile(String filePath) throws ParserConfigurationException, SAXException {
        File file = new File(filePath);
        XMLReader reader = XMLReaderFactory.createXMLReader();

        reader.setContentHandler(new MyContentHandler());

        reader.parse(file);
    }

    private static class MyContentHandler extends AbstractSAXHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXParseException {
            System.out.println("Start Element: " + localName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXParseException {
            System.out.println("End Element: " + localName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXParseException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}