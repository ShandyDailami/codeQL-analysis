import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_23819_XMLParser_A08 {
    private static final Logger logger = Logger.getLogger(XMLParser.class.getName());

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");

        if (!xmlFile.exists()) {
            logger.severe("XML file not found!");
            return;
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("*");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Element name: " + element.getTagName());
                    System.out.println("Element value: " + element.getFirstChild().getNodeValue());
                }
            }
        } catch (IOException e) {
            logger.severe("Error parsing XML file!");
            e.printStackTrace();
        }
    }
}