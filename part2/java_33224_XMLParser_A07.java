import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class java_33224_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/data.xml");

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();

            Document document = builder.parse(inputStream);
            document.getDocumentElement().normalize();

            List<String> authFailures = getAuthFailures(document);

            // Print the list of auth failures
            for (String failure : authFailures) {
                System.out.println(failure);
            }

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> getAuthFailures(Document document) {
        List<String> authFailures = new ArrayList<>();

        NodeList nodeList = document.getElementsByTagName("authFailure");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String failure = element.getTextContent();
                authFailures.add(failure);
            }
        }

        return authFailures;
    }
}