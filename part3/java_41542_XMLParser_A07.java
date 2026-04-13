import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class java_41542_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("input.xml"));

            // Retrieve the root element
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            // Traverse through all elements and print their names and attributes
            NodeList nList = doc.getElementsByTagName("*");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("Element: " + nNode.getNodeName());
                if (nNode.getAttributes() != null) {
                    for (int j = 0; j < nNode.getAttributes().getLength(); j++) {
                        System.out.println("Attribute: " + nNode.getAttributes().item(j).getNodeName() + " : " + nNode.getAttributes().item(j).getTextContent());
                    }
                }
            }

            // Close the input file
            doc.getDocumentElement().normalize();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}