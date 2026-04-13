import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

public class java_42084_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml"); // replace with your xml file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("name");
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Name: " + nodes.item(i).getTextContent());
            }

            nodes = doc.getElementsByTagName("age");
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Age: " + nodes.item(i).getTextContent());
            }

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}