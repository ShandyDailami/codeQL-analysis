import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class java_41079_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/main/resources/example.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            printElement("Books", document);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(String elementName, Document document) {
        NodeList nodeList = document.getElementsByTagName(elementName);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String bookName = element.getElementsByTagName("bookName").item(0).getTextContent();
                String authorName = element.getElementsByTagName("authorName").item(0).getTextContent();
                String bookPrice = element.getElementsByTagName("bookPrice").item(0).getTextContent();

                System.out.println("Book Name: " + bookName);
                System.out.println("Author Name: " + authorName);
                System.out.println("Book Price: " + bookPrice);
            }
        }
    }
}