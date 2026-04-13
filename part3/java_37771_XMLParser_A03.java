import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.DefaultHandler;

public class java_37771_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create a SAX parser using the default handler
            XMLReader reader = XMLReaderFactory.createXMLReader();
            DefaultHandler handler = new DefaultHandler();
            reader.setContentHandler(handler);

            // Parse the XML file
            String xmlFile = "sample.xml";
            InputStream inStream = new FileInputStream(xmlFile);
            InputStreamReader inReader = new InputStreamReader(inStream, "UTF-8");
            reader.parse(inReader);

            // Print the parsed data
            System.out.println("Parsed data:");
            System.out.println("Name: " + handler.getName());
            System.out.println("Age: " + handler.getAge());
            System.out.println("Country: " + handler.getCountry());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}