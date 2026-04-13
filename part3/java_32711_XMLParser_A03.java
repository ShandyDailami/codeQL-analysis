import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

public class java_32711_XMLParser_A03 {

    public static void main(String[] args) {
        String xml = "<note>" +
                "<to>Tove</to>" +
                "<from>Jani</from>" +
                "<heading>Reminder</heading>" +
                "<body>Don't forget me this weekend!</body>" +
                "</note>";

        parseXML(xml);
    }

    private static void parseXML(String xml) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new BasicHandler() {
                @Override
                public void startElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("Start element: " + qName);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End element: " + qName);
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String content = new String(ch, start, length);
                    System.out.println("Content: " + content);
                }
            });

            reader.parse(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}