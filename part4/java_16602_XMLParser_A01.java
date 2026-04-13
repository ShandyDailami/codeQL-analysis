import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class java_16602_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("student");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element element = (Element) nList.item(temp);
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String id = element.getElementsByTagName("id").item(0).getTextContent();
                String age = element.getElementsByTagName("age").item(0).getTextContent();

                // Do some security sensitive operation with the name, id and age
                // Example: hash them
                String hashedName = hash(name);
                String hashedId = hash(id);
                String hashedAge = hash(age);

                System.out.println("Hashed Name: " + hashedName);
                System.out.println("Hashed ID: " + hashedId);
                System.out.println("Hashed Age: " + hashedAge);
            }

            dBuilder = null;
            doc = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String hash(String str) {
        // Implement hash function here
        // For simplicity, we're just returning the input string
        return str;
    }
}