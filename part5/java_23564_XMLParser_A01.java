import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_23564_XMLParser_A01 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(new File("sample.xml"));
            document.getDoctype();
            NodeList nodeList = document.getElementsByTagName("*");

            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Node " + (i + 1) + ": " + nodeList.item(i).getNodeName());
                if (nodeList.item(i).hasAttributes()) {
                    NodeList attributes = nodeList.item(i).getAttributes();
                    for (int j = 0; j < attributes.getLength(); j++) {
                        System.out.println("  Attribute " + (j + 1) + ": " + attributes.item(j).getNodeName() + "=" + attributes.item(j).getTextContent());
                    }
                } else {
                    System.out.println("  No attributes");
                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}