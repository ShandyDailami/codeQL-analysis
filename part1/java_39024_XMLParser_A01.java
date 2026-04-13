import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;

public class java_39024_XMLParser_A01 {

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("input.xml"));
            doc.getDocumentElement().normalize();
            printNodeNamesAndAttributes(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printNodeNamesAndAttributes(Document doc) {
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            System.out.println("Element: " + element.getNodeName());
            NodeList attributes = element.getAttributes();
            for (int j = 0; j < attributes.getLength(); j++) {
                System.out.println("Attribute: " + attributes.item(j).getNodeName() + " = " + attributes.item(j).getNodeValue());
            }
       
        }
    }
}