import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_41400_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();

            // Set the default handler
            parser.setContentHandler(new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    // Handle start elements
                    System.out.println("Start Element: " + qName);
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    // Handle end elements
                    System.out.println("End Element: " + qName);
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    // Handle character data
                    String data = new String(ch, start, length);
                    System.out.println("Character Data: " + data);
                }
            });

            // Parse the XML file
            parser.parse(new File("path_to_your_xml_file.xml"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}