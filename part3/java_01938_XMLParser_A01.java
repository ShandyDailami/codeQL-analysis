import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;

public class java_01938_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("input.xml"); // replace with your xml file path
        parse(xmlFile);
    }

    public static void parse(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;

        try {
            document = builder.parse(xmlFile);

            // Get the root element
            document.getDocumentElement().normalize();

            System.out.println("Root Element: " + document.getDocumentElement().getNodeName());

            // Print all the child nodes
            NodeList nodeList = document.getElementsByTagName("*");
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Child Node: " + nodeList.item(i).getNodeName());
           
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}