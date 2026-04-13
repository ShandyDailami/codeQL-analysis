import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_20725_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the input file
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Find the first occurrence of a specific element
            NodeList nodeList = doc.getElementsByTagName("elementName");
            if (nodeList.getLength() > 0) {
                System.out.println("Element found in " + inputFile.getName());
            } else {
                System.out.println("Element not found in " + inputFile.getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}