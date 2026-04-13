import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_14492_XMLParser_A03 {

    public static void main(String[] args) {
        String fileName = "example.xml";
        parseXML(fileName);
    }

    public static void parseXML(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(new File(fileName));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        NodeList list = doc.getElementsByTagName("student");
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Name: " + node.getElementsByTagName("name")
                    .item(0).getTextContent());
            System.out.println("Age: " + node.getElementsByTagName("age")
                    .item(0).getTextContent());
            System.out.println("Grade: " + node.getElementsByTagName("grade")
                    .item(0).getTextContent());
            System.out.println("\n");
        }
    }
}