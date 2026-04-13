import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class java_08269_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("path_to_your_xml_file.xml"));

            // Create a handler for SAX events
            MyHandler handler = new MyHandler();

            // Parse the XML file with SAX
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(null);
            sp.parse(new File("path_to_your_xml_file.xml"), handler);

            // Print out the elements and their values
            for (int i = 0; i < handler.elements.size(); i++) {
                System.out.println("Element " + (i + 1) + ": " + handler.elements.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Handler for SAX events
    static class MyHandler implements org.xml.sax.helpers.DefaultHandler {
        public List<String> elements = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            elements.add(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            elements.add(qName);
        }
    }
}