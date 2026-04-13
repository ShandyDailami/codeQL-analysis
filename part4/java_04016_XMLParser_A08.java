import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_04016_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fis);

            // Validate the XML data here using SAX or DOM (or other methods)
            doc.getDocumentElement().normalize();

            System.out.println("XML Parsed Successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
        } catch (IOException e) {
            System.out.println("Error: Unable to read file!");
        } catch (SAXException e) {
            System.out.println("Error: SAXException encountered!");
        }
    }
}