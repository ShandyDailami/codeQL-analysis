import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.handlers.DefaultHandler;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.entities.StringList;

import java.io.File;
import java.io.IOException;

public class java_22822_XMLParser_A01 {
    private DefaultHandler defaultHandler;

    public java_22822_XMLParser_A01() {
        defaultHandler = new DefaultHandler() {
            @Override
            public void warning(SAXException e) {
                System.out.println("Warning: " + e.getMessage());
            }

            @Override
            public void error(SAXException e) {
                System.out.println("Error: " + e.getMessage());
            }

            @Override
            public void fatalError(SAXException e) {
                System.out.println("Fatal Error: " + e.getMessage());
            }
        };
    }

    public void parse(String filePath) throws IOException, SAXException {
        File xmlFile = new File(filePath);
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(defaultHandler);
        reader.setEntityResolver(new EntityResolver() {
            @Override
            public void resolveEntity(String name, String publicId, String systemId) throws SAXException, IOException {
                // This is a simple entity resolver that replaces any unsupported entities with a default handler message.
                // In a real application, you would want to handle entities differently, such as by loading the entity from a resource or a database.
                if (name != null && !name.isEmpty() && publicId != null && !publicId.isEmpty() && systemId != null && !systemId.isEmpty()) {
                    defaultHandler.warning(new SAXException("Unsupported Entity: " + name + " (" + publicId + ", " + systemId + ")"));
                }
            }
        });
        reader.parse(xmlFile);
    }

    public static void main(String[] args) throws IOException, SAXException {
        new BrokenAccessControlXMLParser().parse("broken_access_control.xml");
    }
}