import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileNotFoundException;

public class java_17829_XMLParser_A01 {
    public static void main(String[] args) throws Exception {
        File inputFile = new File("input.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(inputFile);
            document.getDocumentElement().normalize();
            printElements(document);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found. ");
        }
    }

    public static void printElements(Document document) {
        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            System.out.println("Element " + i + " : " + element.getTagName());
        }
    }
}