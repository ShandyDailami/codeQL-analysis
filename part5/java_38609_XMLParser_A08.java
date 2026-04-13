import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_38609_XMLParser_A08 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File inputFile = new File("input.xml");
        Document document = null;

        try {
            document = builder.parse(inputFile);
            document.getDocumentElement().normalize();

            NodeList nList = document.getElementsByTagName("*");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) node;
                    System.out.print("Element: " + e.getTagName());
                    System.out.print(" Attributes: ");

                    for (int j = 0; j < e.getAttributes().getLength(); j++) {
                        Node attribute = e.getAttributes().item(j);
                        System.out.print(attribute.getNodeName() + "=" + attribute.getTextContent());
                    }
                    System.out.println("");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}