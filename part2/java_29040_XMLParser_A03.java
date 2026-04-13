import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class java_29040_XMLParser_A03 {

    public static void main(String[] args) {
        String fileName = "test.xml";
        parseFileUsingDom(fileName);
        parseFileUsingSax(fileName);
    }

    // SAX Parsing
    public static void parseFileUsingSax(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            XMLReader reader = factory.newSAXParser().getXMLReader();
            reader.setContentHandler(new ContentHandler());
            reader.parse(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DOM Parsing
    public static void parseFileUsingDom(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(fileName));
            doc.getDocumentElement().normalize();
            printElementNames(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementNames(Document doc) {
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element el = (Element) nodes.item(i);
            System.out.println("Element: " + el.getNodeName());
        }
    }

    static class ContentHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Element: " + qName);
        }
    }
}