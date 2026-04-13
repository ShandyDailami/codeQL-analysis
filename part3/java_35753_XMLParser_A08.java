import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_35753_XMLParser_A08 {

    public static void main(String[] args) {
        // Creating the DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Creating the DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsing the XML document
            Document doc = builder.parse(new File("sample.xml"));

            // Getting the document element
            doc.getDocumentElement().normalize();

            // Getting the list of nodes
            NodeList nodeList = doc.getElementsByTagName("student");

            // Writing to the file
            FileWriter writer = new FileWriter("output.txt");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                // Writing to the file
                writer.write("Student " + (i + 1) + "\n");
                writer.write("Name: " + node.getChildNodes().item(1).getNodeValue() + "\n");
                writer.write("Age: " + node.getChildNodes().item(3).getNodeValue() + "\n");
                writer.write("Grade: " + node.getChildNodes().item(5).getNodeValue() + "\n");
                writer.write("\n");
            }
            writer.close();

            System.out.println("XML Parsing Complete!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}