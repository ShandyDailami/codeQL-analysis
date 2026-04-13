import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;

public class java_20752_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Load the XML file
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Extract the value of the first element with name 'element'
            NodeList nList = doc.getElementsByTagName("element");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("Value of element " + (temp + 1) + " : " + nNode.getTextContent());
            }

            // Write the value to a file
            FileWriter writer = new FileWriter("output.txt");
            writer.write("The value of the first element is: " + nList.item(0).getTextContent());
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}