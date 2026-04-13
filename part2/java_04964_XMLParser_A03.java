import java.io.File;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_04964_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root Element : " + doc.getElementsByTagName("note").item(0).getTextContent());

            // Iterate through the child nodes of the root node
            NodeList nodeList = doc.getElementsByTagName("note");
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                System.out.println("Note : " + nodeList.item(temp).getChildNodes().item(0).getNodeValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}