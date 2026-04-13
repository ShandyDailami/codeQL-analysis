import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_39091_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Parse XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Step 2: Read XML
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getElementsByTagName("student").item(0).getTextContent());

            NodeList nodeList = doc.getElementsByTagName("student");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Element element = (Element) nodeList.item(temp);

                // Get student details
                String id = element.getElementsByTagName("id").item(0).getTextContent();
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String course = element.getElementsByTagName("course").item(0).getTextContent();

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Course: " + course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}