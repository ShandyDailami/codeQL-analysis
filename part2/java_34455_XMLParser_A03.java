import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_34455_XMLParser_A03 {

    // Create a custom handler that prints out all element names
    public static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End element: " + qName);
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());

            String xml = "<note>" +
                    "<to>Tove</to>" +
                    "<from>Jani</from>" +
                    "<heading>Reminder</heading>" +
                    "<body>Don't forget me this weekend!</body>" +
                    "</note>";

            saxParser.parse(new InputSource(new StringReader(xml)));

        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}