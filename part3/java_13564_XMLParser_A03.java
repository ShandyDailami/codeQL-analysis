import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.net.URL;
import java.util.Scanner;

public class java_13564_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com/sample.xml"); // Replace with the URL of your XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(url.openStream());

            doc.getDocumentElement().normalize();
            NodeList nodes = doc.getElementsByTagName("node");

            for (int i = 0; i < nodes.getLength(); i++) {
                Element nodeElement = (Element) nodes.item(i);
                String nodeValue = nodeElement.getTextContent();
                System.out.println("Node " + (i + 1) + ": " + nodeValue);
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}