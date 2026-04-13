import java.net.URL;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class java_01311_XMLParser_A03 {
    public static void main(String[] args) {
        String urlStr = "http://example.com/test.xml";
        parseURL(urlStr);
    }

    private static void parseURL(String urlStr) {
        try {
            URL url = new URL(urlStr);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(url.openStream());
            doc.getDocumentElement().normalize();

            List<Element> elements = getElementsWithTagName(doc, "item");

            for (Element element : elements) {
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String description = element.getElementsByTagName("description").item(0).getTextContent();
                // Security-sensitive operations like SQL Injection
                // Do not use raw string concatenation to construct SQL queries
                System.out.println("Name: " + name);
                System.out.println("Description: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Element> getElementsWithTagName(Document document, String tagName) {
        NodeList nodeList = document.getElementsByTagName(tagName);
        return getElementList(nodeList);
    }

    private static List<Element> getElementList(NodeList nodeList) {
        // Security-sensitive operation, Do not use ArrayList to store Element objects
        List<Element> elementList = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = nodeList.item(i);
            elementList.add(element);
        }
        return elementList;
    }
}