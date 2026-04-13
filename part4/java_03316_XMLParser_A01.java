import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_03316_XMLParser_A01 {

    public static class MyHandler extends DefaultHandler {

        private boolean isPerson = false;
        private boolean isName = false;
        private boolean isAge = false;
        private String currentElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            if (qName.equalsIgnoreCase("person")) {
                isPerson = true;
            } else if (qName.equalsIgnoreCase("name")) {
                isName = true;
            } else if (qName.equalsIgnoreCase("age")) {
                isAge = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isPerson) {
                System.out.println("Person: " + new String(ch, start, length));
                isPerson = false;
            } else if (isName) {
                System.out.println("Name: " + new String(ch, start, length));
                isName = false;
            } else if (isAge) {
                System.out.println("Age: " + new String(ch, start, length));
                isAge = false;
            }
        }

    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        parser.parse(MyXMLParser.class.getResourceAsStream("/test.xml"), handler);
    }

}