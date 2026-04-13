import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_00047_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            NodeList nodes = doc.getElementsByTagName("student");

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                System.out.println("Student " + (i + 1) + ":");

                NodeList attributes = node.getAttributes();
                for (int j = 0; j < attributes.getLength(); j++) {
                    System.out.println("  Attribute " + (j + 1) + ": " + attributes.item(j).getTextContent());
                }

                NodeList children = node.getChildNodes();
                for (int k = 0; k < children.getLength(); k++) {
                    System.out.println("  Child " + (k + 1) + ": " + children.item(k).getTextContent());
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}