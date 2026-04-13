import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_34848_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml"); // replace with your xml file path

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("sensitiveData");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Sensitive data found: " + node.getTextContent());
            }

            System.out.println("Parsing completed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}