import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_28608_XMLParser_A07 {
    public static void main(String[] args) {
        XMLReader reader = SAXParser.newInstance().getSAXParser();
        reader.setContentHandler(new MyHandler());
        try {
            reader.parse("src/main/resources/A07_AuthFailure.xml", new DefaultHandler());
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length);
            System.out.println("Content: " + content);
        }
    }
}