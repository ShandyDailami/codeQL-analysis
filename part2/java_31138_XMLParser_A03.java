import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class java_31138_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("sample.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("*");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element eElement = (Element) nList.item(temp);
                System.out.println("Element : " + eElement.getNodeName());
                System.out.println("Attribute : " + eElement.getAttribute("attributeName"));
                System.out.println("Value : " + eElement.getFirstChild().getNodeValue());
           .
            .
            .
            // Continue as per your requirements
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}