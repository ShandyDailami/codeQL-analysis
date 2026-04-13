import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_31640_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("path/to/your/xml/file.xml"));

            // Print the XML content
            printXmlContent(doc);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printXmlContent(Document doc) {
        // Print XML document node
        doc.getDocumentElement().normalize();
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        // Print element name and attribute
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("Element : " + nNode.getNodeName());
            if (nNode.getAttributes() != null) {
                for (int j = 0; j < nNode.getAttributes().getLength(); j++) {
                    System.out.println("Attribute: " + nNode.getAttributes().item(j).getNodeName() + " : " + nNode.getAttributes().item(j).getNodeValue());
                }
            }
            // Print text value
            if (nNode.getTextContent() != null) {
                System.out.println("Text value: " + nNode.getTextContent());
            }
        }
    }
}