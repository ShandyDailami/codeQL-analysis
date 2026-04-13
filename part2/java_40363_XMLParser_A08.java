import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_40363_XMLParser_A08 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        parse(inputFile);
    }

    public static void parse(File inputFile) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = dBuilder.parse(inputFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList nl = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nl.getLength(); temp++) {
            Element element = (Element) nl.item(temp);
            System.out.println("Element : " + element.getTagName());

            System.out.print("Attributes : ");
            for (int j = 0; j < element.getAttributes().getLength(); j++) {
                System.out.print(element.getAttributes().item(j).getNodeName() + "=" +
                        element.getAttributes().item(j).getNodeValue() + ", ");
            }

            System.out.println("\n");
        }
    }
}