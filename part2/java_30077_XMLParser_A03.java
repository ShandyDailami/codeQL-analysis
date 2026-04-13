import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.helpers.DefaultHandler;
import java.io.IOException;

public class java_30077_XMLParser_A03 extends DefaultHandler {

    public static void main(String[] args) {
        // Start with `java` and remove comments
        // TODO: Add code

        // TODO: Create instance of MyXMLParser
        // MyXMLParser xmlParser = new MyXMLParser();

        // TODO: Create instance of SAXParserFactory
        // SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        // TODO: Get XMLReader from saxParserFactory
        // XMLReader xmlReader = saxParserFactory.newSAXParser().getXMLReader();

        // TODO: Set entityResolver for xmlReader
        // xmlReader.setEntityResolver(new MyEntityResolver());

        // TODO: Set contentHandler for xmlReader
        // xmlReader.setContentHandler(xmlParser);

        // TODO: Parse your XML document
        // xmlReader.parse("your_xml_file.xml");
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.namespace.QName qNs, javax.xml.schema.QName schemaNs)
            throws SAXException {
        // TODO: Implement your logic here
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // TODO: Implement your logic here
   
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // TODO: Implement your logic here
    }

    // TODO: Add your own entityResolver class here
    private static class MyEntityResolver implements EntityResolver {
        public org.xml.sax.helpers.DefaultEntityResolver getDefaultEntityResolver() {
            return new org.xml.sax.helpers.DefaultEntityResolver() {
                public void fatalError(String message) throws SAXException {
                    // TODO: Handle fatal error
                }

                public void warning(String message) throws SAXException {
                    // TODO: Handle warning
                }

                public Object resolveEntity(String arg0) throws SAXException {
                    // TODO: Handle resolve entity
                    return null;
                }
            };
        }
    }
}