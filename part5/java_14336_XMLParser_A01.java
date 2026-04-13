import java.util.Stack;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class java_14336_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            InputStream inputStream = new FileInputStream(new File("example.xml"));
            InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(reader);

            // Parse the XML document
            parse(document);

            // Close the reader
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parse(Document document) {
        NodeList nodes = document.getElementsByTagName("node");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String name = element.getTagName();
                stack.push(name);
                System.out.println("Pushed: " + name);
            } else if (node.getNodeType() == Node.TEXT_NODE) {
                String text = node.getNodeValue();
                System.out.println("Text: " + text);
            }
        }

        // Print the stack
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
    }
}