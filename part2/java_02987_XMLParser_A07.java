import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileReader;

public class java_02987_XMLParser_A07 {

    public static void main(String[] args) {

        try {
            // create a factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // parse the input file
            Document doc = builder.parse(new File("input.xml"));

            // handle the document
            printElements(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Element : " + eElement.getNodeName());
                System.out.println("Attributes : ");
                // print all attributes
                for (int i = 0; i < eElement.getAttributes().getLength(); i++) {
                    System.out.println("Attribute : " + eElement.getAttributes().item(i).getNodeName() + " = " + eElement.getAttributes().item(i).getTextContent());
                }
            }
        }
    }
}