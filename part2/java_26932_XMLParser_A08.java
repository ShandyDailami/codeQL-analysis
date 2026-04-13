import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;

public class java_26932_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("/path/to/your/file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            printElementNames(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementNames(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Element eElement = (Element) nList.item(temp);
            System.out.println("Element : " + eElement.getTagName());
        }
    }
}