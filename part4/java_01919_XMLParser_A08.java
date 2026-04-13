import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;

public class java_01919_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml"); // replace with your xml file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("*");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element eElement = (Element) nList.item(temp);

                System.out.println("Element : " + eElement.getNodeName());
                System.out.println("Attribute : " + eElement.getAttribute("attribute"));
                System.out.println("Value : " + eElement.getFirstChild().getNodeValue());
           
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}