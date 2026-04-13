import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_14463_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file"; // replace this with your file path
        try {
            parseXML(xmlFilePath);
            System.out.println("File integrity is valid!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void parseXML(String xmlFilePath) throws IOException, SAXException {
        File xmlFile = new File(xmlFilePath);
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new DefaultHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAIXMLReader {
                System.out.println("Element: " + qName);
            }
        });
        reader.parse(xmlFile);
    }
}