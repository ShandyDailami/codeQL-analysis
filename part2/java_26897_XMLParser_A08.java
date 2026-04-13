import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_26897_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Get the XML document
            File xmlFile = new File("example.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Extract data from the XML document
            NodeList nodeList = document.getElementsByTagName("book");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;

                String title = element.getAttribute("id");
                String author = element.getElementsByTagName("author").item(0).getTextContent();
                String price = element.getElementsByTagName("price").item(0).getTextContent();

                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Price: " + price);
            }

            // Handle integrity failure here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}