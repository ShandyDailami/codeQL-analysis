import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_29421_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();
            System.out.println("Root element : " + root.getNodeName());

            printElement(root);

        } catch (IOException e) {
            e.printStackTrace();
       
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static void printElement(Element element) {
        System.out.print("Name: " + element.getNodeName());
        System.out.print(" Value: " + element.getFirstChild().getNodeValue());

        Element child = element.getFirstChild();
        while (child != null) {
            System.out.print("--------------------");
            System.out.print("Child node: " + child.getNodeName());
            System.out.print(" Value: " + child.getFirstChild().getNodeValue());
            child = child.getNextSibling();
        }
    }
}