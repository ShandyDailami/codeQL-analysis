import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_04008_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFilePath = "resources/sample.xml"; // replace with your actual XML file path
        parseXMLFile(xmlFilePath);
    }

    private static void parseXMLFile(String xmlFilePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true); // enable validation
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(new File(xmlFilePath));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        doc.getDocumentElement().normalize();
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("student");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nStudent " + (temp + 1));
            System.out.println("----------------------------");

            Element e = (Element) nNode;
            System.out.println("ID: " + e.getAttribute("id"));
            System.out.println("Name: " + e.getAttribute("name"));
            System.out.println("Age: " + e.getAttribute("age"));
        }
    }
}