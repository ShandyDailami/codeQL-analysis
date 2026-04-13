import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_12166_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("input.xml"));

            // Get the root element
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            // Traverse through each element
            NodeList nList = doc.getElementsByTagName("*");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("Element " + (temp + 1) + ": " + nNode.getNodeName() + " - " + nNode.getNodeValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}