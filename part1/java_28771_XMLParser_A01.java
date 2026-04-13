import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicSAXHandler;

public class java_28771_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "path_to_your_file.xml"; // replace with your actual XML file
        SAXParser(xmlFile);
    }

    private static void SAXParser(String xmlFile) {
        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            BasicSAXHandler handler = new BasicSAXHandler();
            xr.setContentHandler(handler);
            xr.parse(xmlFile);

            System.out.println("Parsed Successfully");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}