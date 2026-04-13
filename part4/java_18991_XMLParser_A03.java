import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_18991_XMLParser_A03 {

    public static void main(String[] args) throws Exception {
        // Using SAX Parser
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        // Using Document Builder
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        // Parsing XML file using SAX
        System.out.println("Parsing XML file using SAX:");
        saxParser.parse(new File("sample.xml"), new MyHandler());

        // Parsing XML file using DOM
        System.out.println("\nParsing XML file using DOM:");
        Document document = documentBuilder.parse(new File("sample.xml"));
        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            System.out.println(element.getTagName());
        }
    }

    // SAX Handler
    static class MyHandler implements javax.xml.parsers.SAXHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                javax.xml.parsers.Attributes attributes) throws javax.xml.parsers.SAXException {
            System.out.println(qName);
        }
    }
}