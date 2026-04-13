import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_03167_XMLParser_A01 {

    public static class MyHandler extends DefaultHandler {
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
            System.out.println("Start of Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String data = new String(ch, start, length).trim();
            if (data.length() > 0) {
                System.out.println("Data: " + data);
            }
        }

        @Override
        public void error(SAXException e) {
            System.err.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXException e) {
            System.err.println("Fatal Error: " + e.getMessage());
        }

        @Override
        public void warning(SAXWarning e) {
            System.err.println("Warning: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String xml = "<note>\n" +
                "  <to>Tove</to>\n" +
                "  <from>Jani</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Don't forget me this weekend!</body>\n" +
                "</note>";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new InputSource(new StringReader(xml)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}