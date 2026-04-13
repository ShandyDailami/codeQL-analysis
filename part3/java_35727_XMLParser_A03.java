import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;
import java.io.File;
import java.io.IOException;

public class java_35727_XMLParser_A03 {
    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file.xml";
        parseXMLFile(filePath);
    }

    public static void parseXMLFile(String filePath) {
        File file = new File(filePath);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        XMLReader reader;

        try {
            reader = factory.newSAXParser(file).getXMLReader();
            reader.setContentHandler(new MyContentHandler());

            // Error handling not shown in this example
            reader.parse(file);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    static class MyContentHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            System.out.println("Character Data: " + new String(ch, start, length));
        }
    }
}