import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_19239_XMLParser_A08 {
    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file.xml"; // replace with your file path
        parseFile(filePath);
    }

    public static void parseFile(String filePath) {
        try {
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            List<Element> elements = document.getElementsByTagName("item");
            for (int i = 0; i < elements.size(); i++) {
                printElement(elements.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printElement(Element element) {
        String elementContent = element.getTextContent();
        System.out.println("Item " + (i + 1) + ": " + elementContent);
    }
}