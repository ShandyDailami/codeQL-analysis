import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_28464_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Use it to create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document document = builder.parse(new File("input.xml"));

            // Step 4: Print out the XML contents
            printDocument(document);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document document) {
        Element root = document.getDocumentElement();
        System.out.println("Root Element: " + root.getNodeName());

        // Iterate over child nodes
        List<Element> children = root.getChildNodes();
        for (int i = 0; i < children.size(); i++) {
            Element child = (Element) children.get(i);
            System.out.println("Child Node " + (i + 1) + ": " + child.getNodeName());
        }
    }
}