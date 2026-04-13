import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.event.EventListener;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

public class java_22853_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/books.xml";

        DefaultHandler handler = new DefaultHandler() {
            public void startDocument() {
                System.out.println("Start of document");
            }

            public void endDocument() {
                System.out.println("End of document");
            }

            public void startElement(String uri, String localName, String qName) {
                System.out.println("Start element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) {
                System.out.println("End element: " + qName);
            }

            public void characters(char[] ch, int start, int length) {
                String str = new String(ch, start, length);
                System.out.println("Characters: " + str);
            }

            public void fatalError(SAXParseException e) {
                System.out.println("Fatal error: " + e.getMessage());
            }

            public void warning(SAXParseException e) {
                System.out.println("Warning: " + e.getMessage());
            }
        };

        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.setErrorHandler(handler);

            EventListener eventListener = new EventListener() {
                public void startElement(String uri, String localName, String qName) {
                    System.out.println("Start element: " + qName);
                }

                public void endElement(String uri, String localName, String qName) {
                    System.out.println("End element: " + qName);
                }

                public void characters(char[] ch, int start, int length) {
                    String str = new String(ch, start, length);
                    System.out.println("Characters: " + str);
                }
            };
            reader.setContentHandler(eventListener);
            reader.setErrorHandler(eventListener);

            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}