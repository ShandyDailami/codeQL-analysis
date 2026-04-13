import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_21448_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;
        try {
            doc = builder.parse(xmlFile);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
        System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
        ListNode listNode = new ListNode();
        extractData(doc, listNode);
    }

    private static void extractData(Document doc, ListNode listNode) {
        NodeList nodeList = doc.getElementsByTagName("node");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String nodeName = element.getAttribute("name");
            String nodeValue = element.getTextContent();
            listNode.addNode(nodeName, nodeValue);
        }
    }
}

class ListNode {
    ListNode next;
    String nodeName;
    String nodeValue;

    public void addNode(String nodeName, String nodeValue) {
        ListNode newNode = new ListNode();
        newNode.nodeName = nodeName;
        newNode.nodeValue = nodeValue;
        newNode.next = this;
    }
}