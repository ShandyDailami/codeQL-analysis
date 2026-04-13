import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_20494_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a new XMLReader
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Get the root element
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getElementsByTagName("").item(0).getNodeName());

            // Get and print all child nodes
            NodeList nodeList = doc.getElementsByTagName("child");
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Child Node " + (i + 1) + ": " + nodeList.item(i).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}