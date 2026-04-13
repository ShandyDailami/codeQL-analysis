import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_27306_XMLParser_A08 {

    public static void parseXml(String filePath) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAge = false;
        boolean bCountry = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("person")) {
                return;
            }

            if (qName.equals("name")) {
                bName = true;
            } else if (qName.equals("age")) {
                bAge = true;
            } else if (qName.equals("country")) {
                bCountry = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("person")) {
                return;
            }

            if (bName) {
                bName = false;
                System.out.println("Name: ");
            } else if (bAge) {
                bAge = false;
                System.out.println("Age: ");
            } else if (bCountry) {
                bCountry = false;
                System.out.println("Country: ");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println(new String(ch, start, length));
                bName = false;
            } else if (bAge) {
                System.out.println(new String(ch, start, length));
                bAge = false;
            } else if (bCountry) {
                System.out.println(new String(ch, start, length));
                bCountry = false;
            }
        }
    }
}