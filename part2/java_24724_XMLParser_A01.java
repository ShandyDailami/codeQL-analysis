import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.apache.xml.utils.DocumentHelper;

public class java_24724_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("yourfile.xml"); // replace with your xml file

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("book");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Book " + (i + 1) + ":");
                System.out.println("Title: " + node.getAttributes().getNamedItem("title").getNodeValue());
                System.out.println("Price: " + node.getAttributes().getNamedItem("price").getNodeValue());
                System.out.println("----------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}