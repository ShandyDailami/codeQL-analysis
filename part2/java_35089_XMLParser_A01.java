import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_35089_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Load the XML document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("example.xml"));

            // Get the root element of the document
            doc.getDocumentElement().normalize();

            // Get all elements
            NodeList nList = doc.getElementsByTagName("student");

            // Iterate through all student nodes
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                // Get all sub-elements of the current node
                Element eElement = (Element) nNode;

                // Print the data of the current node
                System.out.println("Student ID: " + eElement.getAttribute("id"));
                System.out.println("Student Name: " + eElement.getAttribute("name"));
                System.out.println("Student Age: " + eElement.getAttribute("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}