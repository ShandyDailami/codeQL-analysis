import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.ext.LoomEntityResolver;
import java.io.File;
import java.io.IOException;

public class java_30740_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            parseFile("input.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseFile(String xmlFilePath) throws IOException, SAXException {
        File xmlFile = new File(xmlFilePath);
        EntityResolver entityResolver = new LoomEntityResolver();
        XMLReader reader = XMLReaderFactory.createXMLReader(entityResolver);

        DefaultHandler handler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {
                if (qName.equalsIgnoreCase("password")) {
                    System.out.println("Password found!");
                    // Remove password from output
                    System.out.println("Password has been removed!");
                } else {
                    System.out.println("Ignoring element: " + qName);
                }
            }
        };

        reader.setContentHandler(handler);
        reader.parse(xmlFile);
    }
}