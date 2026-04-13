import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_07946_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Read the XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("sample.xml"));

            // Get the root element of the document
            doc.getDocumentElement().normalize();

            // Get all the element nodes
            NodeList nodeList = doc.getElementsByTagName("element");

            // Process each element node
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                // Process each child node
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    // Get the value of the element node
                    String elementValue = element.getElementsByTagName("value").item(0).getTextContent();
                    // Do something with the elementValue
                    System.out.println("Value: " + elementValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}