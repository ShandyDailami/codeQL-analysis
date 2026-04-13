import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_36215_XMLParser_A03 {

    public static void main(String[] args) {
        parseXML("example.xml");
    }

    public static void parseXML(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File file = new File(fileName);
        Document document;

        try {
            document = builder.parse(file);

            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("employee");

            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Employee " + (i + 1));
                System.out.println("Name: " +
                        document.getElementsByTagName("name")
                                .item(i).getTextContent());
                System.out.println("Age: " +
                        document.getElementsByTagName("age")
                                .item(i).getTextContent());
                System.out.println("Department: " +
                        document.getElementsByTagName("department")
                                .item(i).getTextContent());
                System.out.println("---------------------------");
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}