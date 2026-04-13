import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_09694_XMLParser_A03 extends DefaultHandler {
    List<String> nodes = new ArrayList<>();
    StringBuilder currentNode = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentNode.setLength(0);
        currentNode.append(qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            currentNode.append(" ").append(attributes.getQName(i)).append("=\"").append(attributes.getValue(i)).append("\"");
        }
        nodes.add(currentNode.toString());
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentNode.setLength(0);
        currentNode.append(qName);
        nodes.add(currentNode.toString());
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentNode.append(new String(ch, start, length));
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        javax.xml.parsers.SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            saxParser.parse(new InputSource(new StringReader("<root><a><b>123</b></a><a>456</a></root>")), parser);
            for (String node : parser.nodes) {
                System.out.println(node);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}