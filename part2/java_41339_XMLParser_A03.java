import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_41339_XMLParser_A03 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try {
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nlist = doc.getElementsByTagName("element");

            for (int temp = 0; temp < nlist.getLength(); temp++) {
                Element element = (Element) nlist.item(temp);
                // Extract and print data
                System.out.println("Element " + (temp + 1) + " Data: " + element.getElementsByTagName("data").item(0).getTextContent());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}