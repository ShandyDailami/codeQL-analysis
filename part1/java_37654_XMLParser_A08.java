import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class java_37654_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create an XMLReader
            XMLReader reader = XMLReaderFactory.createXMLReader();

            // Create a new File object for the XML file
            File file = new File("books.xml");

            // Create a new SAXHandler to handle XML events
            SAXHandler handler = new SAXHandler();

            // Set the XMLReader to use the handler as the event handler
            reader.setContentHandler(handler);

            // Parse the XML file
            reader.parse(file);

            // Get the book list from the handler
            List<Book> bookList = handler.getBookList();

            // Print the book list
            for (Book book : bookList) {
                System.out.println(book);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}