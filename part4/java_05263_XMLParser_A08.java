import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class java_05263_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml"); // replace with your input file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(inputFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("item");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                System.out.println("Item: " + element.getAttribute("name"));
                System.out.println("Value: " + element.getAttribute("value"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}