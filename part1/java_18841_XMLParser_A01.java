import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_18841_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input file
            Document doc = builder.parse(new File("input.xml"));

            // Retrieve the root element
            doc.getDocumentElement().normalize();

            // Extract and print all element names
            List<String> elementNames = new ArrayList<>();
            extractElementNames(doc, elementNames);
            System.out.println(elementNames);

            // Check for any access controls
            checkAccessControl(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void extractElementNames(Document doc, List<String> elementNames) {
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            elementNames.add(nodes.item(i).getNodeName());
            extractElementNames(nodes.item(i).getChildNodes(), elementNames);
        }
    }

    private static void checkAccessControl(Document doc) {
        // Here you should add the code to check for security sensitive operations
        // For now, this method does nothing
    }
}