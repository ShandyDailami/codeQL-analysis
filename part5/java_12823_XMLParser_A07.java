import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class java_12823_XMLParser_A07 {
    public static void main(String[] args) {
        DefaultHandler handler = new DefaultHandler() {
            boolean bOpenedElement = false;

            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                bOpenedElement = true;
                System.out.println("Start of element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) {
                bOpenedElement = false;
                System.out.println("End of element: " + qName);
            }

            public void characters(char[] ch, int start, int length) {
                if (bOpenedElement) {
                    System.out.println("Text: " + new String(ch, start, length));
                }
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse("src/main/resources/example.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}