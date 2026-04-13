import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class java_01342_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Load the XML document
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Print out all element names
            NodeList nList = doc.getElementsByTagName("*");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element element = (Element) nList.item(temp);
                System.out.println("Element: " + element.getNodeName());
            }

            // Print out all attribute names
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element element = (Element) nList.item(temp);
                System.out.print("Attributes: ");
                for (int i = 0; i < element.getAttributeCount(); i++) {
                    System.out.print(element.getAttributeNode(i).getNodeName() + "=" + element.getAttributeNode(i).getTextContent());
                    System.out.print(" ");
                }
                System.out.println("");
            }

            // Print out all child nodes
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element element = (Element) nList.item(temp);
                System.out.print("Children: ");
                for (int i = 0; i < element.getChildNodes().getLength(); i++) {
                    if (element.getChildNodes().item(i).getNodeType() == Node.COMMENT_NODE)
                        continue;
                    System.out.print(element.getChildNodes().item(i).getNodeName());
                    System.out.print(" ");
                }
                System.out.println("");
            }

            // Print out all the text in the document
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element element = (Element) nList.item(temp);
                System.out.print("Text: " + element.getTextContent());
                System.out.println("");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}