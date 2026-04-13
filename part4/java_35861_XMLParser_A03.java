import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class java_35861_XMLParser_A03 {

    public static void main(String[] args) {
        // Load the XML document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("example.xml"));

        // Extract the elements
        NodeList nl = doc.getElementsByTagName("student");

        // Process each student element
        for (int i = 0; i < nl.getLength(); i++) {
            Element e = (Element) nl.item(i);

            // Extract the student details
            String name = e.getAttribute("name");
            String age = e.getAttribute("age");
            String id = e.getAttribute("id");

            // Print the student details
            System.out.println("Student ID: " + id);
            System.out.println("Student Name: " + name);
            System.out.println("Student Age: " + age);
        }
    }
}