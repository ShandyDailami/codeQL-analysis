import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_39296_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/example.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null, new XmlHandler());
            saxParser.parse(xmlFile, true);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class XmlHandler extends DefaultHandler {

        private boolean isName = false;
        private boolean isValue = false;
        private String currentValue = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                isName = true;
            } else if (qName.equalsIgnoreCase("value")) {
                isValue = true;
            }
        }

        @Override
        public void characters(char[] chars, int start, int length) throws SAXException {
            if (isName) {
                isName = false;
                String name = new String(chars, start, length);
                System.out.println("Name: " + name);
            } else if (isValue) {
                isValue = false;
                currentValue = new String(chars, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                isName = false;
            } else if (qName.equalsIgnoreCase("value")) {
                isValue = false;
                System.out.println("Value: " + currentValue);
            }
        }
    }
}