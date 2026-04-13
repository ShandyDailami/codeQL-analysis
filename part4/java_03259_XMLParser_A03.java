import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.Iterator;

public class java_03259_XMLParser_A03 {
    public static void main(String[] args) {
        String fileName = "sample.xml";
        File file = new File(fileName);

        try {
            InputStream inputStream = new FileInputStream(file);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputStream);

            doc.getDocumentElement().normalize();
            printElementNames(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printElementNames(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("*");
        Iterator<Node> iterator = nodeList.iterator();

        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Element name: " + element.getTagName());
            }
        }
    }
}