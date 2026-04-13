import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class java_40239_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Step 1: Setup DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Get DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document doc = builder.parse(new File("path_to_your_file.xml"));

            // Step 4: Extract sensitive data
            Element root = doc.getDocumentElement();
            String sensitiveData = extractSensitiveData(root);

            // Step 5: Display the sensitive data
            System.out.println("Sensitive data: " + sensitiveData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String extractSensitiveData(Element element) {
        // Assume all child nodes are sensitive data
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            Node node = element.getChildNodes().item(i);
            if (node.getNodeType() == Node.TEXT_NODE && isSensitiveData((String) node.getTextContent())) {
                return (String) node.getTextContent();
            } else if (node.getNodeType() == Node.ELEMENT_NODE) {
                return extractSensitiveData((Element) node);
            }
        }
        return "";
    }

    private static boolean isSensitiveData(String data) {
        // Implement sensitive data detection logic here
        // For now, just return false if the data is empty or contains 'sensitive'
        return !(data == null || data.toLowerCase().contains("sensitive"));
    }
}