import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_31554_XMLParser_A07 {

    public static void main(String[] args) {
        parseXML("input.xml");
    }

    public static void parseXML(String fileName) {
        try {
            File inputFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("student");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                Element element = (Element) node;

                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String address = element.getElementsByTagName("address").item(0).getTextContent();

                System.out.println("Name: " + name);
                System.out.println("Address: " + address);

                FileWriter file = new FileWriter("output.txt", true); // append mode
                file.write("Name: " + name + ", Address: " + address + "\n");
                file.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}