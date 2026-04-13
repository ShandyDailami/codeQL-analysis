import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class java_20056_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getElementsByTagName("authFailure").item(0).getTextContent());
            printAuthFailureDetails(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printAuthFailureDetails(Document doc) {
        NodeList nodes = doc.getElementsByTagName("authFailure");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            Element element = (Element) node;
            System.out.println("AuthFailure : " + element.getAttribute("type"));
            System.out.println("AuthFailure : " + element.getAttribute("message"));
        }
    }
}