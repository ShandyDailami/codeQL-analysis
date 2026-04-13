import java.io.File;
import java.util.Iterator;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class java_00131_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element : " + doc.getElementsByTagName("root").item(0).getTextContent());

            printElement(doc.getElementsByTagName("element1"));
            printElement(doc.getElementsByTagName("element2"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(NodeList nodes) {
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println("Element " + (i + 1) + " : " + nodes.item(i).getTextContent());
        }
    }
}