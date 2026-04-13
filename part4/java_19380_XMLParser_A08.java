import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_19380_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "sample.xml"; // Path to your xml file
        parse(xmlFile);
    }

    private static void parse(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try (InputStream stream = new FileInputStream(new File(xmlFile))) {
            Document document = builder.parse(stream);

            List<String> elements = new ArrayList<>();
            getAllElements("", document.getDocumentElement(), elements);

            // Print elements
            for (String element : elements) {
                System.out.println(element);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getAllElements(String prefix, Element element, List<String> elements) {
        String name = element.getNodeName();
        if (!prefix.isEmpty()) {
            prefix += ".";
        }
        elements.add(prefix + name);

        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) node;
                getAllElements(prefix + name, childElement, elements);
            }
        }
    }
}