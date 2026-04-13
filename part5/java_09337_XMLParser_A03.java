import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_09337_XMLParser_A03 {

    private static class MyHandler extends DefaultHandler {

        @Override
        public void startDocument() {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName) {
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String data = new String(ch, start, length).trim();
            if (data.length() > 0) {
                System.out.println("Data: " + data);
            }
        }

        @Override
        public void warning(SAXException e) {
            System.out.println("Warning: " + e.getMessage());
        }

        @Override
        public void error(SAXException e) {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<root>" +
                "<element1>Data 1</element1>" +
                "<element2>Data 2</element2>" +
                "</root>";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
        saxParser.parse(new InputSource(new StringReader(xml)));
    }
}