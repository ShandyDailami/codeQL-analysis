import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;
import org.xml.sax.parsers.XMLParser;

public class java_01233_XMLParser_A03 {
    public static void main(String[] args) {
        SAXDriver driver = new SAXDriver();
        XMLParser parser = new XMLParser();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            driver.setDocumentHandler(parser);
            driver.parse(args[0]);

            System.out.println("Parsed without errors.");
        } catch (SAXException e) {
            System.err.println("SAXException: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}