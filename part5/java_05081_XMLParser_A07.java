import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_05081_XMLParser_A07 {

    public static void parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(new InputSource(new File(fileName)));
            MyHandler handler = new MyHandler();
            parser.parse(fileName, handler);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static class MyHandler extends DefaultHandler {

        private boolean isAuthFailure = false;
        private String currentElement = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;

            if (currentElement.equals("AuthFailure")) {
                isAuthFailure = true;
            }
        }

        @Override
        public java_05081_XMLParser_A07(String uri, String localName, String qName) throws SAXException {
            currentElement = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (currentElement != null && isAuthFailure) {
                String data = new String(ch, start, length);
                System.out.println("Security-sensitive operation related to AuthFailure: " + data);
                isAuthFailure = false;
            }
        }
    }

    public static void main(String[] args) {
        parse("input.xml");
    }
}