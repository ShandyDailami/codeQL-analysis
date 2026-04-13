import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.XMLReader;

public class java_15204_XMLParser_A08 {
    public static void main(String[] args) throws IOException, SAXException {
        // Create an entity resolver to handle external entities
        EntityResolver resolver = new EntityResolver() {
            public Object getEntity(String arg0) {
                return null;
            }
        };

        // Create a default handler
        DefaultHandler handler = new DefaultHandler() {
            public void startDocument() throws SAXException {}
            public void endDocument() throws SAXException {}
            public void startElement(String arg0, String arg1, String arg2, String arg3) throws SAXException {
                System.out.println("Start tag: " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3);
            }
            public void endElement(String arg0, String arg1, String arg2) throws SAXException {
                System.out.println("End tag: " + arg0 + ", " + arg1 + ", " + arg2);
            }
            public void characters(char[] arg0, int arg1, int arg2) throws SAXException {
                System.out.println("Characters: " + new String(arg0, arg1, arg2));
            }
        };

        // Create a SAX reader
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setEntityResolver(resolver);
        reader.setContentHandler(handler);

        // Parse the XML file
        try {
            reader.parse(new File("example.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}