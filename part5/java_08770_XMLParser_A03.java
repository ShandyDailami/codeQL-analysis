import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class java_08770_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("*");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                System.out.println("Element : " + element.getNodeName());
                System.out.println("Attributes : ");

                for (int j = 0; j < element.getAttributes().getLength(); j++) {
                    System.out.println("Attribute Name : " + element.getAttributes().item(j).getNodeName() + " Value : " + element.getAttributes().item(j).getTextContent());
                }
           
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}