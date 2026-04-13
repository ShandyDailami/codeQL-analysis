import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_42054_XMLParser_A03 {

    private String xmlContent;

    public java_42054_XMLParser_A03(String xmlContent) {
        this.xmlContent = xmlContent;
    }

    public void parseXml() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(new InputSource(new StringReader(xmlContent)));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        // Security-sensitive operation: accessing XML elements
        NodeList nodeList = doc.getElementsByTagName("node");

        // Security-sensitive operation: iterating over XML elements
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("Node " + (i+1) + " content: " + node.getTextContent());
        }
    }
}