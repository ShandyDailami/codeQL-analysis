import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class java_28096_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            ListElement(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void ListElement(Document doc) {
        NodeList nlist = doc.getElementsByTagName("item");

        for (int temp = 0; temp < nlist.getLength(); temp++) {
            Node nnode = nlist.item(temp);
            if (nnode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nnode;

                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String address = element.getElementsByTagName("address").item(0).getTextContent();

                System.out.println("Name: " + name);
                System.out.println("Address: " + address);
            }
        }
    }
}