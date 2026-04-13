import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;

public class java_05617_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            String elementName = "elementName"; // replace with the name of the element you want to extract
            String result = extractElementValue(doc, elementName);
            System.out.println("Value of element: " + result);

            writeToFile(result, "output.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String extractElementValue(Document doc, String elementName) {
        NodeList nodes = doc.getElementsByTagName(elementName);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                return element.getTextContent();
            }
        }
        return null;
    }

    private static void writeToFile(String content, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(content);
            writer.close();
            System.out.println("Content has been written to file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}