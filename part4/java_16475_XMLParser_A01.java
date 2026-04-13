import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_16475_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml"); // replace with your xml file path
        parseXmlFile(xmlFile);
    }

    public static void parseXmlFile(File xmlFile) {
        DefaultHandler handler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("Start Element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) {
                System.out.println("End Element: " + qName);
           .
            .
            .
            // handle other SAX events here
            .
            .
            .
            }

            public void characters(char[] ch, int start, int length) {
                String value = new String(ch, start, length);
                System.out.println("Character Data: " + value);
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}