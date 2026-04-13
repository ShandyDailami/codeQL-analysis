import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.Iterator;

public class java_21936_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("*");

            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            Iterator i = nList.iterator();
            while (i.hasNext()) {
                Node n = (Node) i.next();
                if (n instanceof Element) {
                    System.out.println("Element: " + n.getNodeName());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}