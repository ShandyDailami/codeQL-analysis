import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_25561_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        parseFile(inputFile);
    }

    public static void parseFile(File inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document;

        try {
            document = builder.parse(inputFile);
            document.getDoctype(); // to check if document is a standalone or a doctype

            //Get root element
            Element rootElement = document.getDocumentElement();
            System.out.println("Root element: " + rootElement.getNodeName());

            NodeList nodeList = document.getElementsByTagName("*");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Node: " + node.getNodeName());
                if (node.hasAttributes()) {
                    NodeList attrList = node.getAttributes();
                    for (int j = 0; j < attrList.getLength(); j++) {
                        Node attr = attrList.item(j);
                        System.out.println("  Attribute: " + attr.getNodeName() + "='" + attr.getTextContent() + "'");
                   
                    }
                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}