import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class java_01537_XMLParser_A03 extends DefaultHandler {
    private List<String> nodeList = new ArrayList<>();

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parse("test.xml");
    }

    public void parse(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(fileName));
            document.getDomConfig().setNamespaceAware(true);
            document.getDomConfig().setValidating(false);
            document.getDomConfig().setSanitize(false);

            document.getElementsByTagName("*").item(0).getNodeName();
            processNode(document.getElementsByTagName("*"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Dictionary attributes) {
        super.startElement(uri, localName, qName, attributes);
        nodeList.add(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        super.endElement(uri, localName, qName);
        nodeList.add(qName);
    }

    public void processNode(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            processNode(nodeList.item(i));
        }
    }

    public void processNode(org.w3c.dom.Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println("Element: " + node.getNodeName());
            if (node.hasAttributes()) {
                System.out.print("Attributes: ");
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.println(attributes.item(i).getNodeName() + " = " + attributes.item(i).getTextContent());
                }
            }
        }
    }
}