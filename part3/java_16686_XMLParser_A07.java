import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_16686_XMLParser_A07 {
    private static final String XML_FILE_PATH = "/path/to/your/file.xml";

    public static void main(String[] args) {
        XMLReader xmlReader = null;
        try {
            XMLReaderFactory.newInstance(); // Validate the factory
            xmlReader = XMLReaderFactory.newThreadSafeXMLReader();
            xmlReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            xmlReader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", false);
            xmlReader.setFeature("http://xml.org/sax/features/nonvalidating/load-dtd", false);
            xmlReader.setFeature("http://xml.org/sax/features/validation", false);
            xmlReader.setFeature("http://xml.org/sax/features/external-dtd", false);
            xmlReader.setFeature("http://xml.org/sax/features/nonvalidating/load-schema", false);
            xmlReader.setFeature("http://xml.org/sax/features/namespaces/default", false);
            xmlReader.setFeature("http://xml.org/sax/features/namespaces/lexical", false);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        DefaultHandler defaultHandler = new DefaultHandler() {
            public void startDocument() {
                System.out.println("Start of document");
            }

            public void endDocument() {
                System.out.println("End of document");
            }

            public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes atts) {
                System.out.println("Start of element: " + qualifiedName);
            }

            public void endElement(String namespaceURI, String localName, String qualifiedName) {
                System.out.println("End of element: " + qualifiedName);
            }

            public void characters(char[] ch, int start, int length) {
                String str = new String(ch, start, length);
                System.out.println("Character data: " + str);
            }

            public void fatalError(String error) {
                System.out.println("Fatal Error: " + error);
            }

            public void warning(String msg) {
                System.out.println("Warning: " + msg);
            }
        };

        try {
            xmlReader.setContentHandler(defaultHandler);
            xmlReader.parse(new File(XML_FILE_PATH));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}