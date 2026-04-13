import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.Iterator;

public class java_34700_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("books.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList bookList = doc.getElementsByTagName("book");

            Iterator<?> bookIterator = bookList.iterator();

            while (bookIterator.hasNext()) {
                Node bookNode = bookIterator.nextNode();
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;

                    String title = bookElement.getAttribute("title");
                    String author = bookElement.getAttribute("author");
                    String price = bookElement.getAttribute("price");

                    System.out.println("Title: " + title);
                    System.out.println("Author: " + author);
                    System.out.println("Price: " + price);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}