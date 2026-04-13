import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;

public class java_37833_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a new XMLReader instance
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Set a new handler to handle the content of the XML document
            reader.setContentHandler(new ContentHandlerImpl());

            // Parse the XML document
            parse(reader, "sample.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parse(XMLReader reader, String xmlFile) throws Exception {
        // Open the input file
        InputStream inStream = new FileInputStream(new File(xmlFile));

        // Set the input for the parser
        reader.setEntityResolver(new EntityResolverImpl());
        reader.parse(new InputStreamReader(inStream, "UTF-8"));
    }
}

class ContentHandlerImpl extends DefaultHandler {

    @Override
    public void startDocument() {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.println("Character data: " + new String(ch, start, length));
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length)
            throws SAXException {
        // Ignoring whitespace
    }

    @Override
    public void processingInstruction(String target, String data)
            throws SAXException {
        // Ignoring instructions
    }

    @Override
    public void setElementNamespace(String uri, String lname)
            throws SAXException {
        // Ignoring namespaces
    }

}

class EntityResolverImpl implements javax.xml.parsers.EntityResolver {

    @Override
    public InputStream resolveEntity(String arg0, String arg1, String arg2,
            String arg3, int arg4) throws SAXException, IOException {
        return null;
    }
}