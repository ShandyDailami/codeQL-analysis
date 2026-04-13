import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_38896_XMLParser_A01 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File("sample.xml"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bValue = false;
        String name = "";
        String value = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("NAME")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("VALUE")) {
                bValue = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bName) {
                name = new String(ch, start, length);
                bName = false;
            } else if (bValue) {
                value = new String(ch, start, length);
                bValue = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equalsIgnoreCase("NAME")) {
                System.out.println("Name: " + name);
            } else if (qName.equalsIgnoreCase("VALUE")) {
                System.out.println("Value: " + value);
            }
        }
    }
}