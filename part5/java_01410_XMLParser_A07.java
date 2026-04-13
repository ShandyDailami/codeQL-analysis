import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_01410_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("example.xml"));

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Extract the values of "name" and "age" elements
            NodeList nodeList = doc.getElementsByTagName("name");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                System.out.println("Name: " + node.getTextContent());
            }

            nodeList = doc.getElementsByTagName("age");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                System.out.println("Age: " + node.getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}