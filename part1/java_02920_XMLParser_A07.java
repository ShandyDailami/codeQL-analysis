import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_02920_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the input file
            Document doc = dBuilder.parse(new File("input.xml"));

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Extract and print the value of the first <name> element
            NodeList nList = doc.getElementsByTagName("name");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("Name: " + nNode.getTextContent());
            }

            // Write to a file
            FileWriter writer = new FileWriter("output.txt");
            writer.write("XML Parsed Successfully!");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}