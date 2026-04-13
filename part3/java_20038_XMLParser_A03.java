import java.util.List;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.net.URL;

public class java_20038_XMLParser_A03 {

    public static void main(String[] args) {
        String urlStr = "http://example.com/books.xml"; // Replace with your XML file URL
        try {
            URL url = new URL(urlStr);
            InputStream in = url.openStream();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(in);
            doc.getDocumentElement().normalize();
            List<String> authors = parseAuthors(doc);
            System.out.println("Authors: " + authors);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> parseAuthors(Document doc) {
        List<String> authors = new ArrayList<>();
        NodeList nodeList = doc.getElementsByTagName("author");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;
            String authorName = element.getAttribute("name");
            authors.add(authorName);
        }
        return authors;
    }
}