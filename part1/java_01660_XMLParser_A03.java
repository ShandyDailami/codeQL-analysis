import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_01660_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/example.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        MyHandler myHandler = new MyHandler();
        saxParser.parse(new File(xmlFile), myHandler);
    }

    static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;
        boolean bCountry = false;

        String name;
        String age;
        String country;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            if (qName.equalsIgnoreCase("person")) {
                return;
            }

            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("age")) {
                bAge = true;
            } else if (qName.equalsIgnoreCase("country")) {
                bCountry = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Name: " + name + ", Age: " + age + ", Country: " + country);
                return;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {

            if (bName) {
                name = new String(ch, start, length);
                bName = false;
            } else if (bAge) {
                age = new String(ch, start, length);
                bAge = false;
            } else if (bCountry) {
                country = new String(ch, start, length);
                bCountry = false;
            }
        }
    }
}