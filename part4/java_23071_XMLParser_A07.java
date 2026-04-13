import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.helpers.DefaultHandler;

public class java_23071_XMLParser_A07 extends DefaultHandler {
    public static void main(String[] args) {
        String xml = "<root><item>Item 1</item><item>Item 2</item></root>";

        // Disable warning about using insecure entity.
        EntityResolver resolver = new EntityResolver() {
            public InputSource resolveEntity(String arg0) throws SAXException {
                return new InputSource(new StringReader(""));
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader(resolver);
            MyXMLParser handler = new MyXMLParser();
            reader.setContentHandler(handler);
            reader.parse(new InputSource(new StringReader(xml)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document");
    }

    @Override
    public void startElement(String arg0, String arg1, String arg2, String arg3) throws SAXException {
        System.out.println("Start element: " + arg1);
    }

    @Override
    public void endElement(String arg0, String arg1, String arg2) throws SAXException {
        System.out.println("End element: " + arg1);
    }

    @Override
    public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
        System.out.println("Characters: " + new String(arg0, arg1, arg2));
    }
}