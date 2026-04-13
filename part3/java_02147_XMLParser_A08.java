import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLErrorHandler;
import org.xml.sax.parser.XMLParser;
import java.io.File;
import java.io.IOException;

public class java_02147_XMLParser_A08 {

    public static void main(String[] args) {
        String fileName = "resources/sample.xml";

        // Create a new parser with a default error handler.
        XMLParser parser = XMLParser.newInstance(new DefaultHandler(), true);
        SAXErrorHandler errorHandler = new DefaultHandler();

        // Open a new parser for a file.
        try {
            parser.parse(new File(fileName), errorHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // A default handler for SAX.
    private static class DefaultHandler extends org.xml.sax.helpers.DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}