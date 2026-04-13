import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_35527_XMLParser_A03 {
    public static void main(String[] args) {
        File inputFile = new File("books.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException e) {
            System.out.println("Error: Parser Configuration failed. " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error: SAX Exception thrown. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: File reading error. " + e.getMessage());
        }

        doc.getDocumentElement().normalize();
        System.out.println("Books: ");

        NodeList bookList = doc.getElementsByTagName("book");

        for (int temp = 0; temp < bookList.getLength(); temp++) {
            Element bookElement = (Element) bookList.item(temp);
            String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
            String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
            System.out.println("Title: " + title + ", Author: " + author);
        }
    }
}