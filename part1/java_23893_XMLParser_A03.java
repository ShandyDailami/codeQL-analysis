import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.List;
import java.util.ArrayList;

public class java_23893_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("sample.xml"));

            // Parse the XML and print the nodes
            parseNodes(doc.getElementsByTagName("book"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseNodes(NodeList nodes) {
        List<String> bookTitles = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                String title = element.getAttribute("title");
                bookTitles.add(title);
            }
        }

        // Print book titles
        for (String title : bookTitles) {
            System.out.println(title);
        }
    }
}