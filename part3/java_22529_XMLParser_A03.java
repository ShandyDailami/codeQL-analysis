import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_22529_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Load XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("example.xml"));

            // Extract and print all elements
            NodeList nodes = doc.getElementsByTagName("element");
            for (int i = 0; i < nodes.getLength(); i++) {
                Element node = (Element) nodes.item(i);
                String elementContent = node.getTextContent();
                System.out.println("Element content: " + elementContent);

                // Perform security-sensitive operation: Injection
                String injection = "<script>alert('Hello, world!');</script>";
                elementContent += injection;
                node.setTextContent(elementContent);
            }

            // Write modified document
            FileWriter writer = new FileWriter("modified.xml");
            doc.write(writer);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}