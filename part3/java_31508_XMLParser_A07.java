import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_31508_XMLParser_A07 {

    public static class MyHandler extends DefaultHandler {

        public void startDocument() {
            System.out.println("Start of document");
        }

        public void endDocument() {
            System.out.println("End of document");
        }

        public void startElement(String uri, String localName, String qName) {
            System.out.println("Start of element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element: " + qName);
        }

        public void characters(char[] ch, int start, int length) {
            String contents = new String(ch, start, length).trim();
            if (contents.length() > 0) {
                System.out.println("Character contents: " + contents);
            }
        }

        public void fatalError(String error) {
            System.out.println("Fatal error: " + error);
        }

        public void warning(String warning) {
            System.out.println("Warning: " + warning);
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(XMLReader.class.getClassLoader().getResourceAsStream("example.xml"));
            MyHandler handler = new MyHandler();
            parser.parse(new InputSource(new StringReader("")), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}