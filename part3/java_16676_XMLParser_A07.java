import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_16676_XMLParser_A07 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File inputFile = new File("books.xml");
        Document document = null;
        try {
            document = builder.parse(inputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        document.getDocumentElement().normalize();

        System.out.println("Root Element: " + document.getDocumentElement().getNodeName());

        NodeList nList = document.getElementsByTagName("book");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nBook " + (temp + 1));

            Element eElement = (Element) nNode;

            System.out.println("Book Title: " + eElement.getElementsByTagName("title").item(0).getTextContent());
            System.out.println("Book Price: " + eElement.getElementsByTagName("price").item(0).getTextContent());
        }
    }
}