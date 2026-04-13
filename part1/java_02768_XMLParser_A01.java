import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class java_02768_XMLParser_A01 {

    public static void main(String[] args) {
        File inputFile = new File("src/main/resources/input.xml");
        parseFile(inputFile);
    }

    public static void parseFile(File inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputFile);
        document.getDocumentElement().normalize();
        printElements(document);
    }

    public static void printElements(Document document) {
        NodeList nodeList = document.getElementsByTagName("*");
        List<String> elements = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String elementName = element.getNodeName();
            elements.add(elementName);
        }
        System.out.println(elements);
    }
}