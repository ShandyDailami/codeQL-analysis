import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_41263_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, IOException {
        // Step 1: Parse the XML file
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File("sample.xml"));

        // Step 2: Retrieve the document elements
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("student");

        // Step 3: Iterate over the student nodes
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);

            // Step 4: Retrieve the attributes
            Element eElement = (Element) nNode;
            String name = eElement.getAttribute("name");
            String id = eElement.getAttribute("id");
            String grade = eElement.getAttribute("grade");

            // Step 5: Print the attributes
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Grade: " + grade);
        }
    }
}