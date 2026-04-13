import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_34517_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(true); // false -> should not validate the content

            MyHandler myHandler = new MyHandler();

            saxParser.parse(new File("sample.xml"), myHandler); // replace with your file

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private boolean bName;
        private boolean bAge;
        private String currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;

            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            } else {
                if (qName.equalsIgnoreCase("name")) {
                    bName = true;
                } else if (qName.equalsIgnoreCase("age")) {
                    bAge = true;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = null;

            if (qName.equalsIgnoreCase("person")) {
                bName = false;
                bAge = false;
            } else {
                if (qName.equalsIgnoreCase("name")) {
                    bName = false;
                } else if (qName.equalsIgnoreCase("age")) {
                    bAge = false;
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            }

            if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
            }
        }
    }
}