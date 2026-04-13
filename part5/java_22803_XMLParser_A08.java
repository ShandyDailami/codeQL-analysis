import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_22803_XMLParser_A08 {

    public static void main(String[] args) throws Exception {
        // SAX Parser
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        // SAX Handler
        MySAXHandler saxHandler = new MySAXHandler();

        // SAX Parser
        saxParser.parse(new File("sample.xml"), saxHandler);

        // Print names of all elements
        List<String> elements = saxHandler.getElements();
        for (String element : elements) {
            System.out.println(element);
        }
    }

    static class MySAXHandler implements SAXHandler {
        private List<String> elements;

        public java_22803_XMLParser_A08() {
            elements = new java.util.ArrayList<>();
        }

        @Override
        public void startElement(String uri, String localName, String qName,
                                javax.xml.parsers.Attributes attributes)
                throws javax.xml.parsers.SAXException {
            elements.add(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws javax.xml.parsers.SAXException {
        }

        public List<String> getElements() {
            return this.elements;
        }
    }

    // Document Builder
    public static Document getXMLDocument(String file) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File(file));
        return doc;
    }
}