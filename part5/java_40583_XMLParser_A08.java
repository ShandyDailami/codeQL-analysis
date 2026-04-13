import java.io.File;
import java.util.Iterator;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.FileReader;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_40583_XMLParser_A08 {

    public static void main(String[] args) {

        try {

            // Create a factory for the SAX parser
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

            // Create a SAX parser
            SAXParser saxParser = saxParserFactory.newSAXParser(new FileReader("example.xml"));

            // Create a handler
            ContentHandler contentHandler = new ContentHandler();

            // Parse the XML file
            saxParser.parse(new File("example.xml"), contentHandler);

            // Print the parsed content
            System.out.println("Parsed content: " + contentHandler.getContent());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ContentHandler class for handling parsed content
    static class ContentHandler extends DefaultHandler {

        private StringBuilder content;

        public java_40583_XMLParser_A08() {
            content = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            content.append(qName);
        }

        public String getContent() {
            return content.toString();
        }
    }
}