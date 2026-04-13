import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;

public class java_25863_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("yourfile.xml"); // replace with your file path

        if (!xmlFile.exists()) {
            System.out.println("File not found.");
            return;
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;

        try {
            doc = builder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        doc.getDocumentElement().normalize();

        System.out.println("XML file parsed successfully.");

        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            System.out.println("Element: " + element.getTagName());
            System.out.println("Attributes: " + element.getAttributes().getLength());
        }
    }
}