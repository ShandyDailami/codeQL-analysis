import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_14942_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";
        parseXml(xmlFile);
    }

    private static void parseXml(String xmlFile) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(xmlFile, myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        boolean isElement = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            isElement = true;
            System.out.println("Start Element : " + qName);
            printAttributes(attributes);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            isElement = false;
            System.out.println("End Element : " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isElement) {
                System.out.println("Character Data : " + new String(ch, start, length));
            }
        }

        private void printAttributes(Attributes attributes) {
            if (attributes != null) {
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.println("Attribute : " + attributes.getQName(i) + " = " + attributes.getValue(i));
                }
            }
        }
    }
}