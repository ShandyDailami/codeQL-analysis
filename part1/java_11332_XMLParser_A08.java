import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_11332_XMLParser_A08 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("data.xml"));
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("item");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;

                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String author = element.getElementsByTagName("author").item(0).getTextContent();
                String price = element.getElementsByTagName("price").item(0).getTextContent();

                System.out.println("Name: " + name);
                System.out.println("Author: " + author);
                System.out.println("Price: " + price);
                System.out.println("---------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}