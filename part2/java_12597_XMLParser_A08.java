import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_12597_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

            printElementList(doc.getChildNodes());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementList(List<org.w3c.dom.Node> nodeList) {
        for (int i = 0; i < nodeList.size(); i++) {
            org.w3c.dom.Node node = nodeList.get(i);

            if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                System.out.println("Element : " + element.getTagName() + " - " + element.getTextContent());

                List<org.w3c.dom.Node> childNodes = element.getChildNodes();
                printElementList(childNodes);
            }
        }
    }
}