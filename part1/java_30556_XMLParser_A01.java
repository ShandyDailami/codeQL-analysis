import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_30556_XMLParser_A01 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("sample.xml")); // replace with your xml file path
            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("*");
            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                System.out.println("Element: " + element.getNodeName());
                System.out.println("Attributes: ");
                NodeList attributes = element.getAttributes();
                for (int j = 0; j < attributes.getLength(); j++) {
                    System.out.println("   Attribute: " + attributes.item(j).getNodeName() + " = " + attributes.item(j).getTextContent());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}