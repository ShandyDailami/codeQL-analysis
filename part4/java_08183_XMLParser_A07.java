import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class java_08183_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the XML file
            Document doc = builder.parse(new File("books.xml"));
            // Get the root element of the Document
            Element root = doc.getDocumentElement();
            // Get all child elements of the root element
            NodeList children = root.getChildNodes();
            // Traverse through all child nodes
            for (int i = 0; i < children.getLength(); i++) {
                // Get the i-th child node
                Element child = (Element) children.item(i);
                // Extract data from child nodes
                String title = child.getElementsByTagName("title").item(0).getTextContent();
                String author = child.getElementsByTagName("author").item(0).getTextContent();
                String price = child.getElementsByTagName("price").item(0).getTextContent();
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Price: " + price);
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}