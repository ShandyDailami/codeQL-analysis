import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class java_38061_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File xmlFile = new File("path_to_your_xml_file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Find the 'person' elements and print their 'name' and 'age'
            NodeList nList = doc.getElementsByTagName("person");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element eElement = (Element) nList.item(temp);
                String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                String age = eElement.getElementsByTagName("age").item(0).getTextContent();
                System.out.println("Name: " + name + ", Age: " + age);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}