import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.IOException;

public class java_13549_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file.xml"; // provide your XML file path here
        parseXmlFile(xmlFile);
    }

    private static void parseXmlFile(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(xmlFile));

            // Get the root element
            Element rootElement = document.getDocumentElement();

            // Get all 'student' elements
            NodeList studentList = rootElement.getElementsByTagName("student");

            // Iterate over all 'student' elements
            for (int i = 0; i < studentList.getLength(); i++) {
                Node studentNode = studentList.item(i);
                if (studentNode instanceof Element) {
                    Element studentElement = (Element) studentNode;

                    // Extract data from each 'student' element
                    String name = studentElement.getAttribute("name");
                    String age = studentElement.getAttribute("age");
                    String grade = studentElement.getAttribute("grade");

                    System.out.println("Student Name: " + name);
                    System.out.println("Student Age: " + age);
                    System.out.println("Student Grade: " + grade);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}