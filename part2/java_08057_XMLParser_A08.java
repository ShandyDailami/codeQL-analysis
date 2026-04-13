import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_08057_XMLParser_A08 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("src/main/resources/myFile.xml"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean bName;
        private boolean bAge;

        @Override
        public void startDocument() throws SAXException {
            bName = false;
            bAge = false;
        }

        @Override
        public void startElement(String uri, String localName, String version) throws SAXException {
            if (localName.equals("person")) {
                bName = true;
                bAge = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                // Do some security-sensitive operations related to A08_IntegrityFailure here
                // e.g., print the name
                System.out.println(new String(ch, start, length));
            } else if (bAge) {
                // Do some security-sensitive operations related to A08_IntegrityFailure here
                // e.g., print the age
                System.out.println(new String(ch, start, length));
            }
        }

        @Override
        public void endElement(String uri, String localName, String version) throws SAXException {
            if (localName.equals("person")) {
                bName = false;
                bAge = false;
            }
        }

        @Override
        public void endDocument() throws SAXException {
        }
    }
}