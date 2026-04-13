import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;
import java.io.IOException;
import java.io.File;

public class java_10616_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXReader reader = new SAXReader();
            File xmlFile = new File("sample.xml"); // path to your XML file
            XMLReader xmlReader = reader.getReader();

            // Create a default handler to handle the start and end elements
            xmlReader.setContentHandler(new DefaultHandler() {
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start element: " + qName);
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End element: " + qName);
                }
            });

            // Parse the XML file
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}