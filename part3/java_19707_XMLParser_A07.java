import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.net.URL;

public class java_19707_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.w3schools.com/xml/books.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // parse using DOM parser
            Document doc = dBuilder.parseURL(url.toString());

            // get root element
            Element root = doc.getDocumentElement();

            // print all book titles
            System.out.println("Books in the list: ");
            ListBooks(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void ListBooks(Element node) {
        // get children
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element book = (Element) child;
                System.out.println("Title: " + book.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Price: " + book.getElementsByTagName("price").item(0).getTextContent());
                System.out.println("Author: " + book.getElementsByTagName("author").item(0).getTextContent());
                System.out.println("-----------------------");
            }
        }
    }
}