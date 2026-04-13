import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.net.URL;

public class java_08500_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com/books.xml"); // replace with your XML file URL
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(url.openStream());

            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName("book");
            
            for (int i = 0; i < list.getLength(); i++) {
                Element e = (Element) list.item(i);
                String title = e.getElementsByTagName("title").item(0).getTextContent();
                String author = e.getElementsByTagName("author").item(0).getTextContent();
                String price = e.getElementsByTagName("price").item(0).getTextContent();

                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Price: " + price);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}