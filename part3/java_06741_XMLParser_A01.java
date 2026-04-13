import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_06741_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Get an instance of DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Print all element names and values
            printElementNamesAndValues(doc);

            // Here you can add your security-sensitive operations

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementNamesAndValues(Document doc) {
        NodeList nl = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nl.getLength(); temp++) {
            Node n = nl.item(temp);
            if (n instanceof Element) {
                System.out.println(((Element) n).getNodeName() + " : "
                        + ((Element) n).getElementText());
            }
        }
    }
}