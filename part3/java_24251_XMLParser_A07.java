import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.List;
import java.util.ArrayList;

public class java_24251_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("books.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            printBooks(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printBooks(Document doc) {
        NodeList bookList = doc.getElementsByTagName("book");
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < bookList.getLength(); i++) {
            Node bookNode = bookList.item(i);
            books.add(parseBook(bookNode));
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static Book parseBook(Node bookNode) {
        Book book = new Book();
        if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
            Element bookElement = (Element) bookNode;
            book.setId(bookElement.getAttribute("id"));
            book.setTitle(bookElement.getAttribute("title"));
            book.setAuthor(bookElement.getAttribute("author"));
            book.setPrice(bookElement.getAttribute("price"));
        }
        return book;
    }

    public static class Book {
        private String id;
        private String title;
        private String author;
        private String price;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Price: " + price;
        }
    }
}