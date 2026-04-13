import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_36402_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new File("sample.xml")); // replace with your XML file

            doc.getDocumentElement().normalize();

            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            NodeList nlist = doc.getElementsByTagName("*");

            for (int temp = 0; temp < nlist.getLength(); temp++) {
                Node node = nlist.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) node;
                    System.out.println("Tag: " + e.getTagName());
                    System.out.println("Attribute 'Name': " + e.getAttribute("Name"));
                    System.out.println("Value: " + e.getFirstChild().getNodeValue());
                    System.out.println("Inner XML: " + e.getFirstChild().getNextSibling().getNodeValue());
                    System.out.println("------------------------------");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}