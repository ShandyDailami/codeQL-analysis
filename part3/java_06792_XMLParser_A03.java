import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_06792_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("employee");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Employee " + (i + 1) + ": ");
                System.out.println("Name: " + node.getChildNodes().item(0).getTextContent());
                System.out.println("Age: " + node.getChildNodes().item(1).getTextContent());
                System.out.println("Department: " + node.getChildNodes().item(2).getTextContent());
                System.out.println("Position: " + node.getChildNodes().item(3).getTextContent());
                System.out.println("Salary: " + node.getChildNodes().item(4).getTextContent());
            }

            builder = null;
            factory = null;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}