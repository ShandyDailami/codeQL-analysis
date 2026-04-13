import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_12954_XMLParser_A07 {

    public static void main(String[] args) {
        // Create an instance of the DefaultHandler
        DefaultHandler handler = new DefaultHandler() {
            public void startDocument() {
                System.out.println("Starting XML document");
            }

            public void endDocument() {
                System.out.println("Ending XML document");
            }

            public void startElement(String uri, String localName, String qName) {
                System.out.println("Starting element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) {
                System.out.println("Ending element: " + qName);
            }

            public void characters(char[] ch, int start, int length) {
                String content = new String(ch, start, length);
                System.out.println("Content: " + content);
            }
        };

        // Parse the XML file
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(XmlParser.class.getResourceAsStream("/authfailure.xml"), handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}