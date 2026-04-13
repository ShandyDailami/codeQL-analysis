import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.security.Policy;
import java.util.logging.Logger;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_15973_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Load the XML file
            File file = new File("books.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            // Print out the XML file
            document.getDocumentElement().normalize();
            System.out.println("Root Element: " + document.getDocumentElement().getNodeName());

            // Start with a SAX parser
            SAXParserHandler handler = new SAXParserHandler();
            SAX.parse(document, handler);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}