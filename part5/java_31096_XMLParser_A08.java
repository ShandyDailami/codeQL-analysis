import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_31096_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml"); // replace with your xml file path
        parseXmlFile(xmlFile);
    }

    private static void parseXmlFile(File xmlFile) {
        DefaultHandler handler = new DefaultHandler() {
            public void startDocument() {
                System.out.println("Start of document");
            }

            public void endDocument() {
                System.out.println("End of document");
            }

            public void startElement(String uri, String localName, String qName) {
                System.out.println("Start of element " + localName);
            }

            public void endElement(String uri, String localName, String qName) {
                System.out.println("End of element " + localName);
            }

            public void characters(char[] ch, int start, int length) {
                String content = new String(ch, start, length);
                System.out.println("Character content: " + content);
            }

            public void fatalError(String error) throws SAXException {
                throw new SAXException(error);
            }
        };

        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader(new SAXSource(handler));
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            reader.setFeature("http://xml.org/sax/features/validation", false);
            reader.setFeature("http://xml.org/sax/features/external-general-entity-ref", false);
            reader.setFeature("http://xml.org/sax/features/external-parameter-entity-ref", false);
            reader.setFeature("http://xml.org/sax/features/rng-supported", false);
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}