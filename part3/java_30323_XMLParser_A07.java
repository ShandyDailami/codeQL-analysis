import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_30323_XMLParser_A07 {
    public static void main(String[] args) {
        File inputFile = new File("books.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;
        try {
            doc = dBuilder.parse(inputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
        System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("book");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\n  Book - " + (temp + 1));
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Author : " + eElement.getElementsByTagName("author").item(0).getTextContent());
            }
        }
    }
}