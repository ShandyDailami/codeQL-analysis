import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_10686_XMLParser_A03 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        parse(inputFile);
    }

    public static void parse(File inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(inputFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("student");

            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Student: " + nodeList.item(i).getChildNodes().item(0).getTextContent());
                System.out.println("Grade: " + nodeList.item(i).getChildNodes().item(1).getTextContent());
                System.out.println("------------------------");
            }

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}