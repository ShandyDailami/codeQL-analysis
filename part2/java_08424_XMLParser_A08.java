import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.ParserConfigurationException;

public class java_08424_XMLParser_A08 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try (Document document = dBuilder.parse(inputFile)) {
            document.getDocumentElement().normalize();

            NodeList nList = document.getElementsByTagName("*");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element element = (Element) nList.item(temp);
                System.out.println("Tag : " + element.getTagName() + " , Value : " + element.getFirstChild().getNodeValue());
            }

        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}