import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.List;
import java.util.ArrayList;

public class java_09122_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("books.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();
            NodeList bookList = doc.getElementsByTagName("book");

            List<String> bookTitles = new ArrayList<>();
            List<Double> bookPrices = new ArrayList<>();

            for (int temp = 0; temp < bookList.getLength(); temp++) {
                Node bookNode = bookList.item(temp);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;
                    String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                    Double price = Double.parseDouble(bookElement.getElementsByTagName("price").item(0).getTextContent());

                    bookTitles.add(title);
                    bookPrices.add(price);
                }
            }

            System.out.println("Book Titles: " + bookTitles);
            System.out.println("Book Prices: " + bookPrices);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}