import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import java.security.InvalidParameterException;

public class java_22900_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");  // replace with your file path
            parseXmlFile(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXmlFile(File xmlFile) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(xmlFile);

        // Print out all the elements of the XML file
        printElements(doc);

        // Perform security-sensitive operations related to integrity failure
        checkIntegrity(doc);
    }

    private static void printElements(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            System.out.println("Element " + (i + 1) + ": " + element.getTagName());
        }
    }

    private static void checkIntegrity(Document doc) throws InvalidParameterException {
        NodeList nodeList = doc.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String tagName = element.getTagName();
            if (!isTagNameValid(tagName)) {
                throw new InvalidParameterException("Invalid tag name: " + tagName);
            }
        }
    }

    private static boolean isTagNameValid(String tagName) {
        // Here, we can add the logic to validate the tag name, such as checking the length,
        // checking if it only contains alphanumeric characters, and so on.
        // In this example, we assume that the tag name is valid if it is not null or empty.
        return !(tagName == null || tagName.isEmpty());
    }
}