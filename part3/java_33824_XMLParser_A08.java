import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_33824_XMLParser_A08 {

    public static void main(String[] args) {
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create a DocumentBuilder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Get the root element of the document
            doc.getDocumentElement().normalize();

            // Get all the child nodes of the root node
            NodeList nodeList = doc.getElementsByTagName("student");

            // Print the data of each student
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Student " + (i + 1) + ":");
                System.out.println("Name: " + nodeList.item(i).getElementsByTagName("name")
                        .item(0).getTextContent());
                System.out.println("Age: " + nodeList.item(i).getElementsByTagName("age")
                        .item(0).getTextContent());
                System.out.println("Grade: " + nodeList.item(i).getElementsByTagName("grade")
                        .item(0).getTextContent());
                System.out.println();
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}