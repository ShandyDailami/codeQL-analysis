import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_29021_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/xml/file.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler(xmlFile.getName()));

        try {
            parser.parse(Files.newInputStream(xmlFile.toPath()), null);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private String currentElement;

        public java_29021_XMLParser_A07(String currentElement) {
            this.currentElement = currentElement;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            this.currentElement = localName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            this.currentElement = null;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (currentElement != null) {
                System.out.println(currentElement + ": " + new String(ch, start, length));
            }
        }
    }
}