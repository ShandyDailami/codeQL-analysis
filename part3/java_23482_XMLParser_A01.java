import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_23482_XMLParser_A01 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("input.xml"));

            doc.getDocumentElement().normalize();

            NodeList books = doc.getElementsByTagName("book");

            for (int i = 0; i < books.getLength(); i++) {
                Element bookElement = (Element) books.item(i);

                String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                String author = bookElement.getElementsByTagName("author").item(0).getTextContent();

                System.out.println("Title: " + title + ", Author: " + author);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}