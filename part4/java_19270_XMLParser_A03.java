import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_19270_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a new XMLReader
            XMLReader xr = XMLReaderFactory.createXMLReader();

            // Set up a handler to print out any errors or warnings
            xr.setContentHandler(new DefaultHandler() {
                @Override
                public void error(SAXException e) {
                    System.out.println("Error: " + e.getMessage());
                }

                @Override
                public void warning(SAXWarning e) {
                    System.out.println("Warning: " + e.getMessage());
                }
            });

            // Set up a custom entity resolver
            xr.setEntityResolver(new EntityResolver() {
                public Result SetEntityResolver(String arg0) {
                    return new SAXResult(xr);
                }
            });

            // Parse the XML file
            xr.parse(new File("example.xml"));
        } catch (IOException e) {
            System.out.println("Error reading XML file: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }
}