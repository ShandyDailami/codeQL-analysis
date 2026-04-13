import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_19569_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml"); // Provide the path of your input file
        parse(inputFile);
    }

    public static void parse(File inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("*");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Element elm = (Element) nList.item(temp);
            System.out.println("\nElement " + (temp + 1));
            System.out.println("Element Name: " + elm.getTagName());
            System.out.println("Element Value: " + elm.getTextContent());
        }
    }
}