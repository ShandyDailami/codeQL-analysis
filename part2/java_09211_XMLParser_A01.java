import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Permission;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_09211_XMLParser_A01 {

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        // Load the XML document
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        // Extract and print book information
        NodeList bookList = doc.getElementsByTagName("book");
        for (int temp = 0; temp < bookList.getLength(); temp++) {
            Document bookDoc = bookList.item(temp).getDocumentElement();
            String bookTitle = bookDoc.getElementsByTagName("title").item(0).getTextContent();
            String bookAuthor = bookDoc.getElementsByTagName("author").item(0).getTextContent();
            String bookYear = bookDoc.getElementsByTagName("year").item(0).getTextContent();

            System.out.println("Title: " + bookTitle);
            System.out.println("Author: " + bookAuthor);
            System.out.println("Year: " + bookYear);
            System.out.println("------------------------");
        }
    }
}