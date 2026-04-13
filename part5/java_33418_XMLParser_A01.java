import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.FileResolver;
import org.xml.sax.enters.DefaultHandler;

public class java_33418_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create an instance of the XMLReaderFactory
            XMLReaderFactory xrf = XMLReaderFactory.newInstance();

            // Create an instance of the DefaultHandler
            DefaultHandler dh = new DefaultHandler();

            // Create an instance of the FileResolver
            FileResolver fr = new FileResolver("src/main/resources/example.xml");

            // Create an instance of the XMLReader
            XMLReader xr = xrf.createXMLReader(fr, dh);

            // Parse the XML document
            xr.parse("src/main/resources/example.xml");

            System.out.println("The XML document is valid.");

        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}