import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_39635_XMLParser_A03 {

    public static void main(String[] args) {
        // Parse XML file using SAX
        parseXMLFileSAX("example.xml");

        // Parse XML file using DOM
        parseXMLFileDOM("example.xml");
    }

    private static void parseXMLFileSAX(String fileName) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(new File(fileName), saxHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXMLFileDOM(String fileName) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File(fileName));
            document.getDocumentElement().normalize();
            printNode(document.getDocumentElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class SAXHandler extends DefaultHandler {
        private boolean tagFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            tagFound = true;
            System.out.println("Start of " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of " + qName);
            tagFound = false;
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            if (tagFound) {
                System.out.println(new String(ch, start, length));
            }
        }
    }
}