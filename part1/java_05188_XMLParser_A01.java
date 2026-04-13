import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_05188_XMLParser_A01 {

    public static void main(String[] args) {
        String url = "example.xml"; // replace with your xml file
        parse(url);
    }

    public static void parse(String url) {
        File file = new File(url);
        XMLReader reader;
        DefaultHandler handler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
                System.out.println("Start element: " + qName);
            }
            public void endElement(String uri, String localName, String qName)
                throws SAXException {
                System.out.println("End element: " + qName);
            }
            public void characters(char[] ch, int start, int length)
                throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}