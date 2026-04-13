import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;

public class java_35128_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("*");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element eElement = (Element) nList.item(temp);
                System.out.println("\nElement : " + eElement.getNodeName());
                NodeList childNodes = eElement.getChildNodes();
                for (int i = 0; i < childNodes.getLength(); i++) {
                    if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) childNodes.item(i);
                        System.out.println("Child Element : " + childElement.getNodeName());
                        System.out.println("Child Element Attributes : ");
                        for (int j = 0; j < childElement.getAttributes().getLength(); j++) {
                            System.out.println("Attribute Name: " + childElement.getAttributes().item(j).getNodeName() +
                                    " Attribute Value: " + childElement.getAttributes().item(j).getTextContent());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}