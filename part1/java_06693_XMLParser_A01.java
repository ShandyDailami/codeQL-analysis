import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;
import java.io.File;
import java.io.IOException;

public class java_06693_XMLParser_A01 {

    public static void main(String[] args) {
        String url = "path_to_your_xml_file.xml";
        File xmlFile = new File(url);

        // Create a new instance of the XMLLoader class
        XMLLoader loader = new XMLLoader();

        try {
            // Create a new instance of the SAXParserFactory class
            XMLParser saxParser = loader.getParser(xmlFile, null);

            // Create a new instance of the SAXParser class
            saxParser.setFeature("http://xml.org/sax/features/external-parametrization", false);
            saxParser.setFeature("http://xml.org/sax/features/namespaces", false);
            saxParser.setFeature("http://xml.org/sax/features/validation", false);
            saxParser.setFeature("http://xml.org/sax/features/chars-and-attributes", false);

            // Set the content handler
            MyHandler handler = new MyHandler();
            saxParser.setContentHandler(handler);

            // Parse the XML
            saxParser.parse(new File(url));

        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (SAXException e2) {
            e2.printStackTrace();
        }
    }

    // Define a content handler to handle the parsed XML
    static class MyHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}