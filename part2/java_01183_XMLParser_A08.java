import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_01183_XMLParser_A08 {

    public List<Book> parseXml(String xmlFilePath) throws FileNotFoundException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Load the XML file
        InputStream inputStream = new FileInputStream(new File(xmlFilePath));
        Document document = builder.parse(inputStream);

        // Retrieve root element
        Element rootElement = document.getDocumentElement();

        // Find all books
        NodeList bookNodes = rootElement.getElementsByTagName("book");

        // Assume each book node represents a book with fields "title", "author", "year"
        List<Book> books = parseBookNodes(bookNodes);

        return books;
    }

    private List<Book> parseBookNodes(NodeList bookNodes) {
        // TODO: Implement book parsing logic
        throw new UnsupportedOperationException();
    }
}