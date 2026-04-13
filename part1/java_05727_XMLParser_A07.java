import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.ElementListener;
import java.io.File;
import java.io.IOException;

public class java_05727_XMLParser_A07 {
    public static void main(String[] args) {
        String fileName = "sample.xml";

        // Create an instance of the handler
        DefaultHandler handler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName,
                    Attributes attributes) throws SAXException {
                System.out.println("Start Element: " + qName);
            }

            public void endElement(String uri, String localName, String qName)
                    throws SAXException {
                System.out.println("End Element: " + qName);
            }

            public void characters(char[] ch, int start, int length)
                    throws SAXException {
                if (length > 0) {
                    System.out.println("Character Data: " + new String(ch, start, length));
                }
            }
        };

        // Create an instance of the SAX parser
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        // Parse the XML file
        try {
            reader.parse(new File(fileName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}