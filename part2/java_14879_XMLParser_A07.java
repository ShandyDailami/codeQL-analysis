import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class java_14879_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            // Get all <student> nodes
            NodeList studentNodes = doc.getElementsByTagName("student");

            // Iterate over each student node
            for (int i = 0; i < studentNodes.getLength(); i++) {
                Element studentElement = studentNodes.getItem(i);

                // Print the name attribute
                System.out.println("Student: " + studentElement.getAttribute("name"));

                // Get the <course> nodes and print their attributes
                NodeList courseNodes = studentElement.getElementsByTagName("course");
                for (int j = 0; j < courseNodes.getLength(); j++) {
                    Element courseElement = courseNodes.getItem(j);
                    System.out.println("Course: " + courseElement.getAttribute("title"));
                }
           
                // Print the mark attribute
                System.out.println("Mark: " + studentElement.getAttribute("mark"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}