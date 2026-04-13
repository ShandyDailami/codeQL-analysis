import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_28904_XMLParser_A03 {
    public static void main(String[] args) {
        String xml = "<bookstore>\n" +
                "  <book category=\"fiction\">\n" +
                "    <title>Harry Potter</title>\n" +
                "    <author>J K Rowling</author>\n" +
                "    <price>29.99</price>\n" +
                "  </book>\n" +
                "</bookstore>";
        parse(xml);
    }

    private static void parse(String xml) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new Handler());
            parser.parse(new InputSource(new StringReader(xml)), Handler.SAX_END_DOCUMENT);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static class Handler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String content = new String(ch, start, length);
            System.out.println("Content: " + content);
        }
    }
}