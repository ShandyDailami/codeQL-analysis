import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

public class java_07110_XMLParser_A08 {
    public static void main(String[] args) {
        String xml = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend.</body>\n" +
                "</note>";

        parse(xml);
    }

    private static void parse(String xml) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            BasicHandler handler = new BasicHandler() {
                public void endElement(String namespaceURI, String localName, String qualifiedName)
                        throws SAXException {
                    // Security-sensitive operation:
                    if (localName.equals("note")) {
                        System.out.println("A note was read.");
                    }
                }
            };
            reader.setContentHandler(handler);
            reader.parse(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}