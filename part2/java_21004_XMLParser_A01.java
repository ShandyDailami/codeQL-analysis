import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class java_21004_XMLParser_A01 {

    public static void main(String[] args) {

        String fileName = "sample.xml";

        PrivilegedAction<Document> load = new PrivilegedAction<Document>() {
            public Document run() {
                try {
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    return builder.parse(new File(fileName));
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };

        Document document = AccessController.doPrivileged(load, null);

        if (document == null) {
            System.out.println("Document cannot be parsed");
            return;
        }

        NodeList nodeList = document.getElementsByTagName("book");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;

            String title = element.getElementsByTagName("title").item(0).getTextContent();
            String price = element.getElementsByTagName("price").item(0).getTextContent();
            String author = element.getElementsByTagName("author").item(0).getTextContent();

            System.out.println("Title: " + title);
            System.out.println("Price: " + price);
            System.out.println("Author: " + author);
        }
    }
}