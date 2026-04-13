import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_35700_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder using the factory
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the input xml file into a Document object
            Document doc = dBuilder.parse(new File("input.xml"));

            // Print the file's elements
            printElements(doc);

            // Write to a file
            writeToFile(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printElements(Document doc) {
        System.out.println("\nElement :");
        NodeList nl = doc.getElementsByTagName("element");
        for (int temp = 0; temp < nl.getLength(); temp++) {
            Node n = nl.item(temp);
            System.out.println(n.getNodeName() + " : " + n.getTextContent());
        }
    }

    public static void writeToFile(Document doc) {
        try {
            FileWriter writer = new FileWriter("output.txt");
            doc.getDocumentElement().normalize();
            indent(writer, 0, doc.getDocumentElement());
            writer.write(doc.getElementsByTagName("element").item(0).getTextContent());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void indent(FileWriter writer, int depth, Node node) throws IOException {
        for (int i = 0; i < depth; i++)
            writer.write('\t');
        writer.write(node.getTextContent());
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++)
            indent(writer, depth, children.item(i));
    }
}