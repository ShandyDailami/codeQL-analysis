import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_36486_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        parseFile(xmlFile);
    }

    private static void parseFile(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;
        try {
            document = builder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
       
        }

        document.getDocumentElement().normalize();

        System.out.println("Root element: " + document.getElements().getItem(0).getNodeName());

        NodeList nodeList = document.getElementsByTagName("book");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);

            String title = element.getElementsByTagName("title").item(0).getTextContent();
            String author = element.getElementsByTagName("author").item(0).getTextContent();
            String price = element.getElementsByTagName("price").item(0).getTextContent();

            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Price: " + price);
        }
    }
}