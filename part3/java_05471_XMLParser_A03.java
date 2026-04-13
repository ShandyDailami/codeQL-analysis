import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_05471_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Load the XML file
            File xmlFile = new File("example.xml");
            FileReader reader = new FileReader(xmlFile);

            // Create a DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(reader);
            doc.getDocumentElement().normalize();

            // Print out the XML file elements and content
            printElements(doc);

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printElements(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String tag = eElement.getTagName();
                System.out.println("Tag : " + tag);
                System.out.println("Attributes : " + eElement.getAttributes());

                // Print out the element's content
                String out = eElement.getTextContent();
                if (out != null)
                    System.out.println("Content : " + out);
            }
        }
    }
}