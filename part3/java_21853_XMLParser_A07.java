import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_21853_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(new File("input.xml"));

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("*");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element element = (Element) nList.item(temp);

                // Print the element name and value
                System.out.println("Element: " + element.getNodeName());
                System.out.println("Value: " + element.getAttribute("value"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}