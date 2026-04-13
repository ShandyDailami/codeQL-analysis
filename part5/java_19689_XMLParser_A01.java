import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class java_19689_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("*");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element element = (Element) nList.item(temp);
                System.out.println("Element Name: " + element.getNodeName());

                if (element.getAttributes().getLength() > 0) {
                    for (int i = 0; i < element.getAttributes().getLength(); i++) {
                        System.out.println("Attribute Name: " + element.getAttributes().item(i).getNodeName() + " " + element.getAttributes().item(i).getTextContent());
                    }
                }
            }

            dBuilder = null;
            dbFactory = null;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}