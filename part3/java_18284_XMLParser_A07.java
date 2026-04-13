import java.util.List;
import java.util.ArrayList;
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

public class java_18284_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            parseXmlFile("data.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXmlFile(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new XmlHandler());
        File xmlFile = new File(fileName);
        parser.parse(xmlFile, null);
    }

    private static class XmlHandler implements org.xml.sax.helpers.DefaultHandler {

        private List<String> tags = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            tags.add(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            tags.remove(qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String data = new String(ch, start, length).trim();
            if (!data.isEmpty()) {
                System.out.println("Tag: " + tags.get(tags.size() - 1) + ", Data: " + data);
            }
        }
    }
}