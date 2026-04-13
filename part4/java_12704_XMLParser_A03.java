import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.helpers.DefaultHandler;

public class java_12704_XMLParser_A03 {
    private static final String SYSTEM_ID = "system";
    private static final String XINCLUSIVE = "inclusive";
    private static final String NAMESPACES_ENABLED = "true";

    public static void main(String[] args) {
        EntityResolver resolver = new EntityResolver() {
            public Object getEntity(String systemId) throws SAXException {
                // In this case, we are not using entities, so return null
                return null;
            }
        };

        DefaultHandler handler = new DefaultHandler() {
            public void startDocument() throws SAXException {
                System.out.println("Start of document");
            }

            public void endDocument() throws SAXException {
                System.out.println("End of document");
            }

            public void startElement(String uri, String localName, String qName,
                    org.xml.sax.Attributes attributes) throws SAXException {
                System.out.println("Start of element: " + localName);
            }

            public void endElement(String uri, String localName, String qName)
                    throws SAXException {
                System.out.println("End of element: " + localName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                String content = new String(ch, start, length);
                System.out.println("Content: " + content);
            }
        };

        XMLReaderFactory factory = XMLReaderFactory.newInstance();
        factory.setValidating(true);
        factory.setEntityResolver(resolver);

        try {
            XMLReader reader = factory.createXMLReader();
            reader.setContentHandler(handler);
            reader.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd", false);
            reader.setFeature("http://xml.apache.org/xml-features/namespaces/allowed", NAMESPACES_ENABLED);
            reader.setFeature("http://xml.apache.org/xml-features/namespaces/prefix-prefix", SYSTEM_ID);
            reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            reader.setFeature("http://xml.apache.org/xml-features/namespaces/it's-XInclusive", XINCLUSIVE);
            reader.setFeature("http://xml.apache.org/xml-features/namespaces/it's-XMLSchema", XINCLUSIVE);
            reader.parse("test.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}