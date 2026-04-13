import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicErrorHandler;
import java.io.File;
import java.io.IOException;

public class java_40353_XMLParser_A07 {

    private class MyHandler extends BasicErrorHandler {
        public void fatalError(SAXException e) {
            System.out.println("Fatal error: " + e.getMessage());
        }

        public void warning(SAXWarning e) {
            System.out.println("Warning: " + e.getMessage());
        }
    }

    public void parse(String file) {
        File xmlFile = new File(file);

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse(xmlFile);
        } catch (IOException e) {
            System.out.println("Error reading XML file: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SAXParser parser = new SAXParser();
        parser.parse("example.xml");
    }
}