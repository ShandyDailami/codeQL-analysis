import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_06049_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            List<String> tags = List.of("tag1", "tag2", "tag3");
            for (String tag : tags) {
                extractData(doc, tag);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void extractData(Document doc, String tag) {
        NodeList nList = doc.getElementsByTagName(tag);
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("Value of node " + temp + ": " + nNode.getTextContent());
        }
    }
}