import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_27555_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml");  // replace with your file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("student");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                Element eElement = (Element) nNode;

                String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                String id = eElement.getElementsByTagName("id").item(0).getTextContent();
                String address = eElement.getElementsByTagName("address").item(0).getTextContent();

                writeToFile(name, id, address);
            }

            dBuilder = null;
            doc = null;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(String name, String id, String address) {
        try (FileWriter file = new FileWriter("output.txt", true)) {
            file.write("Name: " + name + ", ID: " + id + ", Address: " + address + "\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}