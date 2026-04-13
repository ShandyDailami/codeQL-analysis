import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_20657_XMLParser_A07 {
    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<root>\n" +
                "    <element1>value1</element1>\n" +
                "    <element2>value2</element2>\n" +
                "    <element3>value3</element3>\n" +
                "</root>";
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(new InputSource(new StringReader(xml)));
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new InputSource(new StringReader(xml)), myHandler);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Security sensitive operation
            // This is a placeholder operation, you should replace it with your own security sensitive operation
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Security sensitive operation
            // This is a placeholder operation, you should replace it with your own security sensitive operation
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Security sensitive operation
            // This is a placeholder operation, you should replace it with your own security sensitive operation
            String value = new String(ch, start, length);
            System.out.println("Characters: " + value);
        }
    }
}