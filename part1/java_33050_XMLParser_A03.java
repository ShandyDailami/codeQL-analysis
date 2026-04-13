import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class java_33050_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Load the document
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Extract and print out the data
            printData(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printData(Document doc) {
        NodeList nList = doc.getElementsByTagName("entry");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Element entry = (Element) nList.item(temp);

            // Security-sensitive operations
            String name = entry.getElementsByTagName("name").item(0).getTextContent();
            String email = entry.getElementsByTagName("email").item(0).getTextContent();

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        }
    }
}