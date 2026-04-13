import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.LinkedList;
import java.util.List;

public class java_37622_XMLParser_A08 extends DefaultHandler {

    private List<String> nodes = new LinkedList<>();
    private String currentNode;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentNode = qName;
        nodes.add(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentNode = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentNode != null && currentNode.equals(localName)) {
            String nodeContent = new String(ch, start, length);
            nodes.add(nodeContent.trim());
        }
    }

    public List<String> getNodes() {
        return nodes;
    }
}