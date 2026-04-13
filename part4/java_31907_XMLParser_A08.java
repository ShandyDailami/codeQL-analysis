import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class java_31907_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("books.xml");
        parseBooks(xmlFile);
    }

    public static void parseBooks(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;
        try {
            document = builder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
       
        }

        document.getDocumentElement().normalize();

        NodeList bookList = document.getElementsByTagName("book");

        for (int i = 0; i < bookList.getLength(); i++) {
            Element bookElement = (Element) bookList.item(i);

            String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
            String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
            String publicationDate = bookElement.getElementsByTagName("publicationDate").item(0).getTextContent();

            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Publication Date: " + publicationDate);
            System.out.println();
        }
    }
}