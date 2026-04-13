import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_37056_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("books.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fis);
            doc.getDocumentElement().normalize();

            ListNode list = new ListNode();
            printNode(doc.getDocumentElement(), list);

            for (Iterator iter = list.children.iterator(); iter.hasNext();) {
                Element element = (Element) iter.next();
                System.out.println("Book Title: " + element.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Book Author: " + element.getElementsByTagName("author").item(0).getTextContent());
                System.out.println("Book Price: " + element.getElementsByTagName("price").item(0).getTextContent());
            }

            fis.close();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printNode(Node node, ListNode list) {
        list.add(node);

        if (node.hasChildNodes()) {
            for (Iterator iter = node.childNodes.iterator(); iter.hasNext();) {
                printNode((Node) iter.next(), list);
            }
        }
    }
}