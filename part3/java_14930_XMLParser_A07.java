import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_14930_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
            System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());

            NodeList nodeList = doc.getElementsByTagName("student");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                System.out.println("\n Student Record : " + (temp + 1));
                System.out.println("First Name : "
                    + nodeList.item(temp).getAttributes().getNamedItem("firstName").getNodeValue());
                System.out.println("Last Name : "
                    + nodeList.item(temp).getAttributes().getNamedItem("lastName").getNodeValue());
                System.out.println("Grade : "
                    + nodeList.item(temp).getAttributes().getNamedItem("grade").getNodeValue());
            }

            System.out.println("\n End of parsing");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}