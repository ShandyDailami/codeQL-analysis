import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class java_37282_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("books.xml"));

            doc.getDocumentElement().normalize();

            NodeList bookList = doc.getElementsByTagName("book");

            for (int temp = 0; temp < bookList.getLength(); temp++) {
                Node bookNode = bookList.item(temp);

                Element bookElement = (Element) bookNode;

                String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                String price = bookElement.getElementsByTagName("price").item(0).getTextContent();

                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Price: " + price);
                System.out.println("---------------------");
            }

            dBuilder.detachDocument();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}