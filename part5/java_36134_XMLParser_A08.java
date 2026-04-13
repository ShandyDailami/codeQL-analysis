import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_36134_XMLParser_A08 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        File outputFile = new File("output.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;

        try {
            document = builder.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("node");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node instanceof Element) {
                Element element = (Element) node;

                String value = element.getAttribute("attr");

                if (value.equals("integrityFailure")) {
                    element.getParentNode().removeChild(element);
                }
            }
        }

        try {
            builder.save(document, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}